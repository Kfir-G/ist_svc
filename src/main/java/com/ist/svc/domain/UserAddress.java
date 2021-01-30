package com.ist.svc.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserAddress {
    private Long addressid;

    private BigDecimal userid;

    private Short status;

    private String name;

    private String phone;

    private Integer areaid;

    private String address;

    private Short isdefault;

    private Date createtime;

    private Date updatetime;

    private Long orgId;

    private Integer type;

    private String v1;

    private String v2;

    //info_area
    private String province;
    private String city;
    private String area;
    private String picker;


}