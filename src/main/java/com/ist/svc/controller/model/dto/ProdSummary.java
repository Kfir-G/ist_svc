package com.ist.svc.controller.model.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "查询商品概要info对象")
public class ProdSummary {
    @ApiModelProperty(value = "产品id")
    private Integer prodId;
    @ApiModelProperty(value = "商店id")
    private Integer shopId;
    @ApiModelProperty(value = "最低价格")
    private Float minPrice;
    @ApiModelProperty(value = "最高价格")
    private Float maxPrice;
    @ApiModelProperty(value = "近期销量")
    private Integer sales;
    @ApiModelProperty(value = "是否有货")
    private Short isStock;
    @ApiModelProperty(value = "是否热销")
    private Short isHot;
    @ApiModelProperty(value = "排序权重")
    private Short seqFactor;
    @ApiModelProperty(value = "评分")
    private Float grade;
    @ApiModelProperty(value = "创建时间yyyymmdd24hhmiss")
    private String createTime;
    @ApiModelProperty(value = "最后更新时间yyyymmdd24hhmiss")
    private String updateTime;
    @ApiModelProperty(value = "状态")
    private Short status;
    @ApiModelProperty(value = "商品名称")
    private String prodName;
    @ApiModelProperty(value = "头部照片")
    private String headImg;
    @ApiModelProperty(value = "省份id")
    private Short provinceId;
    @ApiModelProperty(value = "城市id")
    private Short cityId;
}
