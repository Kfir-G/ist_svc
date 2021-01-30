package com.ist.svc.controller.model;

import lombok.Data;

/**
 * @Author: sunhaitao
 */
@Data
public class UserAddress {
    private String name;
    private String phone;
    private Integer areaId;
    private String addressId;
    private String address;
    private Integer isDefault;
    private String userId;
    private Long orgId;
    private Integer type;
    private String v1;
    private String v2;

    private String province;
    private String city;
    private String area;
    private String picker;//选择器序号
}
