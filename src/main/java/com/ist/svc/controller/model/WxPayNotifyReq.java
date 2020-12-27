package com.ist.svc.controller.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: sunhaitao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "xml")
public class WxPayNotifyReq {
    @JacksonXmlProperty(localName = "appid")
    private String appId; //小程序ID
    @JacksonXmlProperty(localName = "mch_id")
    private String mchId;//商户号
    @JacksonXmlProperty(localName = "device_info")
    private String deviceInfo;//微信支付分配的终端设备号
}
