package com.ist.svc.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
public class IstConfig {
    //微信小程序
    @Value("${weixin.sns.url}")
    private String weixinSnsUrl;
    @Value("${weixin.sns.appId}")
    private String weixinSnsAppId;
    @Value("${weixin.sns.appSecret}")
    private String weixinSnsAppSecret;
    @Value("${weixin.sns.grantType}")
    private String weixinSnsGrantType;

    //微信app支付
    @Value("${weixin.pay.appId}")
    private String weiXinPayAppId;
    @Value("${weixin.pay.appSecret}")
    private String weiXinPayAppSecret;
    @Value("${weixin.pay.access_url}")
    private String weiXinPayAccessUrl;
    @Value("${weixin.pay.prepay_url}")
    private String weiXinPayPrepayUrl;
    @Value("${weixin.pay.notify_url}")
    private String weiXinPayNotifyUrl;
    @Value("${weixin.pay.mchId}")
    private String weiXinPayMchId;
    @Value("${weixin.app.appId}")
    private String weiXinAppId;
    @Value("${weixin.app.appSecret}")
    private String weiXinAppSecret;
    @Value("${weixin.app.access_url}")
    private String weiXinAppAccessUrl;
    @Value("${weixin.app.userInfo_url}")
    private String weiXinAppUserInfoUrl;

    @Value("${nginx.public.uri}")
    private String nginxPublicUri;
    @Value("${spring.profiles.active}")
    private String springProfilesActive;
    @Value("${server.port}")
    private String serverPort;
    @Value("${upload.path.bak}")
    private String uploadPathBak;
    @Value("${upload.path.temp}")
    private String uploadPathTemp;
    @Value("${weixin.pay.notifyKey}")
    private String wxNotifyKey;

    @Value("${ali.appId}")
    private String ALI_APP_ID;
    @Value("${ali.appPrivateKey}")
    private String ALI_APP_PRIVATE_KEY;
    @Value("${ali.appPublicKey}")
    private String ALI_APP_PUBLIC_KEY;
    @Value("${ali.notifyUrl}")
    private String ALI_NOTIFY_URL;
    @Value("${ali.appCertPath}")
    private String APP_CERT_PATH;
    @Value("${ali.alipayCertPath}")
    private String ALIPAY_CERT_PATH;
    @Value("${ali.alipayRootCertPath}")
    private String ALIPAY_ROOT_CERT_PATH;
    @Value("${sms.validCodeTemplateId}")
    private String smsValidCodeTemplateId;
    @Value("${sms.appId}")
    private String smsAppId;
    @Value("${sms.appKey}")
    private String smsAppKey;
    @Value("${sms.sign}")
    private String smsSign;
    @Value("${sms.secretId}")
    private String smsSecretId;
    @Value("${sms.secretKey}")
    private String smsSecretKey;
}
