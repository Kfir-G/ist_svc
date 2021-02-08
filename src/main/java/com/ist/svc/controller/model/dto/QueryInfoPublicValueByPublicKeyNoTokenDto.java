package com.ist.svc.controller.model.dto;

import com.ist.svc.controller.model.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: sunhaitao
 */
@Data
@ApiModel(value = "根据key查询value(无需要token)")
public class QueryInfoPublicValueByPublicKeyNoTokenDto extends BaseReq {
    @ApiModelProperty(value = "key")
    @NotBlank(message = "key不能为空")
    private String key;
}
