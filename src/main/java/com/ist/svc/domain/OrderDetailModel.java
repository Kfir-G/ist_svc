package com.ist.svc.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: sunhaitao
 */
@Data
public class OrderDetailModel {
    private Long detailid;

    private Integer shopid;

    private Integer prodinfoid;

    private Integer prodid;

    private String name;

    private String headimg;

    private String spec;

    private Short detailStatus;

    private Float salefee;

    private Integer amount;

    private Float detailSumfee;

    private Integer discountid;

    private Float detailDiscountfee;

    private Integer couponid;

    private Float detailCouponfee;

    private Float detailFee;

    private Float detailFreightfee;

    private Short delivery;

    private String deliveryno;

    private Float detailPayfee;

    private String detaildescr;

    private Short safekeep;

    private Float safekeepmoney;

    private Long transferorderid;

    private Date detailCreatetime;

    private Date detailUpdatetime;

    private Date reservetime;

    private Date usetime;
}
