package com.ist.svc.service.newversion;

import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.QueryInfoVillageDto;

/**
 * @Author: sunhaitao
 */
public interface IOrganizationService {
    ApiBaseResp queryInfoVillage(QueryInfoVillageDto queryInfoVillageDto);
}
