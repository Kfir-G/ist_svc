package com.ist.svc.controller.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRegisterReq extends BaseReq {
    @NotBlank(message = "手机号(phone)不能为空")
    private String phone;      //手机号
    @Size(max = 50,message = "账号(loginName)长度不能超过50")
    @NotBlank(message = "登陆账号(loginName)不能为空")
    private String loginName;  //登陆账号
    @NotNull(message = "用户类型(userType)不能为空")
    private Integer userType;  //用户类型
    @NotBlank(message = "登陆密码(password)不能为空")
    private String password;   //登陆密码
    @NotBlank(message = "昵称不能为空")
    private String nickName;   //昵称
    private String name;       //真实姓名
    private String idCard;     //身份证号
    private String birthday;   //出生日期
    @Min(value = 1)
    private Integer age;        //年龄
    private Integer sex;        //性 别0未知1男2女
    private Integer cityId;     //常住城市 Info_City
    private String address;     //住址
    private String home;        //户籍地址
    private String avatarUrl;   //头像地址
    @NotBlank(message = "wechat不能为空")
    private String wechat;     //微信openId

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
