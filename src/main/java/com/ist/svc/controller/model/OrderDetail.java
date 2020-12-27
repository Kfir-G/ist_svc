package com.ist.svc.controller.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: sunhaitao
 */
@Data
public class OrderDetail {
    @NotBlank(message = "orderId不能为空")
    private String orderId;
    private String detailId;
    private Integer status;
    private String shopId;
    @NotBlank(message = "prodInfoId不能为空")
    private String prodInfoId;
    @NotBlank(message = "prodId不能为空")
    private String prodId;
    @NotBlank(message = "headImg不能为空")
    private String headImg;
    @NotBlank(message = "name不能为空")
    private String name;
    private Float saleFee;
    private Integer amount;
    private Float sumFee;
    private Integer discountId;
    private Float discountFee;
    private Integer couponId;
    private String userCouponId;
    private Float couponFee;
    private Float fee;
    @NotNull(message = "freightFee不能为空")
    private Float freightFee;
    private Float payFee;
    private Integer delivery;
    private String deliveryNo;
    private String createTime;
    private String updateTime;
    private String descr;
    @NotBlank(message = "spec不能为空")
    private String spec;
}
