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
public class CashDownReq extends BaseReq {
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
    @NotNull(message = "提现金额(money)不能为空")
    @ApiModelProperty(value = "提现金额(money)")
    private Double money;
    @NotNull(message = "提现手续费(fee)不能为空")
    @ApiModelProperty(value = "提现手续费(fee)")
    private Double fee;
    @NotBlank(message = "账号真实名字(name)不能为空")
    @ApiModelProperty(value = "账号真实名字(name)")
    private String name;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
