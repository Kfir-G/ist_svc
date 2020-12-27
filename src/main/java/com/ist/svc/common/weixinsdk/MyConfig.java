package com.ist.svc.common.weixinsdk;


import java.io.InputStream;

public class MyConfig extends WXPayConfig{
    @Override
    String getAppID() {
        return "wx0beddd14c25ee445";
    }

    @Override
    String getMchID() {
        return "";
    }

    @Override
    String getKey() {
        return "bd61a3dce435e4ec8a155d681b9410ff";
    }

    @Override
    InputStream getCertStream() {
        return null;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return null;
    }
}
