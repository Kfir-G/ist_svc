package com.ist.svc.controller.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "子账户对象")
public class SubAcctVo {
    @ApiModelProperty(value = "子账户id")
    private String subAccountId;
    @ApiModelProperty(value = "主账户id")
    private String accountId;
    @ApiModelProperty(value = "账户类型")
    private Integer acctType;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "余额")
    private Float balance;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "最后更新时间")
    private String updateTime;
}
