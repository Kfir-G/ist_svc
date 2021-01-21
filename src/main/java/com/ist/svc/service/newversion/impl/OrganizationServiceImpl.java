package com.ist.svc.service.newversion.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.InfoVillageDataVo;
import com.ist.svc.controller.model.dto.InfoVillageVo;
import com.ist.svc.controller.model.dto.QueryInfoVillageDto;
import com.ist.svc.dao.InfoVillageMapper;
import com.ist.svc.domain.InfoVillage;
import com.ist.svc.domain.InfoVillageExample;
import com.ist.svc.service.impl.BaseServiceImpl;
import com.ist.svc.service.newversion.IOrganizationService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunhaitao
 */
@Service
public class OrganizationServiceImpl extends BaseServiceImpl implements IOrganizationService {
    @Autowired
    private InfoVillageMapper infoVillageMapper;
    @Override
    public ApiBaseResp queryInfoVillage(QueryInfoVillageDto req) {
        Integer pageNum = req.getPageNum();
        Integer pageSize = req.getPageSize();
        if (pageNum==null || pageNum<=0){
            pageNum = 1;
        }
        if (pageSize==null || pageSize<=0){
            pageSize = 10;
        }

        InfoVillageDataVo infoVillageDataVo = new InfoVillageDataVo();
        InfoVillageExample example = new InfoVillageExample();
        InfoVillageExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNoneBlank(req.getAreaId())){
            criteria.andAreaidEqualTo(Integer.valueOf(req.getAreaId()));
        }
        if (StringUtils.isNoneBlank(req.getTown())){
            criteria.andTownLike("%" +req.getTown() + "%");
        }
        if (StringUtils.isNoneBlank(req.getVillage())){
            criteria.andVillageLike("%" +req.getVillage() + "%");
        }
        PageHelper.startPage(pageNum,pageSize);
        Page<InfoVillage> infoVillagesDo = (Page<InfoVillage>) infoVillageMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(infoVillagesDo)){
            infoVillageDataVo.setTotal(infoVillagesDo.getTotal());
            List<InfoVillageVo> infoVillageVos = new ArrayList<>();
            for (InfoVillage village : infoVillagesDo.getResult()){
                InfoVillageVo infoVillageVo = new InfoVillageVo();
                infoVillageVo.setArea(village.getArea());
                infoVillageVo.setAreaId(village.getAreaid().intValue());
                infoVillageVo.setCity(village.getCity());
                infoVillageVo.setCityId(village.getCityid().intValue());
                infoVillageVo.setProvince(village.getProvince());
                infoVillageVo.setProvinceId(village.getProvinceid().intValue());
                infoVillageVo.setTown(village.getTown());
                infoVillageVo.setTownId(village.getTownid().intValue());
                infoVillageVo.setVillage(village.getVillage());
                infoVillageVo.setVillageId(village.getVillageid());
                infoVillageVos.add(infoVillageVo);
            }
            infoVillageDataVo.setInfoVillages(infoVillageVos);
        }
        return ApiBaseResp.succ(infoVillageDataVo);
    }
}
