package com.ist.svc.controller.model;

import com.ist.svc.domain.Order;
import lombok.Data;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Data
public class GetOrderListData {
    private String orderId;
    private String userId;
    private UserAddress address;
    private Integer status;
    private String shopId;
    private String shopName;
    private Integer amount;
    private float sumFee;
    private float discountFee;
    private float couponFee;
    private float deductionFee;
    private float fee;
    private float freightFee;
    private float payFee;
    private String payTime;
    private Integer payType;
    private String createTime;
    private String updateTime;
    private List<OrderDetail> details;
}
