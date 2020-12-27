package com.ist.svc.controller.model.dto;

import com.ist.svc.controller.model.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

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
}
