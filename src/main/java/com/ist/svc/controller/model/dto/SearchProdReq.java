package com.ist.svc.controller.model.dto;

import com.ist.svc.controller.model.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "产品搜索请求对象")
public class SearchProdReq extends BaseReq {
    @ApiModelProperty(value = "产品名称")
    private String prodName;
    @ApiModelProperty(value = "最低价格")
    private Float minPrice;
    @ApiModelProperty(value = "最高价格")
    private Float maxPrice;
    @ApiModelProperty(value = "近期销量")
    private Integer sales;
    @ApiModelProperty(value = "是否有货")
    private Integer isStock;
    @ApiModelProperty(value = "是否是热销产品")
    private Integer isHot;
    @ApiModelProperty(value = "省份ids")
    private String provinceIds;
    @ApiModelProperty(value = "城市ids")
    private String cityIds;
    @ApiModelProperty(value = "规格id")
    private String spmId;
    @ApiModelProperty(value = "商品参数信息")
    private String params;
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
