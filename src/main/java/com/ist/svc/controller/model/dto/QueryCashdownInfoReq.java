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
public class QueryCashdownInfoReq extends BaseReq {
    @NotNull(message = "提现方式(type)不能为空")
    @ApiModelProperty(value = "提现方式(type)")
    private Integer type;
    @NotBlank(message = "用户(userId)不能为空")
    @ApiModelProperty(value = "用户(userId)")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    @ApiModelProperty(value = "登陆令牌(tokenId)")
    private String tokenId;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
