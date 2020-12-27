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
public class JoinCartReq extends BaseReq {
    @NotBlank(message = "userId不能为空")
    private String userId;
    @NotBlank(message = "tokenId不能为空")
    private String tokenId;
    private String loginName;
    @NotBlank(message = "prodId不能为空")
    private String prodId;
    @NotBlank(message = "prodInfoId不能为空")
    private String prodInfoId;
    @NotNull(message = "amount不能为空")
    private Integer amount;
    @NotNull(message = "cartFee不能为空")
    private Float cartFee;
    @NotNull(message = "selected不能为空")
    private Integer selected;
    @NotBlank(message = "具体规格不能为空")
    private String spec;//前端传
    private String cartIds;//如果传了 就是选中或者取消选中（后续完成）
}
