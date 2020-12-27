package com.ist.svc.controller.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "查询商品概要请求对象")
public class GetProdListByProdIdsReq {
    @ApiModelProperty(value = "产品ids")
    @NotBlank(message = "产品ids不能为空")
    private String prodIds;
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
