package com.ist.svc.controller.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "详情对象")
public class FBaseInfo {
    @ApiModelProperty(value = "总记录数")
    private long total;
    @ApiModelProperty(value = "总页数")
    private Integer pages;
    private Object records;
}
