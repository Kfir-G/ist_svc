package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class UpdateOrderReq extends BaseReq{
    @NotBlank(message = "userId不能为空")
    private String userId;
    @NotBlank(message = "tokenId不能为空")
    private String tokenId;
    private String loginName;
    @NotBlank(message = "orderId不能为空")
    private String orderId;
    @NotBlank(message = "detailIds不能为空")
    private String detailIds;
    @NotNull(message = "status不能为空")
    private Integer status;  //状态
    private String deliveryNo;
    @NotBlank(message = "optUserId不能为空")
    private String optUserId;
    private String descr;
}
