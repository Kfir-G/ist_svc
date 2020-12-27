package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class DelCartReq extends BaseReq {
    @NotBlank(message = "userId不能为空")
    private String userId;
    @NotBlank(message = "tokenId不能为空")
    private String tokenId;
    private String loginName;
    @NotBlank(message = "ids不能为空")
    private String ids;
}
