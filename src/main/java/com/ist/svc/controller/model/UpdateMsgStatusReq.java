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
public class UpdateMsgStatusReq extends BaseReq {
    @NotBlank(message = "userId不能为空")
    private String userId;
    @NotBlank(message = "tokenId不能为空")
    private String tokenId;
    private String loginName;
    @NotBlank(message = "msgIds不能为空")
    private String msgIds;
    @NotNull(message = "status不能为空")
    private Integer status;
}
