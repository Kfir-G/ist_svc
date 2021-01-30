package com.ist.svc.controller.model;

import lombok.Data;

/**
 * @Author: sunhaitao
 */
@Data
public class UserAddressVo {
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
}
