package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class QueryProdInfoByKeyReq extends BaseReq{
    @NotBlank(message = "关键字(key)不能为空")
    private String key;//关键字
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
