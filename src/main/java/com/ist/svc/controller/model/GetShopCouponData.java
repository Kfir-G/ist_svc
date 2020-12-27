package com.ist.svc.controller.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Data
public class GetShopCouponData {
    private String prodId;
    private String shopId;
    private String couponId;
    private Integer amount;
    private Integer status;
    private Integer take;
    private String onlineTime;
    private String offTime;
    private String startTime;
    private String endTime;
    private String createTime;
    private Integer type;
    private Long conditionMoney;
    private Long money;
    private String shopName;
    private String couponName;
    private String descr;
    List<ShopCouponProd> shopCouponProds;
}
