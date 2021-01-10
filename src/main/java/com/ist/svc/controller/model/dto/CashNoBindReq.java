package com.ist.svc.controller.model.dto;

import com.ist.svc.controller.model.BaseReq;
import io.swagger.annotations.ApiModelProperty;
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
public class CashNoBindReq extends BaseReq {
    @NotBlank(message = "用户(userId)不能为空")
    @ApiModelProperty(value = "用户(userId)")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    @ApiModelProperty(value = "登陆令牌(tokenId)")
    private String tokenId;
    @NotNull(message = "提现方式(type)不能为空")
    @ApiModelProperty(value = "提现方式(type)")
    private Integer type;
    @NotBlank(message = "提现账号(cashNo)不能为空")
    @ApiModelProperty(value = "提现账号(cashNo)")
    private String cashNo;
    @NotBlank(message = "账号真实名字(name)不能为空")
    @ApiModelProperty(value = "账号真实名字(name)")
    private String name;
    @NotBlank(message = "验证码(smsCode)不能为空")
    @ApiModelProperty(value = "验证码(smsCode)")
    private String smsCode;
    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号(phoneNum)不能为空")
    private String phoneNum;//手机号
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
