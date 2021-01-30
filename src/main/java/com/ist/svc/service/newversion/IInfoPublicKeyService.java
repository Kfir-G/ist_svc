package com.ist.svc.service.newversion;

import com.ist.svc.controller.model.dto.AddInfoPublicKeyValueDto;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.QueryInfoPublicValueByPublicKeyDto;

/**
 * @Author: sunhaitao
 */
public interface IInfoPublicKeyService {
    ApiBaseResp queryInfoPublicValueByPublicKey(QueryInfoPublicValueByPublicKeyDto dto);

    ApiBaseResp addInfoPublicKeyValue(AddInfoPublicKeyValueDto dto);
}
