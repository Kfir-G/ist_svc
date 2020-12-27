package com.ist.svc.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class User {
    private BigDecimal userid;

    private String unicode;

    private Short status;

    private String nickname;

    private String name;

    private String idcard;

    private Date birthday;

    private Short age;

    private Short sex;

    private String phone;

    private String address;

    private Integer cityid;

    private String home;

    private Date createtime;

    private Long accountid;

    private String avatarUrl;

    private String wechat;

}