package com.ist.svc.controller.model.dto;

import com.ist.svc.controller.model.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ApiModel(description = "支付请求对象")
public class CPayTradeReq extends BaseReq {
    @NotBlank(message = "外部订单号(outTradeNo)不能为空")
    @ApiModelProperty(value = "外部订单号(outTradeNo)")
    private String outTradeNo;  //外部订单号
    @NotNull(message = "支付金额不能为空")
    @ApiModelProperty(value = "支付金额(totalAmount)")
    private Double totalAmount; //单位元
    @ApiModelProperty(value = "描述信息(body)")
    private String body;
    @NotBlank(message = "商品标题(subject)不能为空")
    @ApiModelProperty(value = "商品标题(subject)")
    private String subject;
    @NotNull(message = "支付来源(payType)不能为空")
    @ApiModelProperty(value = "支付来源(payType)",notes = "1微信 2支付宝",name = "ss")
    private Integer payType;//支付来源
    @NotNull(message = "交易类型(tradeType)不能为空")
    @ApiModelProperty(value = "交易类型(tradeType),",notes = "JSAPI -JSAPI支付 APP -APP支付")
    private String tradeType;
    @NotBlank(message = "用户(userId)不能为空")
    @ApiModelProperty(value = "用户(userId)")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    @ApiModelProperty(value = "登陆令牌(tokenId)")
    private String tokenId;
    @ApiModelProperty(value = "微信code,微信jsapi支付必填")
    private String wxCodeJson; //微信code
    @ApiModelProperty(value = "openId")
    private String openId;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
