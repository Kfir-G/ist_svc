package com.ist.svc.service.newversion.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.*;
import com.ist.svc.config.IstConfig;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.AddAcctBookReq;
import com.ist.svc.controller.model.BaseResp;
import com.ist.svc.controller.model.QueryBaseResp;
import com.ist.svc.controller.model.WxPayNotifyResp;
import com.ist.svc.controller.model.dto.*;
import com.ist.svc.dao.UserAcctCashdownMapper;
import com.ist.svc.domain.UserAccountBook;
import com.ist.svc.domain.UserAcctCashdown;
import com.ist.svc.domain.UserAcctCashdownExample;
import com.ist.svc.service.AccountService;
import com.ist.svc.service.UserService;
import com.ist.svc.service.impl.BaseServiceImpl;
import com.ist.svc.service.newversion.PayService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Service
public class PayServiceImpl extends BaseServiceImpl implements PayService {
    @Autowired
    private IstConfig istConfig;
    private String CHARSET = "utf-8";
    private static final String ali_gate_way_url = "https://openapi.alipay.com/gateway.do";
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserAcctCashdownMapper userAcctCashdownMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private WXUtil wxUtil;

    @Override
    public ApiBaseResp prePay(CPayTradeReq cPayTradeReq) {
        try {
            String data = "";
            Integer payType = cPayTradeReq.getPayType();
            switch (payType) {
                case 1:
                    // ?????????????????????
                    String  tradeType = cPayTradeReq.getTradeType();
                    Map<String,String> param = new HashMap<>();
                    param.put("mch_id", istConfig.getWeiXinPayMchId());
                    String nonceStr = DigestUtils.md5Hex(String.valueOf(Math.random()));
                    param.put("nonce_str", nonceStr);
                    param.put("body", cPayTradeReq.getSubject());
                    param.put("out_trade_no", cPayTradeReq.getOutTradeNo());
                    param.put("total_fee", cPayTradeReq.getTotalAmount().longValue()*100+"");
                    param.put("spbill_create_ip", "192.168.1.1");
                    param.put("notify_url", istConfig.getWeiXinPayNotifyUrl());
                    param.put("trade_type", tradeType);
                    String packageValue="Sign=WXPay";
                    if (tradeType.equals(IstEnum.TradeType.JSAPI.getCode())){
                        param.put("appid", istConfig.getWeixinSnsAppId());
                        //jsapi?????? ??????wxCode????????????
                        String wxCodeJson = cPayTradeReq.getWxCodeJson();
                        if (StringUtils.isBlank(wxCodeJson)){
                            return ApiBaseResp.result(ResultConstant.PRE_PAY_WX_CODE_EMPTY_ERROR_CODE,ResultConstant.PRE_PAY_WX_CODE_EMPTY_ERROR_MSG);
                        }
                        //??????code??????openId
                        String openId = cPayTradeReq.getOpenId();
                        if (StringUtils.isBlank(openId)){
                            JSONObject wxCodeJsonObject = JSONObject.parseObject(wxCodeJson);
                            String weixinCode = wxCodeJsonObject.getString("code");
                            JSONObject sessionKeyOropenid = wxUtil.getSessionKeyOropenid(weixinCode);
                            logger.info("getSessionKeyOropenid req:{} resp:{}",weixinCode,sessionKeyOropenid);
                            openId = sessionKeyOropenid.getString("openid");
                        }
                        param.put("openid", openId);
                    }else{
                        param.put("appid", istConfig.getWeiXinPayAppId());
                    }

                    // ????????????sign
                    param.put("sign", genUnifiedSign(param, istConfig.getWeiXinPayAppSecret()));
                    logger.info("param:{}",param.toString());
                    // ???????????????????????????XML??????
                    StringBuffer xmlStr = new StringBuffer("<xml>");
                    xmlStr.append("<appid><![CDATA["+param.get("appid")+"]]></appid>");
                    xmlStr.append("<mch_id><![CDATA["+param.get("mch_id")+"]]></mch_id>");
                    xmlStr.append("<nonce_str><![CDATA["+param.get("nonce_str")+"]]></nonce_str>");
                    xmlStr.append("<body><![CDATA["+param.get("body")+"]]></body>");
                    xmlStr.append("<out_trade_no><![CDATA["+param.get("out_trade_no")+"]]></out_trade_no>");
                    xmlStr.append("<total_fee><![CDATA["+param.get("total_fee")+"]]></total_fee>");
                    xmlStr.append("<spbill_create_ip><![CDATA["+param.get("spbill_create_ip")+"]]></spbill_create_ip>");
                    xmlStr.append("<notify_url><![CDATA["+param.get("notify_url")+"]]></notify_url>");
                    xmlStr.append("<trade_type><![CDATA["+param.get("trade_type")+"]]></trade_type>");
                    if (param.containsKey("openid")){
                        xmlStr.append("<openid><![CDATA["+param.get("openid")+"]]></openid>");
                    }
                    xmlStr.append("<sign><![CDATA["+param.get("sign")+"]]></sign>");
                    xmlStr.append("</xml>");
                    // ??????????????????????????????
                    String xmlResp = HttpClientUtil.doXmlPost("https://api.mch.weixin.qq.com/pay/unifiedorder", xmlStr.toString());
                    logger.info("TenpayWXServiceImpl.getNativePrepayId xmlReq:{},resp:{}",xmlStr.toString(),xmlResp);
                    // ???????????????????????????null
                    if(StringUtils.isEmpty(xmlResp)){
                        return ApiBaseResp.result(ResultConstant.PRE_PAY_WEIXIN_PREPAYID_FAILD_ERROR_CODE,ResultConstant.PRE_PAY_WEIXIN_PREPAYID_FAILD_ERROR_MSG);
                    }else {
                        // ?????????????????????XML??????
                        Document doc = DocumentHelper.parseText(xmlResp);
                        Element rootElem = doc.getRootElement();
                        String returnCode = rootElem.elementTextTrim("return_code");
                        String resultCode = rootElem.elementTextTrim("result_code");
                        // ?????????????????????????????????????????????SUCCESS
                        if("SUCCESS".equals(returnCode) && "SUCCESS".equals(resultCode))
                        {
                            // ??????????????????
                            String prepayId = rootElem.elementTextTrim("prepay_id");
                            String nonceStrResp = rootElem.elementTextTrim("nonce_str");
//                            //???APP??????????????????
//                            if(!"APP".equals(tradeType)){
//                                return ApiBaseResp.succ(weiXinPayRespVo);
//                            }
                            //APP??????
                            Map<String,String> reSignParam = new HashMap<String,String>();

                            String timeStamp=(System.currentTimeMillis() / 1000)+"";
                            if (tradeType.equalsIgnoreCase(IstEnum.TradeType.APP.getCode())){
                                reSignParam.put("appid", rootElem.elementTextTrim("appid"));
                                reSignParam.put("partnerid", istConfig.getWeiXinPayMchId());
                                reSignParam.put("prepayid", prepayId);
                                reSignParam.put("package", packageValue);
                                reSignParam.put("noncestr", nonceStrResp);
                                reSignParam.put("timestamp", timeStamp);
                            }
                            else if (cPayTradeReq.getTradeType().equals(IstEnum.TradeType.JSAPI.getCode())){
                                reSignParam.put("appId", rootElem.elementTextTrim("appid"));
                                packageValue="prepay_id=" + prepayId;
                                reSignParam.put("signType", "MD5");
                                reSignParam.put("package", packageValue);
                                reSignParam.put("nonceStr", nonceStrResp);
                                reSignParam.put("timeStamp", timeStamp);
                            }



                            //?????????
                            String reSign=genUnifiedSign(reSignParam, istConfig.getWeiXinPayAppSecret());
                            reSignParam.put("sign",reSign);
                            //???????????????????????????????????????
//                            WeiXinPayRespVo weiXinPayRespVo = new WeiXinPayRespVo();
//                            weiXinPayRespVo.setPrePayId(prepayId);
//                            weiXinPayRespVo.setNonceStr(nonceStrResp);
//                            weiXinPayRespVo.setPackageValue(packageValue);
//                            weiXinPayRespVo.setTimeStamp(timeStamp);
//                            weiXinPayRespVo.setSign(reSign);
//                            weiXinPayRespVo.setAppId(rootElem.elementTextTrim("appid"));
//                            weiXinPayRespVo.setPartnerId(istConfig.getWeiXinPayMchId());
                            return ApiBaseResp.succ(reSignParam);
                        }
                        else
                        {
                            String errCodeDes = rootElem.elementTextTrim("err_code_des");
                            if (StringUtils.isNoneBlank(errCodeDes)){
                                return ApiBaseResp.result(ResultConstant.PRE_PAY_WEIXIN_PREPAYID_FAILD_ERROR_CODE,ResultConstant.PRE_PAY_WEIXIN_PREPAYID_FAILD_ERROR_MSG + errCodeDes);
                            }
                            return ApiBaseResp.result(ResultConstant.PRE_PAY_WEIXIN_PREPAYID_FAILD_ERROR_CODE,ResultConstant.PRE_PAY_WEIXIN_PREPAYID_FAILD_ERROR_MSG + rootElem.elementTextTrim("return_msg"));
                        }
                    }
                case 2:
                    //??????client
                    CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
                    //??????????????????
                    certAlipayRequest.setServerUrl(ali_gate_way_url);
                    //????????????Id
                    certAlipayRequest.setAppId(istConfig.getALI_APP_ID());
                    //??????????????????
                    certAlipayRequest.setPrivateKey(istConfig.getALI_APP_PRIVATE_KEY());
                    //??????????????????????????????json
                    certAlipayRequest.setFormat("json");
                    //???????????????
                    certAlipayRequest.setCharset(CHARSET);
                    //??????????????????
                    certAlipayRequest.setSignType("RSA2");
                    //??????????????????????????????
                    certAlipayRequest.setCertPath(istConfig.getAPP_CERT_PATH());
                    //?????????????????????????????????
                    certAlipayRequest.setAlipayPublicCertPath(istConfig.getALIPAY_CERT_PATH());
                    //??????????????????????????????
                    certAlipayRequest.setRootCertPath(istConfig.getALIPAY_ROOT_CERT_PATH());
                    //??????client
                    AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);

                    //???????????????API?????????request???,??????????????????????????????,???????????????????????????alipay.trade.app.pay
                    AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
                    //SDK????????????????????????????????????????????????????????????????????????????????????sdk???model????????????(model???biz_content???????????????????????????biz_content)???
                    AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
                    if (StringUtils.isNotBlank(cPayTradeReq.getBody())) {
                        model.setBody(cPayTradeReq.getBody());
                    }
                    model.setSubject(cPayTradeReq.getSubject());
                    model.setOutTradeNo(cPayTradeReq.getOutTradeNo());
                    model.setTimeoutExpress("30m");
                    model.setTotalAmount(cPayTradeReq.getTotalAmount().toString());
                    model.setProductCode("QUICK_MSECURITY_PAY");
                    request.setBizModel(model);
                    request.setNotifyUrl(istConfig.getALI_NOTIFY_URL());
                    //???????????????????????????????????????????????????sdkExecute
                    AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
                    data = response.getBody();//??????orderString ??????????????????????????????????????????????????????
                    break;
                case 0:
                    //????????????
                    AddAcctBookReq addAcctBookReq = new AddAcctBookReq();
                    addAcctBookReq.setDirect(2);
                    addAcctBookReq.setUserId(cPayTradeReq.getUserId());
                    addAcctBookReq.setMoney(cPayTradeReq.getTotalAmount().floatValue());
                    addAcctBookReq.setAcctType(IstEnum.AcctType.CASH.getType());
                    addAcctBookReq.setOptUserId(cPayTradeReq.getUserId());
                    addAcctBookReq.setPayType(IstEnum.PayType.INSIDE.getCode());
                    addAcctBookReq.setOrderId(cPayTradeReq.getOutTradeNo());
                    addAcctBookReq.setStatus(IstEnum.AcctBookStatus.PAY_FINISH.getStatus().intValue());
                    addAcctBookReq.setBizType((int) IstEnum.BookBizType.BALANCE_PAY.getCode());
                    addAcctBookReq.setDescr("????????????");
                    QueryBaseResp queryBaseResp = new QueryBaseResp();
                    queryBaseResp.setCode(ResultConstant.SUCCESS_CODE);
                    accountService.recordAcctBook(addAcctBookReq, queryBaseResp);
                    if (queryBaseResp.getCode().equalsIgnoreCase(ResultConstant.SUCCESS_CODE)){
                        WxPayNotifyResp resp = new WxPayNotifyResp();
                        resp.setReturnCode(ResultConstant.WEIXIN_NOTIFY_SUCC_CODE);
                        resp.setReturnMsg(ResultConstant.WEIXIN_NOTIFY_SUCC_MSG);
                        accountService.orderPayFinishBack(resp, cPayTradeReq.getOutTradeNo(), null, null);
                        return ApiBaseResp.succ(null);
                    }else {
                        return ApiBaseResp.result(queryBaseResp.getCode(),queryBaseResp.getMsg());
                    }
                default: //??????
                    //??????
            }

            return ApiBaseResp.succ(data);
        } catch (Exception e) {
            logger.error("PayServiceImpl.prePay:", e);
            return ApiBaseResp.result(ResultConstant.APP_ERROR_CODE, ResultConstant.APP_ERROR_MSG);
        }
    }

    /**
     * ???????????????id
     * @param accessToken
     * @return
     */
    private WeiXinPayRespVo getPrePayId(String accessToken,CPayTradeReq cPayTradeReq) {
        WeiXinPayRespVo weiXinPayRespVo = new WeiXinPayRespVo();
        Map<String,String> param = new HashMap<>();
        param.put("appid", istConfig.getWeiXinPayAppId());
        String traceId = "crestxu_" + System.currentTimeMillis() / 1000;   // traceId ???????????????????????????????????????????????????????????????????????????????????????????????????id
        param.put("traceid", traceId);
        String nonceStr = DigestUtils.md5Hex(String.valueOf(Math.random()));
        param.put("noncestr", nonceStr);

        Map<String,String> packageParams = new LinkedHashMap<String,String>();
        packageParams.put("bank_type", "WX");
        packageParams.put("body", cPayTradeReq.getSubject());
        packageParams.put("fee_type", "1");
        packageParams.put("input_charset", "UTF-8");
        packageParams.put("notify_url", istConfig.getWeiXinPayNotifyUrl());
        packageParams.put("out_trade_no", cPayTradeReq.getOutTradeNo());
        packageParams.put("partner", istConfig.getWeiXinPayMchId());
//        packageParams.put("spbill_create_ip", "192.168.1.1");
        packageParams.put("total_fee", cPayTradeReq.getTotalAmount().longValue()+"");
        String packageValue = genPackage(packageParams);
        param.put("package", packageValue);
        String timeStamp=(System.currentTimeMillis() / 1000)+"";
        param.put("timestamp",timeStamp);
        Map<String,String> signParams = new LinkedHashMap<String,String>();
        signParams.put("appid", istConfig.getWeiXinPayAppId());
        signParams.put("appkey", istConfig.getWeiXinPayAppSecret());
        signParams.put("noncestr", nonceStr);
        signParams.put("package", packageValue);
        signParams.put("timestamp", String.valueOf(timeStamp));
        signParams.put("traceid", traceId);

        param.put("app_signature", genSign(signParams));
        param.put("sign_method", "sha1");
        logger.info("Get prepayid post entity "+param.toString());
        String url = String.format(istConfig.getWeiXinPayPrepayUrl(), accessToken);
        String content = HttpClientUtil.jsonPost(url,param);
        if(StringUtils.isEmpty(content)){
            return null;
        }
        Map<String, Object> json= JsonUtil.parseJSON2Map(content);
        //???????????????prepayid
        if(StringUtils.isNotEmpty((String)json.get("prepayid"))){
            weiXinPayRespVo.setNonceStr(nonceStr);
            weiXinPayRespVo.setPackageValue("Sign=Wxpay");
            weiXinPayRespVo.setTimeStamp(String.valueOf(timeStamp));
            weiXinPayRespVo.setPrePayId((String)json.get("prepayid"));
            return weiXinPayRespVo;
        }
        return null;
    }
    /**
     * ????????????
     * @param param
     * @return
     */
    public String genUnifiedSign(Map<String,String> param, String appKey) {
        List<String> keyList = new ArrayList<String>(param.keySet());
        Collections.sort(keyList);
        StringBuilder sb = new StringBuilder();
        for (String key : keyList) {
            if(!key.equals("time") && !key.equals("sign")){
                String value = param.get(key);
                sb.append(key+"="+value+"&");
            }
        }
        //??????????????????&
        sb.append("key=" + appKey);
        logger.info("sign:{}",sb.toString());
        String sign = DigestUtils.md5Hex(sb.toString()).toUpperCase();
        return sign;
    }
    /**
     * ????????????
     * @param param
     * @return
     */
    private String genSign(Map<String,String> param) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,String> entry:param.entrySet()){
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            sb.append('&');
        }
        //??????????????????&
        sb = new StringBuilder(StringUtils.substringBeforeLast(sb.toString(), "&"));
        String sha1 = DigestUtils.shaHex(sb.toString());
        return sha1;
    }
    /**
     * ??????????????????
     * @param param
     * @return
     */
    private String genPackage(Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String,String> entry:param.entrySet()){
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            sb.append('&');
        }
        sb.append("key=");
        sb.append(istConfig.getWeiXinPayAppSecret());

        // ??????md5????????????params?????????????????????????????????url encode??????
        String packageSign = DigestUtils.md5Hex(sb.toString().getBytes()).toUpperCase();

        sb = new StringBuilder();
        try {
            for(Map.Entry<String,String> entry:param.entrySet()){
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), "utf-8"));
                sb.append('&');
            }
            sb.append("sign=");
            sb.append(packageSign);
        } catch (UnsupportedEncodingException e) {
            super.logger.error("PayService.genPackage error:::",e);
        }
        return sb.toString();
    }

    //??????access_token
    private String getAccessToken(){
        String url = String.format(istConfig.getWeiXinPayAccessUrl(),istConfig.getWeiXinPayAppId(),istConfig.getWeiXinPayAppSecret());
        String result = HttpUtil.doGet(url, null);
        JSONObject jsonObject = JSON.parseObject(result);
        logger.info("result:{}",result);
        return jsonObject.getString("access_token");
    }
    @Override
    public String aliPayNotify(Map<String, String> params) {
        try {
            boolean flag = AlipaySignature.rsaCertCheckV1(params, istConfig.getALIPAY_CERT_PATH(), CHARSET, "RSA2");
            if (flag){
                String tradeStatus = params.get("trade_status");
                String transId =  params.get("out_trade_no");
                String tradeNo =  params.get("trade_no");
                String otherAcct = params.get("buyer_id");
                WxPayNotifyResp resp = new WxPayNotifyResp();
                resp.setReturnCode(ResultConstant.WEIXIN_NOTIFY_SUCC_CODE);
                resp.setReturnMsg(ResultConstant.WEIXIN_NOTIFY_SUCC_MSG);
                if ("TRADE_SUCCESS".equals(tradeStatus) || "TRADE_FINISHED".equals(tradeStatus)){
                    accountService.orderPayFinishBack(resp, transId, tradeNo, otherAcct);
                }else {
                    logger.warn("tradeStatus:{}",tradeStatus);
                }
                return "success";
            }else {
                logger.warn("rsaCertCheckV1 false");
                return "fail";
            }
        } catch (Exception e) {
            logger.error("PayServiceImpl.aliPayNotify:", e);
            return "fail";
        }
    }

    @Override
    public boolean tradeQuery(UserAccountBook userAccountBook, Integer payType) throws AlipayApiException {
        boolean isPayFinish = false;
        switch (payType){
            case 2:
                //?????????
//                AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",istConfig.getALI_APP_ID(),istConfig.getALI_APP_PRIVATE_KEY(),"json","GBK",istConfig.getALI_APP_PUBLIC_KEY(),"RSA2");
                CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
                //??????????????????
                certAlipayRequest.setServerUrl("https://openapi.alipay.com/gateway.do");
                //????????????Id
                certAlipayRequest.setAppId(istConfig.getALI_APP_ID());
                //??????????????????
                certAlipayRequest.setPrivateKey(istConfig.getALI_APP_PRIVATE_KEY());
                //??????????????????????????????json
                certAlipayRequest.setFormat("json");
                //???????????????
                certAlipayRequest.setCharset(CHARSET);
                //??????????????????
                certAlipayRequest.setSignType("RSA2");
                //??????????????????????????????
                certAlipayRequest.setCertPath(istConfig.getAPP_CERT_PATH());
                //?????????????????????????????????
                certAlipayRequest.setAlipayPublicCertPath(istConfig.getALIPAY_CERT_PATH());
                //??????????????????????????????
                certAlipayRequest.setRootCertPath(istConfig.getALIPAY_ROOT_CERT_PATH());
                //??????client
                AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
                AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
                request.setBizContent("{\"out_trade_no\":\""+userAccountBook.getTransid()+"\"}");
                AlipayTradeQueryResponse response = alipayClient.certificateExecute(request);
                logger.info("tradeQuery:"  + response.getBody());
                String tradeStatus = response.getTradeStatus();
                if(response.isSuccess() && ("TRADE_SUCCESS".equals(tradeStatus) || "TRADE_FINISHED".equals(tradeStatus))){
                    String otherOrder = response.getTradeNo();
                    String otherAcct=  response.getBuyerUserId();
                    accountService.updateUserAccountAndOrderStatusToFinish(otherOrder,otherAcct,userAccountBook);
                    isPayFinish = true;
                }
                break;
            case 1:

//                try {
//                    MyConfig config = new MyConfig();
//                    WXPay wxpay = new WXPay(config);
//
//                    Map<String, String> data = new HashMap<String, String>();
//                    data.put("out_trade_no", "2016090910595900000012");
//                    Map<String, String> resp = wxpay.orderQuery(data);
//                    System.out.println(resp);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                //??????
                break;
        }
        return isPayFinish;
    }

    @Override
    public BaseResp cashDown(CashDownReq req) throws AlipayApiException{
        Integer type = req.getType();
        switch (type){
            case 2:
                AddAcctBookReq addAcctBookReq = new AddAcctBookReq();
                addAcctBookReq.setDirect(2);
                addAcctBookReq.setUserId(req.getUserId());
                addAcctBookReq.setMoney(req.getMoney().floatValue());
                addAcctBookReq.setAcctType(IstEnum.AcctType.CASH.getType());
                addAcctBookReq.setOptUserId(req.getUserId());
                addAcctBookReq.setPayType(IstEnum.PayType.INSIDE.getCode());
                addAcctBookReq.setOrderId("0");
                addAcctBookReq.setStatus(IstEnum.AcctBookStatus.PAY_FINISH.getStatus().intValue());
                addAcctBookReq.setBizType((int) IstEnum.BookBizType.CASH_DOWN.getCode());
                addAcctBookReq.setDescr("??????");
                QueryBaseResp queryBaseResp = new QueryBaseResp();
                String transId = accountService.recordAcctBook(addAcctBookReq, queryBaseResp);
                if (queryBaseResp.getCode().equalsIgnoreCase(ResultConstant.SUCCESS_CODE)){
                    if (req.getFee()>0){
                        addAcctBookReq.setDescr("???????????????");
                        addAcctBookReq.setMoney(req.getFee().floatValue());
                        accountService.recordAcctBook(addAcctBookReq, queryBaseResp);
                    }
                    CertAlipayRequest certAlipayRequest   =   new   CertAlipayRequest ();
                    certAlipayRequest.setServerUrl(ali_gate_way_url);
                    certAlipayRequest.setAppId(istConfig.getALI_APP_ID());
                    certAlipayRequest.setPrivateKey (istConfig.getALI_APP_PRIVATE_KEY());
                    certAlipayRequest.setFormat("json");
                    certAlipayRequest.setCharset(CHARSET);
                    certAlipayRequest.setSignType("RSA2");
                    certAlipayRequest.setCertPath(istConfig.getAPP_CERT_PATH());
                    certAlipayRequest.setAlipayPublicCertPath (istConfig.getALIPAY_CERT_PATH());
                    certAlipayRequest.setRootCertPath (istConfig.getALIPAY_ROOT_CERT_PATH());
                    DefaultAlipayClient   alipayClient = new  DefaultAlipayClient(certAlipayRequest);
                    AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
                    request.setBizContent ( "{"   +
                            "\"out_biz_no\":\""  + transId +
                            "\",\"trans_amount\":\""   + req.getMoney() +
                            "\",\"product_code\":\"TRANS_ACCOUNT_NO_PWD\","   +
                            "\"biz_scene\":\"DIRECT_TRANSFER\","   +
                            "\"order_title\":\"??????\","   +
                            "\"payee_info\":{"   +
                            "\"identity\":\""   + req.getCashNo()+
                            "\",\"identity_type\":\"ALIPAY_LOGON_ID\","   +
                            "\"name\":\""   + req.getName() +
                            "\"    },"   +
                            "\"remark\":\"??????\","   +
                            "\"business_params\":\"{\\\"payer_show_name\\\":\\\"????????????\\\"}\""   +
                            "  }" );
                    AlipayFundTransUniTransferResponse response = alipayClient.certificateExecute(request);
                    if (response.isSuccess()){
                        return BaseResp.ok();
                    }else {
                        return BaseResp.result(response.getCode(),response.getMsg());
                    }
                }else {
                    BaseResp.result(queryBaseResp.getCode(),queryBaseResp.getMsg());
                }

        }

        return null;
    }

    @Override
    public ApiBaseResp queryCashdownInfo(QueryCashdownInfoReq req) {
        UserAcctCashdownExample example = new UserAcctCashdownExample();
        UserAcctCashdownExample.Criteria criteria = example.createCriteria();
        criteria.andOwnUserIdEqualTo(Long.valueOf(req.getUserId()));
        criteria.andTypeEqualTo(req.getType().shortValue());
        List<UserAcctCashdown> userAcctCashdowns = userAcctCashdownMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(userAcctCashdowns)){
            QueryCashdownInfoVo queryCashdownInfoVo = IstBeanUtil.copy(userAcctCashdowns.get(0), QueryCashdownInfoVo.class);
            return ApiBaseResp.succ(queryCashdownInfoVo);
        }
        return ApiBaseResp.succ(null);
    }

    @Override
    public BaseResp cashNoBind(CashNoBindReq req) {
        VerifyValidSmsReq verifyValidSmsReq = new VerifyValidSmsReq();
        verifyValidSmsReq.setPhoneNum(req.getPhoneNum());
        verifyValidSmsReq.setValidCode(req.getSmsCode());
        BaseResp resp = new BaseResp();
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
        userService.verifyValidSmsCode(verifyValidSmsReq,resp);
        if (ResultConstant.SUCCESS_CODE.equalsIgnoreCase(resp.getCode())){
            //??????????????????
            UserAcctCashdownExample example = new UserAcctCashdownExample();
            UserAcctCashdownExample.Criteria criteria = example.createCriteria();
            criteria.andTypeEqualTo(req.getType().shortValue());
            criteria.andCashNoEqualTo(req.getCashNo());
            List<UserAcctCashdown> userAcctCashdowns = userAcctCashdownMapper.selectByExample(example);
            if (CollectionUtils.isNotEmpty(userAcctCashdowns)){
                return BaseResp.result(ResultConstant.USER_CASH_ACCT_BIND_EXIST_ERROR_CODE,ResultConstant.USER_CASH_ACCT_BIND_EXIST_ERROR_MSG);
            }
            UserAcctCashdown userAcctCashdown = new UserAcctCashdown();
            userAcctCashdown.setCashNo(req.getCashNo());
            userAcctCashdown.setName(req.getName());
            userAcctCashdown.setOwnUserId(Long.valueOf(req.getUserId()));
            userAcctCashdown.setRate(0f);
            userAcctCashdown.setStatus(IstEnum.CashNoStatus.NORMAL.getStatus());
            Date now = new Date();
            userAcctCashdown.setCreateTime(now);
            userAcctCashdown.setUpdateTime(now);
            userAcctCashdown.setType(IstEnum.PayType.ALIPAY.getCode().shortValue());
            Integer type = req.getType();
            switch (type){
                case 2:
                    userAcctCashdown.setFreeMoney(200f);
                    userAcctCashdown.setSumMoney(0f);
                    userAcctCashdown.setRate(0.005f);
                    break;
            }

            userAcctCashdownMapper.insert(userAcctCashdown);
        }else {
            return BaseResp.result(resp.getCode(),resp.getMsg());
        }

        return BaseResp.ok();
    }

    public static void main(String[] args) {
//        MyConfig myConfig = new MyConfig();
//        WXPay wxPay = new WXPay(myConfig);
//        wxPay.authCodeToOpenid
    }
}
