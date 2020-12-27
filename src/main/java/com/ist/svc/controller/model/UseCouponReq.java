package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class UseCouponReq extends BaseReq{
    @NotBlank(message = "userId不能为空")
    private String userId;
    @NotBlank(message = "tokenId不能为空")
    private String tokenId;
    private String loginName;
    @NotBlank(message = "couponId不能为空")
    private String couponId;
    @NotBlank(message = "userCouponId不能为空")
    private String userCouponId;
    private String orderId;
}
