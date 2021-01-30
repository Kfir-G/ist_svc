package com.ist.svc.controller.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: sunhaitao
 */
@Data
@ApiModel(value = "查询用户客户端id,用于推送消息")
public class QueryUserClientIdDto {
    @NotBlank(message = "userId不能为空")
    private String userId;
}
