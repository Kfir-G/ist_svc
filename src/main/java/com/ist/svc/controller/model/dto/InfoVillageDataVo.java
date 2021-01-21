package com.ist.svc.controller.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Data
@ApiModel(value = "返回村庄信息")
public class InfoVillageDataVo {
    private long total;
    private List<InfoVillageVo> infoVillages;
}
