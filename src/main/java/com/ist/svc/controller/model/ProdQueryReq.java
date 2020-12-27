package com.ist.svc.controller.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: sunhaitao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProdQueryReq extends BaseReq {
    @NotBlank(message = "产品信息id(prodInfoId)不能为空")
    private String prodInfoId;
    @NotNull(message = "pageSize不能为null")
    @Min(value = 1,message = "pageSize不能小于1")
    private Integer pageSize;
    @NotNull(message = "pageNum不能为null")
    @Min(value = 1,message = "pageNum不能小于1")
    private Integer pageNum;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}