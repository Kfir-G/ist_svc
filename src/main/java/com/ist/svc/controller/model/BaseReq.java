package com.ist.svc.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseReq {
    @NotBlank(message = "appId不能为空")
    @ApiModelProperty(value = "秘钥id")
    private String appId;
    @NotBlank(message = "time不能为空")
    @ApiModelProperty(value = "时间戳")
    private String time;
    @ApiModelProperty(value = "签名后的串")
    @NotBlank(message = "sign不能为空")
    private String sign;
}
