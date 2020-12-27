package com.ist.svc.controller.model;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: sunhaitao
 */
@Data
@JSONType(orders={"shopId","shopName","sumFee","discountFee","couponFee"})
public class Order {
    @NotBlank(message = "shopId不能为空")
    private String shopId;
    @NotBlank(message = "shopName不能为空")
    private String shopName;
    @NotNull(message = "sumFee不能为空")
    private Float sumFee;
    @NotNull(message = "discountFee不能为空")
    private Float discountFee;
    @NotNull(message = "couponFee不能为空")
    private Float couponFee;
    @NotNull(message = "deductionFee不能为空")
    private Float deductionFee;
    @NotNull(message = "fee不能为空")
    private Float fee;
    @NotNull(message = "freightFee不能为空")
    private Float freightFee;
    @NotNull(message = "payFee不能为空")
    private Float payFee;
    @NotNull(message = "details不能为空")
    private List<OrderDetail> details;
}
