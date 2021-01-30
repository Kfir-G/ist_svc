package com.ist.svc.service.newversion.impl;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.controller.model.dto.AddInfoPublicKeyValueDto;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.QueryInfoPublicValueByPublicKeyDto;
import com.ist.svc.dao.InfoPublicKeyMapper;
import com.ist.svc.domain.InfoPublicKey;
import com.ist.svc.service.impl.BaseServiceImpl;
import com.ist.svc.service.newversion.IInfoPublicKeyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: sunhaitao
 */
@Service
public class InfoPublicKeyServiceImpl extends BaseServiceImpl implements IInfoPublicKeyService{
    @Autowired
    private InfoPublicKeyMapper infoPublicKeyMapper;
    @Override
    public ApiBaseResp queryInfoPublicValueByPublicKey(QueryInfoPublicValueByPublicKeyDto dto) {
        String value = infoPublicKeyMapper.selectValueByPublicKey(dto.getKey());
        return ApiBaseResp.succ(value);
    }

    @Override
    public ApiBaseResp addInfoPublicKeyValue(AddInfoPublicKeyValueDto dto) {
        String value = infoPublicKeyMapper.selectValueByPublicKey(dto.getKey());
        if (StringUtils.isNotBlank(value)){
            ApiBaseResp.result(ResultConstant.ADD_INFO_PUBLIC_KEY_EXIST_ERROR_CODE,ResultConstant.ADD_INFO_PUBLIC_KEY_EXIST_ERROR_MSG);
        }
        InfoPublicKey infoPublicKey = new InfoPublicKey();
        infoPublicKey.setKey(dto.getKey());
        infoPublicKey.setValue(dto.getValue());
        infoPublicKeyMapper.insertSelective(infoPublicKey);
        return ApiBaseResp.succ(null);
    }
}
