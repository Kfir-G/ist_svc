package com.ist.svc.controller.model.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: sunhaitao
 */
@Data
@ApiModel(value = "组织model")
public class InfoOrgVo {
    private Long orgId;
    private Integer provinceId;
    private String province;
    private Integer cityId;
    private String city;
    private Integer areaId;
    private String area;
    private Long townId;
    private String town;
    private Long villageId;
    private String village;
    private Short isTownVilla;
    private String address;
    private Short orgType;
    private String orgName;
    private String oldName;
    private String descr;
    private Integer countNum;
    private String createTime;

}
