package com.ist.svc.service.newversion.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.common.util.IstBeanUtil;
import com.ist.svc.controller.model.dto.*;
import com.ist.svc.controller.model.vo.InfoOrgVo;
import com.ist.svc.dao.InfoOrgMapper;
import com.ist.svc.dao.InfoVillageMapper;
import com.ist.svc.domain.InfoOrg;
import com.ist.svc.domain.InfoOrgExample;
import com.ist.svc.domain.InfoVillage;
import com.ist.svc.domain.InfoVillageExample;
import com.ist.svc.service.impl.BaseServiceImpl;
import com.ist.svc.service.newversion.IOrganizationService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: sunhaitao
 */
@Service
public class OrganizationServiceImpl extends BaseServiceImpl implements IOrganizationService {
    @Autowired
    private InfoVillageMapper infoVillageMapper;
    @Autowired
    private InfoOrgMapper infoOrgMapper;
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

    @Override
    public ApiBaseResp addInfoOrg(AddInfoOrgDto addInfoOrgDto) {
        InfoOrg infoOrg = IstBeanUtil.copy(addInfoOrgDto, InfoOrg.class, (source, newInstance) -> {
            newInstance.setAreaid(source.getAreaId().intValue());
            newInstance.setCityid(source.getCityId().intValue());
            newInstance.setProvinceid(source.getProvinceId().intValue());
            if (source.getAreaId() != null) {
                newInstance.setAreaid(source.getAreaId().intValue());
            }
            if (source.getTownId() != null) {
                newInstance.setTownid(source.getTownId());
            }
            newInstance.setCreateTime(new Date());
            newInstance.setUpdateTime(new Date());
        });
        infoOrgMapper.insertSelective(infoOrg);
        return ApiBaseResp.succ(null);
    }

    @Override
    public ApiBaseResp queryInfoOrg(QueryInfoOrgDto queryInfoOrgDto) {
        InfoOrgExample example = new InfoOrgExample();
        InfoOrgExample.Criteria criteria = example.createCriteria();
        criteria.andAreaidEqualTo(queryInfoOrgDto.getAreaId().intValue());
        if (queryInfoOrgDto.getOrgId()!=null){
            criteria.andOrgidEqualTo(queryInfoOrgDto.getOrgId());
        }
        if (queryInfoOrgDto.getTownId()!=null){
            criteria.andTownidEqualTo(queryInfoOrgDto.getTownId());
        }
        if (queryInfoOrgDto.getVillageId()!=null){
            criteria.andVillageidEqualTo(queryInfoOrgDto.getVillageId());
        }
        if (StringUtils.isNotBlank(queryInfoOrgDto.getOldName())){
            criteria.andOldNameLike("%" + queryInfoOrgDto.getOldName() + "%");
        }
        if (StringUtils.isNotBlank(queryInfoOrgDto.getOrgName())){
            criteria.andOrgNameLike("%" + queryInfoOrgDto.getOldName() + "%");
        }
        List<InfoOrg> infoOrgs = infoOrgMapper.selectByExample(example);
        List<InfoOrgVo> infoOrgVos = IstBeanUtil.copyList(infoOrgs, InfoOrgVo.class, (source, newInstance) -> {
            newInstance.setOrgId(source.getOrgid());
            newInstance.setAreaId(source.getAreaid().intValue());
            newInstance.setCityId(source.getCityid().intValue());
            newInstance.setProvinceId(source.getProvinceid().intValue());
            if (source.getAreaid() != null) {
                newInstance.setAreaId(source.getAreaid().intValue());
            }
            if (source.getTownid() != null) {
                newInstance.setTownId(source.getTownid());
            }
            newInstance.setCreateTime(DateUtil.getString(source.getCreateTime(), DateUtil.PATTERN_DATE_TIME));
        });
        return ApiBaseResp.succ(infoOrgVos);
    }
}
