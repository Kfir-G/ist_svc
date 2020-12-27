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
public class UserLoginReq extends BaseReq {
    @NotBlank(message = "登陆账号(loginName)不能为空")
    private String loginName;
//    @NotBlank(message = "登陆密码(password)不能为空")
    private String password;
    @NotNull(message = "登陆类型(loginType)不能为空")
    private Integer loginType;
    private String smsCode;
    private String wxCode;
    private boolean isNeedPwd = true;//是否需要密码

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
