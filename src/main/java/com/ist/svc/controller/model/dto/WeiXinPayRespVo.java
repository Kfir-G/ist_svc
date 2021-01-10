package com.ist.svc.controller.model.dto;

import lombok.Data;

/**
 * @Author: sunhaitao
 */
@Data
public class WeiXinPayRespVo {
    //随机数32位
    private String nonceStr;
    //订单详情
    private String packageValue;
    //预支付订单号
    private String prePayId;
    //时间戳
    private String timeStamp;
    //签名
    private String sign;
    private String appId;
    private String partnerId;
}
