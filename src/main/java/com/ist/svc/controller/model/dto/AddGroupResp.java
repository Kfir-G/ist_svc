package com.ist.svc.controller.model.dto;

import com.ist.svc.domain.vo.AddGroupVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "加群响应对象")
public class AddGroupResp {
    @ApiModelProperty(value = "返回码")
    private String code;
    @ApiModelProperty(value = "返回描述")
    private String msg;
    @ApiModelProperty(value = "返回详情")
    private AddGroupVo data;
}
