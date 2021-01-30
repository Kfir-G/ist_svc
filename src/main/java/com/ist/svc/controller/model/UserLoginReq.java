package com.ist.svc.controller.model;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "用户登陆请求对象")
public class UserLoginReq extends BaseReq {
    @NotBlank(message = "登陆账号(loginName)不能为空")
    @ApiModelProperty(value = "登陆账号(loginName)")
    private String loginName;
    @ApiModelProperty(value = "登陆密码(password)")
    private String password;
    @NotNull(message = "登陆类型(loginType)不能为空")
    @ApiModelProperty(value = "登陆类型(loginType)")
    private Integer loginType;
    @ApiModelProperty(value = "smsCode")
    private String smsCode;
    @ApiModelProperty(value = "wxCode")
    private String wxCode;
    @JSONField(serialize = false)
    private boolean isNeedPwd = true;//是否需要密码
    @ApiModelProperty(value = "deviceInfo")
    private String deviceInfo;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
