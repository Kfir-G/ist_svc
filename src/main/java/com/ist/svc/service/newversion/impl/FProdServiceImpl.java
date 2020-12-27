package com.ist.svc.service.newversion.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.controller.model.UserVerifyTokenReq;
import com.ist.svc.controller.model.UserVerifyTokenResp;
import com.ist.svc.controller.model.dto.*;
import com.ist.svc.dao.ProdLimitMapper;
import com.ist.svc.dao.ProdSummaryMapper;
import com.ist.svc.domain.*;
import com.ist.svc.service.UserTokenService;
import com.ist.svc.service.impl.BaseServiceImpl;
import com.ist.svc.service.newversion.IFProdService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: sunhaitao
 */
@Service
public class FProdServiceImpl extends BaseServiceImpl implements IFProdService {
    @Autowired
    private UserTokenService userTokenService;
    @Autowired
    private ProdLimitMapper prodLimitMapper;
    @Autowired
    private ProdSummaryMapper prodSummaryMapper;

    @Override
    public void searchProdLimit(SearchProdLimitReq req, ApiBaseResp resp) {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.SEARCH_PROD_LIMIT_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.SEARCH_PROD_LIMIT_TOKENID_ERROR_MSG);
            return;
        }
        resp.setCode(ResultConstant.SEARCH_PROD_LIMIT_SUCC_CODE);
        resp.setMsg(ResultConstant.SEARCH_PROD_LIMIT_SUCC_MSG);
        Map<String,Object> params = new HashMap<>();
        if(StringUtils.isNoneBlank(req.getTradeTypeId())){
            params.put("tradeTypeId",req.getTradeTypeId());
        }
        if (StringUtils.isNoneBlank(req.getProdTypeId())){
            params.put("prodTypeId",req.getProdTypeId());
        }
        if (StringUtils.isNoneBlank(req.getShopId())){
            params.put("shopId",req.getShopId());
        }
        if(StringUtils.isNoneBlank(req.getProdLimitIds())){
            params.put("prodLimitIds",req.getProdLimitIds().split(","));
        }
        PageHelper.startPage(req.getCurrPage(),req.getPageSize());
        Page<ProdLimit> prodLimits = (Page<ProdLimit>) prodLimitMapper.selectProdLimits(params);
        FBaseInfo fbaseInfo = new FBaseInfo();
        List<SearchProdLimit> searchProdLimits = new ArrayList<>();
        if (null != prodLimits && prodLimits.size()>0){
            fbaseInfo.setTotal(prodLimits.getTotal());
            fbaseInfo.setPages(prodLimits.getPages());
            for (ProdLimit prodLimit : prodLimits.getResult()){
                SearchProdLimit searchProdLimit = new SearchProdLimit();
                searchProdLimit.setBeginCancelFee(prodLimit.getBegincancelfee());
                searchProdLimit.setBeginCancelType(prodLimit.getBegincanceltype());
                searchProdLimit.setCancelFee(prodLimit.getCanceltype());
                searchProdLimit.setCancelHours(prodLimit.getCancelhours());
                searchProdLimit.setCancelType(prodLimit.getCanceltype());
                searchProdLimit.setCreateTime(DateUtil.getString(prodLimit.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                searchProdLimit.setDescr(prodLimit.getDescr());
                searchProdLimit.setEndCancelFee(prodLimit.getEndcancelfee());
                searchProdLimit.setEndCancelType(prodLimit.getEndcanceltype());
                searchProdLimit.setName(prodLimit.getName());
                searchProdLimit.setOptUserId(prodLimit.getOptuserid());
                searchProdLimit.setOverHoursCancelType(prodLimit.getOverhourscanceltype());
                searchProdLimit.setProdLimitId(prodLimit.getProdlimitid());
                searchProdLimit.setProdTypeId(prodLimit.getProdtypeid());
                searchProdLimit.setSafeKeep(prodLimit.getSafekeep());
                searchProdLimit.setSafeKeepArrive(prodLimit.getSafekeeparrive());
                searchProdLimit.setSafeKeepMax(prodLimit.getSafekeepmax());
                searchProdLimit.setSafeKeepMin(prodLimit.getSafekeepmin());
                searchProdLimit.setShareNum(prodLimit.getSharenum());
                searchProdLimit.setShareType(prodLimit.getSharetype());
                searchProdLimit.setShopId(prodLimit.getShopid());
                searchProdLimit.setStatus(prodLimit.getStatus());
                searchProdLimit.setTradeTypeId(prodLimit.getTradetypeid());
                searchProdLimit.setTransferFee(prodLimit.getTransferfee());
                searchProdLimit.setTransferFeeType(prodLimit.getTransferfeetype());
                searchProdLimit.setTransferNum(prodLimit.getTransfernum());
                searchProdLimit.setTransferPrice(prodLimit.getTransferprice());
                searchProdLimit.setTransferType(prodLimit.getTransfertype());
                searchProdLimit.setUpdateTime(DateUtil.getString(prodLimit.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
                searchProdLimits.add(searchProdLimit);
            }
            fbaseInfo.setRecords(searchProdLimits);
        }
        resp.setData(fbaseInfo);
    }

    @Override
    public void getProdListByProdIds(GetProdListByProdIdsReq req, ApiBaseResp resp) {
        resp.setCode(ResultConstant.QUERY_PROD_SUMMARY_SUCC_CODE);
        resp.setMsg(ResultConstant.QUERY_PROD_SUMMARY_SUCC_MSG);
        ProdSummaryExample example = new ProdSummaryExample();
        ProdSummaryExample.Criteria criteria = example.createCriteria();
        List<String> prodIds = Arrays.asList(req.getProdIds().split(","));
        List<Integer> prodIdIntergers = new ArrayList<>();
        CollectionUtils.collect(prodIds, new Transformer() {
            @Override
            public Object transform(Object o) {
                return Integer.valueOf(o.toString());
            }
        }, prodIdIntergers);
        criteria.andProdidIn(prodIdIntergers);
        PageHelper.startPage(req.getCurrPage(),req.getPageSize());
        List<com.ist.svc.domain.ProdSummary> prodSummaries = prodSummaryMapper.selectByExample(example);
        List<com.ist.svc.controller.model.dto.ProdSummary> tProdSummList = new ArrayList<>();
        if (null!=prodSummaries && prodSummaries.size()>0){
            for (com.ist.svc.domain.ProdSummary prodSummary : prodSummaries){
                com.ist.svc.controller.model.dto.ProdSummary tProdSummary = new com.ist.svc.controller.model.dto.ProdSummary();
                tProdSummary.setCityId(prodSummary.getCityid());
                tProdSummary.setCreateTime(DateUtil.getString(prodSummary.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                tProdSummary.setGrade(prodSummary.getGrade());
                tProdSummary.setHeadImg(prodSummary.getHeadimg());
                tProdSummary.setIsHot(prodSummary.getIshot());
                tProdSummary.setIsStock(prodSummary.getIsstock());
                tProdSummary.setMaxPrice(prodSummary.getMaxprice());
                tProdSummary.setMinPrice(prodSummary.getMinprice());
                tProdSummary.setProdId(prodSummary.getProdid());
                tProdSummary.setProdName(prodSummary.getProdname());
                tProdSummary.setProvinceId(prodSummary.getProvinceid());
                tProdSummary.setSales(prodSummary.getSales());
                tProdSummary.setSeqFactor(prodSummary.getSeqfactor());
                tProdSummary.setShopId(prodSummary.getShopid());
                tProdSummary.setStatus(prodSummary.getStatus());
                tProdSummary.setUpdateTime(DateUtil.getString(prodSummary.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
                tProdSummList.add(tProdSummary);
            }
        }
        resp.setData(tProdSummList);
    }

    @Override
    public void searchProd(SearchProdReq req, ApiBaseResp resp) {
        resp.setCode(ResultConstant.SEARCH_PROD_SUCC_CODE);
        resp.setMsg(ResultConstant.SEARCH_PROD_SUCC_MSG);
        Map<String,Object> params = new HashMap<>();
        if(StringUtils.isNoneBlank(req.getCityIds())){
            params.put("cityIds",req.getCityIds().split(","));
        }
        if (StringUtils.isNoneBlank(req.getParams())){
            params.put("jsonParams",req.getParams());
        }
        if (StringUtils.isNoneBlank(req.getProdName())){
            params.put("prodName",req.getProdName());
        }
        if (StringUtils.isNoneBlank(req.getProvinceIds())){
            params.put("provinceIds",req.getProvinceIds().split(","));
        }
        if (StringUtils.isNoneBlank(req.getSpmId())){
            params.put("spmId",req.getSpmId());
        }
        if (null != req.getIsHot()){
            params.put("isHot",req.getIsHot());
        }
        if (null != req.getSales()){
            params.put("sales",req.getSales());
        }
        if (null != req.getIsStock()){
            params.put("isStock",req.getIsStock());
        }
        PageHelper.startPage(req.getCurrPage(),req.getPageSize());
        Page<com.ist.svc.domain.ProdSummary> prodSummaries = (Page<com.ist.svc.domain.ProdSummary>) prodSummaryMapper.selectByParams(params);
        if (null != prodSummaries){
            SearchProdInfo searchProdInfo = new SearchProdInfo();
            searchProdInfo.setTotal(prodSummaries.getTotal());
            searchProdInfo.setPages(prodSummaries.getPages());
            List<SearchProd> searchProdList = new ArrayList<>();
            for (com.ist.svc.domain.ProdSummary prodSummary : prodSummaries.getResult()){
                SearchProd searchProd = new SearchProd();
                searchProd.setCityId(prodSummary.getCityid());
                searchProd.setCreateTime(DateUtil.getString(prodSummary.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                searchProd.setGrade(prodSummary.getGrade());
                searchProd.setHeadImg(prodSummary.getHeadimg());
                searchProd.setIsHot(prodSummary.getIshot());
                searchProd.setIsStock(prodSummary.getIsstock());
                searchProd.setMaxPrice(prodSummary.getMaxprice());
                searchProd.setMinPrice(prodSummary.getMinprice());
                searchProd.setProdId(prodSummary.getProdid());
                searchProd.setProdName(prodSummary.getProdname());
                searchProd.setProvinceId(prodSummary.getProvinceid());
                searchProd.setSales(prodSummary.getSales());
                searchProd.setSeqFactor(prodSummary.getSeqfactor());
                searchProd.setShopId(prodSummary.getShopid());
                searchProd.setStatus(prodSummary.getStatus());
                searchProd.setUpdateTime(DateUtil.getString(prodSummary.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
                searchProdList.add(searchProd);
            }
            searchProdInfo.setProds(searchProdList);
            resp.setData(searchProdInfo);
        }
    }
}
