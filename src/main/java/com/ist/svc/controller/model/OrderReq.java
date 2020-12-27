package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class OrderReq extends BaseReq{
    @NotBlank(message = "userId不能为空")
    private String userId;
    @NotBlank(message = "tokenId不能为空")
    private String tokenId;
    private String loginName;
    @NotBlank(message = "addressId不能为空")
    private String addressId;
    @NotNull(message = "payFee不能为空")
    private Float payFee;
    @NotNull(message = "orders不能为空")
    private List<Order> orders;

}
