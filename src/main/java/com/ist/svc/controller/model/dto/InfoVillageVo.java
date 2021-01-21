package com.ist.svc.controller.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: sunhaitao
 */
@Data
@ApiModel(description = "用户查询村居响应对象")
public class InfoVillageVo {
    @ApiModelProperty(value = "省份id")
    private Integer provinceId;
    @ApiModelProperty(value = "省份")
    private String province;
    @ApiModelProperty(value = "城市")
    private String city;
    @ApiModelProperty("省份id")
    private Integer cityId;
    @ApiModelProperty(value = "区域")
    private String area;
    @ApiModelProperty(value = "区域id")
    private Integer areaId;
    @ApiModelProperty(value = "乡镇")
    private String town;
    @ApiModelProperty(value = "乡镇id")
    private Integer townId;
    @ApiModelProperty(value = "village")
    private String village;
    @ApiModelProperty(value = "village")
    private Long villageId;
}
