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
@ApiModel(description = "用户绑定手机号请求对象")
public class UserBindPhoneReq extends BaseReq {
    @NotBlank(message = "用户(userId)不能为空")
    @ApiModelProperty(value = "用户(userId)")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    @ApiModelProperty(value = "登陆令牌(tokenId)")
    private String tokenId;
    @NotBlank(message = "用户手机号(phone)不能为空")
    @ApiModelProperty(value = "用户手机号(phone)")
    private String phone;
    @NotBlank(message = "验证码(smsCode)不能为空")
    @ApiModelProperty(value = "验证码(smsCode)")
    private String smsCode;
    @ApiModelProperty(value = "绑定类型(1:正向绑定,2: 反向绑定(手机号绑定微信))",notes = "1:正向绑定,2: 反向绑定(手机号绑定微信)")
    @NotNull(message = "绑定类型不能为空")
    private Integer bindType;
    @ApiModelProperty(value = "微信code json(反向绑定(手机号绑定微信)时不能为空)",notes = "反向绑定(手机号绑定微信)时不能为空")
    private String wxCodeJson;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
