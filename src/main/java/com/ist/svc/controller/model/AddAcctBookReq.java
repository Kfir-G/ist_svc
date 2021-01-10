package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class AddAcctBookReq extends BaseReq {
    @NotBlank(message = "用户(userId)不能为空")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    private String tokenId;
    private String loginName;
    @NotNull(message = "账户类型(acctType)不能为空")
    private Integer acctType;
    @NotNull(message = "资金流向(direct)不能为空")
    private Integer direct;
    @NotNull(message = "支付来源(payType)不能为空")
    private Integer payType;
    @NotBlank(message = "订单号(orderId)不能为空")
    private String orderId;
    @NotNull(message = "状态(status)不能为空")
    private Integer status;
    @NotNull(message = "金额(money)不能为空")
    private Float money;
    @NotBlank(message = "操作人id(optUserId)不能为空")
    private String optUserId;
    @NotBlank(message = "昵称(name)不能为空")
    private String name;
    private Integer bizType;
    private String descr;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
