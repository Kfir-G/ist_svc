package com.ist.svc.service.newversion;

import com.ist.svc.controller.model.dto.AddInfoOrgDto;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.QueryInfoOrgDto;
import com.ist.svc.controller.model.dto.QueryInfoVillageDto;

/**
 * @Author: sunhaitao
 */
public interface IOrganizationService {
    ApiBaseResp queryInfoVillage(QueryInfoVillageDto queryInfoVillageDto);

    ApiBaseResp addInfoOrg(AddInfoOrgDto addInfoOrgDto); //添加组织

    ApiBaseResp queryInfoOrg(QueryInfoOrgDto queryInfoOrgDto); //查询组织
}
