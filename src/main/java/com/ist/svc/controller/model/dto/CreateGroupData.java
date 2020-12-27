package com.ist.svc.controller.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "创建分组详情")
public class CreateGroupData {
    @ApiModelProperty(value = "分组ID")
    private String groupId;
}
