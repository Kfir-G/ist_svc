package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class GetShopsByShopIdsReq extends BaseReq{
    @NotBlank(message = "shopIds不能为空")
    private String shopIds;
    private String loginName;
    @NotBlank(message = "userId不能为空")
    private String userId;
    @NotBlank(message = "tokenId不能为空")
    private String tokenId;
}
