package com.ist.svc.controller.model;

import lombok.Data;

/**
 * @Author: sunhaitao
 */
@Data
public class ShopCouponProd {
    private Integer couponId;

    private Integer prodInfoId;

    private Integer prodId;

    private String headImg;

    private String prodName;
}
