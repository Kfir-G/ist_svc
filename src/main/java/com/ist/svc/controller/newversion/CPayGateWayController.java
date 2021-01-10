package com.ist.svc.controller.newversion;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.controller.BaseController;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.CPayTradeReq;
import com.ist.svc.service.newversion.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "支付网关相关")
public class CPayGateWayController extends BaseController {


    public static void main(String[] args) throws Exception{
//        String CHARSET = "utf-8";
//        String outtradeno = "2020111102";
//        String APP_ID = "2088831934955454";
//        String  APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQChK3BjkxI8fz1j808FtwUT6DpzOREQ1lMQus3AmrAoEO+9K+u8bAgjSZFXJYBZm8cFMV1q8pCRq191tgR51wCGGHMTyABI0PXOgQ29ppcWVy0l6JHvGJXKET6AfNXO7s9ml/+jLusp97cYfIn0P3wEtZBeJSatXBao58TTe0BLbDBefle+RZdCLwozg7D6ZuXEg3osHLuL8zxWfLQJ7dVcuUwrDk/Pv8ZDJyPz6PmPJwBobUve9zBXFqAmvy8Xw1u+SqMLLw3kDuWqsV6kCTfmq5+K6MF1TKKluMa9QYdv9FHRQWPy1B/XkUeSHMmlkPHGiLgIsBDwjkyqe7lmPCWZAgMBAAECggEBAIgjyGDkN7BQjsviF6stKSXisZTo7Ih7clkcYnbCc/C0Nb5m3k8gNlOQbivd6qhG1PuG8nFHimTyDMXCxc8hlTiwaGyaMdtQX4JbMv8zPEbLxsBRzwvXiZfRrykbygNtaFYyKOdv14dwzwHpGSLviVP1Bojv+tbPhfiRJoq5ftr1ovuVnBqStwwCha1k4PgmfGG/SS1BW17RB2ykrKw/2tPj7mqBmvCiR0ODZsm52i45nRHelTm3QejwRpL4ges94VQP/L8NxmuYX/LwCQrjKuMjnVy120ya+H5Sgo4+UGWa8vQ86lzPgtea4ueVukEc2x9LFMx8cBn/qb5x/8nUAc0CgYEA6XeYU0ttxTZw5OfyhSVScm3MaGr+VjrKsLZzMtkw9JHSPlhqIq+gJ2d8g5wDecizJsVpZOgosI7roLQ1oi54z1QDayJBaXJKvMeP6CSnZFpVrAnGVvhAB316Yxw2BvTMytIeVQRVnQa4AHrot+VQ/0oXJoITH1MNbKwBgaYx1mcCgYEAsLmMnbVVPCOkuO7T24HOkcG3EdgnoxC4fvvQ/Sa/KrNHHnpNUvcsfZiT7IiiYIATSZl9nD4GMSq3hBPblkzGqLnK6W396vzAmw5/f9WjraU/3heWRlCIrV8HS4vqtSOYW/FmCOhHlZ4wq8/JVdAkqZK33hkWrpjUS4YY5HPMo/8CgYEAm4h9BiCeBF/8XcLYIjN29ZyILJf60F9iYM9rd1iR8Jykv7wPGQR/YUDkBpmNBzjZgN7LE9pGITlVaD4l7OGgwh5qGJk9ko39lD4udKzWh1hW8sGgTJgdr9+8BQLqS0ASnpvUcTbuAipTsp4vIzO1/hzRx2moa5ncu6Tra//X+8kCgYAZcd3JJz6qdgdViS1/wWTYn6eYLiMm21V1ExS4HkgQAdgPj1RqyaPiQYGq4NFgS5B7XFo1kMibc6cQoTtQnKVNzdJlYazZlKK2sJOy+DOk4NIdTBAa96V2MOSAABk/E2zwcAVc6vTDmg8v7a7zaBCfSbyngb0+TkrixN/4pKOmSQKBgCyL95t9fNw2DCM4MsE72qgFJeoBRqD1HhHgn5OT7C3R003PHFlg3o537N2TKfvzXjgDSD0dBCNjj0QWUWPNn0u9Of3zfionELJdXcODVMs92yHmOHN8IPIYZJki5272EHOq02SBJK+c7keHT8l0QNOlXwpXuFqz8jJQfBzySBDQ";
//        String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoStwY5MSPH89Y/NPBbcFE+g6czkRENZTELrNwJqwKBDvvSvrvGwII0mRVyWAWZvHBTFdavKQkatfdbYEedcAhhhzE8gASND1zoENvaaXFlctJeiR7xiVyhE+gHzVzu7PZpf/oy7rKfe3GHyJ9D98BLWQXiUmrVwWqOfE03tAS2wwXn5XvkWXQi8KM4Ow+mblxIN6LBy7i/M8Vny0Ce3VXLlMKw5Pz7/GQycj8+j5jycAaG1L3vcwVxagJr8vF8NbvkqjCy8N5A7lqrFepAk35qufiujBdUyipbjGvUGHb/RR0UFj8tQf15FHkhzJpZDxxoi4CLAQ8I5Mqnu5ZjwlmQIDAQAB";
//        //实例化客户端
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
////实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
////SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
//        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
//        model.setBody("我是测试数据");
//        model.setSubject("App支付测试Java");
//        model.setOutTradeNo(outtradeno);
//        model.setTimeoutExpress("30m");
//        model.setTotalAmount("0.01");
//        model.setProductCode("QUICK_MSECURITY_PAY");
//        request.setBizModel(model);
//        request.setNotifyUrl("https://brofarm.cn/ist_svc/order/aliPayNotify");
//        try {
//            //这里和普通的接口调用不同，使用的是sdkExecute
//            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
//            System.out.println(response.getMsg());
//            System.out.println(response.toString());//就是orderString 可以直接给客户端请求，无需再做处理。
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
        CPayGateWayController cPayGateWayController = new CPayGateWayController();
        cPayGateWayController.testFundTrans();
    }
    public void testFundTrans() throws AlipayApiException {
        CertAlipayRequest certAlipayRequest   =   new   CertAlipayRequest ();
        certAlipayRequest . setServerUrl ( "https://openapi.alipay.com/gateway.do" );
        certAlipayRequest . setAppId ( "2021002110654311" );
        certAlipayRequest . setPrivateKey ( "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQChK3BjkxI8fz1j808FtwUT6DpzOREQ1lMQus3AmrAoEO+9K+u8bAgjSZFXJYBZm8cFMV1q8pCRq191tgR51wCGGHMTyABI0PXOgQ29ppcWVy0l6JHvGJXKET6AfNXO7s9ml/+jLusp97cYfIn0P3wEtZBeJ\n" +
                "SatXBao58TTe0BLbDBefle+RZdCLwozg7D6ZuXEg3osHLuL8zxWfLQJ7dVcuUwrDk/Pv8ZDJyPz6PmPJwBobUve9zBXFqAmvy8Xw1u+SqMLLw3kDuWqsV6kCTfmq5+K6MF1TKKluMa9QYdv9FHRQWPy1B/XkUeSHMmlkPHGiLgIsBDwjkyqe7lmPCWZAgMBAAECggEBAIgjyGDkN7BQjsviF6stKSXis\n" +
                "ZTo7Ih7clkcYnbCc/C0Nb5m3k8gNlOQbivd6qhG1PuG8nFHimTyDMXCxc8hlTiwaGyaMdtQX4JbMv8zPEbLxsBRzwvXiZfRrykbygNtaFYyKOdv14dwzwHpGSLviVP1Bojv+tbPhfiRJoq5ftr1ovuVnBqStwwCha1k4PgmfGG/SS1BW17RB2ykrKw/2tPj7mqBmvCiR0ODZsm52i45nRHelTm3QejwR\n" +
                "pL4ges94VQP/L8NxmuYX/LwCQrjKuMjnVy120ya+H5Sgo4+UGWa8vQ86lzPgtea4ueVukEc2x9LFMx8cBn/qb5x/8nUAc0CgYEA6XeYU0ttxTZw5OfyhSVScm3MaGr+VjrKsLZzMtkw9JHSPlhqIq+gJ2d8g5wDecizJsVpZOgosI7roLQ1oi54z1QDayJBaXJKvMeP6CSnZFpVrAnGVvhAB316Yxw2B\n" +
                "vTMytIeVQRVnQa4AHrot+VQ/0oXJoITH1MNbKwBgaYx1mcCgYEAsLmMnbVVPCOkuO7T24HOkcG3EdgnoxC4fvvQ/Sa/KrNHHnpNUvcsfZiT7IiiYIATSZl9nD4GMSq3hBPblkzGqLnK6W396vzAmw5/f9WjraU/3heWRlCIrV8HS4vqtSOYW/FmCOhHlZ4wq8/JVdAkqZK33hkWrpjUS4YY5HPMo/8Cg\n" +
                "YEAm4h9BiCeBF/8XcLYIjN29ZyILJf60F9iYM9rd1iR8Jykv7wPGQR/YUDkBpmNBzjZgN7LE9pGITlVaD4l7OGgwh5qGJk9ko39lD4udKzWh1hW8sGgTJgdr9+8BQLqS0ASnpvUcTbuAipTsp4vIzO1/hzRx2moa5ncu6Tra//X+8kCgYAZcd3JJz6qdgdViS1/wWTYn6eYLiMm21V1ExS4HkgQAdgPj\n" +
                "1RqyaPiQYGq4NFgS5B7XFo1kMibc6cQoTtQnKVNzdJlYazZlKK2sJOy+DOk4NIdTBAa96V2MOSAABk/E2zwcAVc6vTDmg8v7a7zaBCfSbyngb0+TkrixN/4pKOmSQKBgCyL95t9fNw2DCM4MsE72qgFJeoBRqD1HhHgn5OT7C3R003PHFlg3o537N2TKfvzXjgDSD0dBCNjj0QWUWPNn0u9Of3zfionE\n" +
                "LJdXcODVMs92yHmOHN8IPIYZJki5272EHOq02SBJK+c7keHT8l0QNOlXwpXuFqz8jJQfBzySBDQ" );
        certAlipayRequest . setFormat ( "json" );
        certAlipayRequest . setCharset ( "utf-8" );
        certAlipayRequest . setSignType ( "RSA2" );
        certAlipayRequest . setCertPath ( "G:\\tysxback\\资料\\2020\\lg\\ali\\appCertPublicKey_2021002108693258.crt" );
        certAlipayRequest . setAlipayPublicCertPath ( "G:\\tysxback\\资料\\2020\\lg\\ali\\alipayCertPublicKey_RSA2.crt" );
        certAlipayRequest . setRootCertPath ( "G:\\tysxback\\资料\\2020\\lg\\ali\\alipayRootCert.crt" );
        DefaultAlipayClient   alipayClient   =   new   DefaultAlipayClient(certAlipayRequest);
        AlipayFundTransUniTransferRequest   request   =   new AlipayFundTransUniTransferRequest();
        request . setBizContent ( "{"   +
                "\"out_biz_no\":\"201806300001\","   +
                "\"trans_amount\":1.68,"   +
                "\"product_code\":\"TRANS_ACCOUNT_NO_PWD\","   +
                "\"biz_scene\":\"DIRECT_TRANSFER\","   +
                "\"order_title\":\"201905代发\","   +
                "\"payee_info\":{"   +
                "\"identity\":\"13823366732\","   +
                "\"identity_type\":\"ALIPAY_LOGON_ID\","   +
                "\"name\":\"孙海涛\","   +
                "    },"   +
                "\"remark\":\"201905代发\","   +
                "\"business_params\":\"{\\\"payer_show_name\\\":\\\"服务代理\\\"}\","   +
                "  }" );
        AlipayFundTransUniTransferResponse response   =   alipayClient . certificateExecute ( request );
        if ( response . isSuccess ()){
            System . out . println ( "调用成功" );
        }  else  {
            System . out . println ( "调用失败" );
        }

    }
}
