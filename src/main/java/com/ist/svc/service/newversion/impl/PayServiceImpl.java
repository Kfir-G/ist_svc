package com.ist.svc.service.newversion.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.weixinsdk.MyConfig;
import com.ist.svc.common.weixinsdk.WXPay;
import com.ist.svc.common.weixinsdk.WXPayConfig;
import com.ist.svc.config.IstConfig;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.WxPayNotifyResp;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.CPayTradeReq;
import com.ist.svc.domain.UserAccountBook;
import com.ist.svc.service.AccountService;
import com.ist.svc.service.impl.BaseServiceImpl;
import com.ist.svc.service.newversion.PayService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PayServiceImpl extends BaseServiceImpl implements PayService {
    @Autowired
    private IstConfig istConfig;
    private String CHARSET = "utf-8";
    @Autowired
    private AccountService accountService;

    @Override
    public ApiBaseResp prePay(CPayTradeReq cPayTradeReq) {
        try {
            String data = "";
            Integer payType = cPayTradeReq.getPayType();
            switch (payType) {
                case 1:
                    if (cPayTradeReq.getTradeType().equals(IstEnum.TradeType.JSAPI.getCode())){
                        //jsapi支付 验证wxCode是否必填
                        if (StringUtils.isBlank(cPayTradeReq.getWxCode())){
                            return ApiBaseResp.result(ResultConstant.PRE_PAY_WX_CODE_EMPTY_ERROR_CODE,ResultConstant.PRE_PAY_WX_CODE_EMPTY_ERROR_MSG);
                        }
                        //通过code获取openId


                    }
                    break;
                case 2:
                    //构造client
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
                default: //可选
                    //语句
            }

            return ApiBaseResp.succ(data);
        } catch (AlipayApiException e) {
            logger.error("PayServiceImpl.prePay:", e);
            return ApiBaseResp.result(ResultConstant.APP_ERROR_CODE, ResultConstant.APP_ERROR_MSG);
        }
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

    public static void main(String[] args) {
//        MyConfig myConfig = new MyConfig();
//        WXPay wxPay = new WXPay(myConfig);
//        wxPay.authCodeToOpenid
    }
}
