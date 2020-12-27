package com.ist.svc.controller.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Data
public class GetUserCouponData {
    private String userCouponId;
    private String prodId;
    private String shopId;
    private String couponId;
    private String no;
    private Integer status;
    private String endTime;
    private String useTime;
    private String createTime;
    private Integer type;
    private Long conditionMoney;
    private Long money;
    private String shopName;
    private String couponName;
    private String descr;
    List<ShopCouponProd> shopCouponProds;
}
