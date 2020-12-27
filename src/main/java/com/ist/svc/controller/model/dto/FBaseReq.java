package com.ist.svc.controller.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: sunhaitao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FBaseReq {
    @NotBlank(message = "appId不能为空")
    @ApiModelProperty(value = "秘钥id")
    private String appId;
    @NotBlank(message = "time不能为空")
    @ApiModelProperty(value = "时间戳")
    private String time;
    @ApiModelProperty(value = "签名后的串")
    @NotBlank(message = "sign不能为空")
    private String sign;
    @ApiModelProperty(value = "分页大小")
    @NotNull(message = "分页大小不能为空")
    private Integer pageSize;
    @ApiModelProperty(value = "当前第几页")
    @NotNull(message = "当前第几页不能为空")
    private Integer currPage;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
