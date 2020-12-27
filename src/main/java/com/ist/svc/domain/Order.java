package com.ist.svc.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private Long orderid;

    private Integer orderno;

    private Long userid;

    private Long addressid;

    private Integer shopId;

    private Integer amount;

    private String shopName;

    private Short status;

    private Float sumfee;

    private Float discountfee;

    private Float couponfee;

    private Float deductionfee;

    private Float fee;

    private Float freightfee;

    private Float payfee;

    private Date paytime;

    private Short paytype;

    private String transid;

    private Date createtime;

    private Date updatetime;

    private Integer channelid;

    private Long olduserid;

    private String descr;

    private List<OrderDetail> orderDetails;
}