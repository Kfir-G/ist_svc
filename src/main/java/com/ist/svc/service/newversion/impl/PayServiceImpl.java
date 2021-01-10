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
                    // 初始化请求微信
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
                        //jsapi支付 验证wxCode是否必填
                        String wxCodeJson = cPayTradeReq.getWxCodeJson();
                        if (StringUtils.isBlank(wxCodeJson)){
                            return ApiBaseResp.result(ResultConstant.PRE_PAY_WX_CODE_EMPTY_ERROR_CODE,ResultConstant.PRE_PAY_WX_CODE_EMPTY_ERROR_MSG);
                        }
                        //通过code获取openId
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

                    // 生成签名sign
                    param.put("sign", genUnifiedSign(param, istConfig.getWeiXinPayAppSecret()));
                    logger.info("param:{}",param.toString());
                    // 组装生成请求微信的XML对象
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
                    // 请求微信统一订单接口
                    String xmlResp = HttpClientUtil.doXmlPost("https://api.mch.weixin.qq.com/pay/unifiedorder", xmlStr.toString());
                    logger.info("TenpayWXServiceImpl.getNativePrepayId xmlReq:{},resp:{}",xmlStr.toString(),xmlResp);
                    // 微信出现异常或返回null
                    if(StringUtils.isEmpty(xmlResp)){
                        return ApiBaseResp.result(ResultConstant.PRE_PAY_WEIXIN_PREPAYID_FAILD_ERROR_CODE,ResultConstant.PRE_PAY_WEIXIN_PREPAYID_FAILD_ERROR_MSG);
                    }else {
                        // 解析微信返回的XML信息
                        Document doc = DocumentHelper.parseText(xmlResp);
                        Element rootElem = doc.getRootElement();
                        String returnCode = rootElem.elementTextTrim("return_code");
                        String resultCode = rootElem.elementTextTrim("result_code");
                        // 微信通信标识及业务处理标识均为SUCCESS
                        if("SUCCESS".equals(returnCode) && "SUCCESS".equals(resultCode))
                        {
                            // 读取相关信息
                            String prepayId = rootElem.elementTextTrim("prepay_id");
                            String nonceStrResp = rootElem.elementTextTrim("nonce_str");
//                            //非APP支付直接返回
//                            if(!"APP".equals(tradeType)){
//                                return ApiBaseResp.succ(weiXinPayRespVo);
//                            }
                            //APP支付
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



                            //再签名
                            String reSign=genUnifiedSign(reSignParam, istConfig.getWeiXinPayAppSecret());
                            reSignParam.put("sign",reSign);
                            //签名参数直接返回给前端支付
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
                    //构造client
                    CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
                    //设置网关地址
                    certAlipayRequest.setServerUrl(ali_gate_way_url);
                    //设置应用Id
                    certAlipayRequest.setAppId(istConfig.getALI_APP_ID());
                    //设置应用私钥
                    certAlipayRequest.setPrivateKey(istConfig.getALI_APP_PRIVATE_KEY());
                    //设置请求格式，固定值json
                    certAlipayRequest.setFormat("json");
                    //设置字符集
                    certAlipayRequest.setCharset(CHARSET);
                    //设置签名类型
                    certAlipayRequest.setSignType("RSA2");
                    //设置应用公钥证书路径
                    certAlipayRequest.setCertPath(istConfig.getAPP_CERT_PATH());
                    //设置支付宝公钥证书路径
                    certAlipayRequest.setAlipayPublicCertPath(istConfig.getALIPAY_CERT_PATH());
                    //设置支付宝根证书路径
                    certAlipayRequest.setRootCertPath(istConfig.getALIPAY_ROOT_CERT_PATH());
                    //构造client
                    AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);

                    //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
                    AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
                    //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
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
                    //这里和普通的接口调用不同，使用的是sdkExecute
                    AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
                    data = response.getBody();//就是orderString 可以直接给客户端请求，无需再做处理。
                    break;
                case 0:
                    //余额支付
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
                    addAcctBookReq.setDescr("余额支付");
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
                default: //可选
                    //语句
            }

            return ApiBaseResp.succ(data);
        } catch (Exception e) {
            logger.error("PayServiceImpl.prePay:", e);
            return ApiBaseResp.result(ResultConstant.APP_ERROR_CODE, ResultConstant.APP_ERROR_MSG);
        }
    }

    /**
     * 获取预支付id
     * @param accessToken
     * @return
     */
    private WeiXinPayRespVo getPrePayId(String accessToken,CPayTradeReq cPayTradeReq) {
        WeiXinPayRespVo weiXinPayRespVo = new WeiXinPayRespVo();
        Map<String,String> param = new HashMap<>();
        param.put("appid", istConfig.getWeiXinPayAppId());
        String traceId = "crestxu_" + System.currentTimeMillis() / 1000;   // traceId 由开发者自定义，可用于订单的查询与跟踪，建议根据支付用户信息生成此id
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
        //成功获取到prepayid
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
     * 生成签名
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
        //去除最后一个&
        sb.append("key=" + appKey);
        logger.info("sign:{}",sb.toString());
        String sign = DigestUtils.md5Hex(sb.toString()).toUpperCase();
        return sign;
    }
    /**
     * 生成签名
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
        //去除最后一个&
        sb = new StringBuilder(StringUtils.substringBeforeLast(sb.toString(), "&"));
        String sha1 = DigestUtils.shaHex(sb.toString());
        return sha1;
    }
    /**
     * 生成订单信息
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

        // 进行md5摘要前，params内容为原始内容，未经过url encode处理
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

    //获取access_token
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
                //支付宝
//                AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",istConfig.getALI_APP_ID(),istConfig.getALI_APP_PRIVATE_KEY(),"json","GBK",istConfig.getALI_APP_PUBLIC_KEY(),"RSA2");
                CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
                //设置网关地址
                certAlipayRequest.setServerUrl("https://openapi.alipay.com/gateway.do");
                //设置应用Id
                certAlipayRequest.setAppId(istConfig.getALI_APP_ID());
                //设置应用私钥
                certAlipayRequest.setPrivateKey(istConfig.getALI_APP_PRIVATE_KEY());
                //设置请求格式，固定值json
                certAlipayRequest.setFormat("json");
                //设置字符集
                certAlipayRequest.setCharset(CHARSET);
                //设置签名类型
                certAlipayRequest.setSignType("RSA2");
                //设置应用公钥证书路径
                certAlipayRequest.setCertPath(istConfig.getAPP_CERT_PATH());
                //设置支付宝公钥证书路径
                certAlipayRequest.setAlipayPublicCertPath(istConfig.getALIPAY_CERT_PATH());
                //设置支付宝根证书路径
                certAlipayRequest.setRootCertPath(istConfig.getALIPAY_ROOT_CERT_PATH());
                //构造client
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
                //微信
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
                addAcctBookReq.setDescr("提现");
                QueryBaseResp queryBaseResp = new QueryBaseResp();
                String transId = accountService.recordAcctBook(addAcctBookReq, queryBaseResp);
                if (queryBaseResp.getCode().equalsIgnoreCase(ResultConstant.SUCCESS_CODE)){
                    if (req.getFee()>0){
                        addAcctBookReq.setDescr("提现手续费");
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
                            "\"order_title\":\"转账\","   +
                            "\"payee_info\":{"   +
                            "\"identity\":\""   + req.getCashNo()+
                            "\",\"identity_type\":\"ALIPAY_LOGON_ID\","   +
                            "\"name\":\""   + req.getName() +
                            "\"    },"   +
                            "\"remark\":\"提现\","   +
                            "\"business_params\":\"{\\\"payer_show_name\\\":\\\"事君科技\\\"}\""   +
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
            //先查是否存在
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
