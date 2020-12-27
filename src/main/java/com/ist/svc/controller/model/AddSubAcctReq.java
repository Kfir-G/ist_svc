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
public class AddSubAcctReq extends BaseReq {
    @NotBlank(message = "用户(userId)不能为空")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    private String tokenId;
    private String loginName;
    @NotNull(message = "账户类型(acctType)不能为空")
    private Integer acctType;
    @NotBlank(message = "用户Id或商户Id为空(ownUserId)")
    private String ownUserId;
}
