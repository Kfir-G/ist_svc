package com.ist.svc.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserPasswd {
    private Long id;

    private String loginname;

    private String passwd;

    private Integer userType;

    private Short changenum;

    private Short status;

    private Date offtime;

    private BigDecimal userid;

    private Date createtime;

    //user表字段
    private String phone;
    private String unicode;
    private String nickName;
    private String idCard;
    private Date birthday;
    private Integer age;
    private Integer sex;
    private String avatarUrl;

}