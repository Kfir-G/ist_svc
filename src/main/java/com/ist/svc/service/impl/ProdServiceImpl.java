package com.ist.svc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.*;
import com.ist.svc.dao.ProdMapper;
import com.ist.svc.dao.ProdOtherInfoMapper;
import com.ist.svc.domain.Prod;
import com.ist.svc.domain.ProdOtherInfo;
import com.ist.svc.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: sunhaitao
 */
@Service(value = "prodService")
public class ProdServiceImpl extends BaseServiceImpl implements ProdService {
    @Autowired
    private ProdMapper prodMapper;
    @Autowired
    private ProdOtherInfoMapper prodOtherInfoMapper;

    @Override
    @Transactional(readOnly = true)
    public void prodQuery(ProdQueryReq prodQueryReq, QueryBaseResp queryBaseResp) throws Exception {
        ProdQueryData prodQueryData = new ProdQueryData();
        List<ProdInfo> prodLists = new ArrayList<>();
        PageHelper.startPage(prodQueryReq.getPageNum(),prodQueryReq.getPageSize());
        Map<String,Object> params = new HashMap<>();
        params.put("prodInfoId",prodQueryReq.getProdInfoId());
        params.put("status", IstEnum.ProdStatus.NORMAL.getStatus());
        Page<Prod> page = (Page<Prod>) prodMapper.selectByParams(params);
        List<Prod> prods = page.getResult();
        if (prods != null && prods.size()>0){
            for(int i=0;i< prods.size();i++){
                Prod prod = prods.get(i);
                ProdInfo prodList = new ProdInfo();
//                prodList.setName(prod.getName());
                prodList.setProdId(prod.getProdid()+"");
//                prodList.setAmount(prod.getAmount());
//                prodList.setStartTime(DateUtil.getString(prod.getStarttime(),DateUtil.PATTERN_DATE_TIME));
//                prodList.setOffTime(DateUtil.getString(prod.getOfftime(),DateUtil.PATTERN_DATE_TIME));
                prodList.setOnlineTime(DateUtil.getString(prod.getOnlinetime(),DateUtil.PATTERN_DATE_TIME));
//                prodList.setOriginalfee(prod.getOriginalfee());
//                prodList.setSalefee(prod.getSalefee());
//                prodList.setSpec(prod.getSpec());
                prodList.setShopId(prod.getShopid().toString());
                prodLists.add(prodList);
                if (i==0){
                    prodQueryData.setDescr(prod.getDescr());
                    prodQueryData.setName(prod.getProdname());
                    prodQueryData.setProdInfoId(prodQueryReq.getProdInfoId());
                    prodQueryData.setHeadImg(prod.getHeadimg());
                    prodQueryData.setTopImgs(prod.getTopimgs());
                }
            }
        }
        queryBaseResp.setCode(ResultConstant.SUCCESS_CODE);
        queryBaseResp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
        prodQueryData.setTotal(page.getTotal());
        prodQueryData.setProdInfos(prodLists);
        queryBaseResp.setData(prodQueryData);
    }

    @Override
    public void queryProdInfoByKey(QueryProdInfoByKeyReq req, QueryBaseResp resp) throws Exception {
        List<ProdDataByKey> data = new ArrayList<>();
        Map<String,Object> params = new HashMap<>();
        params.put("key",req.getKey());
        params.put("status", IstEnum.ProdStatus.NORMAL.getStatus());
        List<ProdOtherInfo> list = prodOtherInfoMapper.selectByParams(params);
        if (null!=list && !list.isEmpty()){
            for (ProdOtherInfo prodOtherInfo : list){
                ProdDataByKey prodDataByKey = new ProdDataByKey();
                prodDataByKey.setDescr(prodOtherInfo.getDesc());
                prodDataByKey.setHeadImg(prodOtherInfo.getHeadimg());
                prodDataByKey.setMaxPrice(prodOtherInfo.getMaxprice().longValue());
                prodDataByKey.setMinPrice(prodOtherInfo.getMaxprice().longValue());
                prodDataByKey.setName(prodOtherInfo.getProdInfoName());
                prodDataByKey.setProdInfoId(prodOtherInfo.getProdinfoid().toString());
                prodDataByKey.setTopImgs(prodOtherInfo.getTopimgs());
                prodDataByKey.setSales(prodOtherInfo.getSales().longValue());
                data.add(prodDataByKey);
            }
        }
        resp.setData(data);
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
    }

    @Override
    public void queryProdInfoByShopId(QueryProdInfoByShopIdReq req, QueryBaseResp resp) throws Exception {
        ProdQueryData prodQueryData = new ProdQueryData();
        List<ProdInfo> prodLists = new ArrayList<>();
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        Map<String,Object> params = new HashMap<>();
        params.put("shopId",req.getShopId());
        params.put("status", IstEnum.ProdStatus.NORMAL.getStatus());
        Page<Prod> page = (Page<Prod>) prodMapper.selectByParams(params);
        List<Prod> prods = page.getResult();
        if (prods != null && prods.size()>0){
            for(int i=0;i< prods.size();i++){
                Prod prod = prods.get(i);
                ProdInfo prodList = new ProdInfo();
                prodList.setName(prod.getProdname());
                prodList.setProdId(prod.getProdid()+"");
//                prodList.setAmount(prod.getAmount());
//                prodList.setStartTime(DateUtil.getString(prod.getStarttime(),DateUtil.PATTERN_DATE_TIME));
//                prodList.setOffTime(DateUtil.getString(prod.getOfftime(),DateUtil.PATTERN_DATE_TIME));
                prodList.setOnlineTime(DateUtil.getString(prod.getOnlinetime(),DateUtil.PATTERN_DATE_TIME));
//                prodList.setOriginalfee(prod.getOriginalfee());
//                prodList.setSalefee(prod.getSalefee());
//                prodList.setSpec(prod.getSpec());
                prodLists.add(prodList);
                if (i==0){
//                    prodQueryData.setDescr(prod.getDesc());
//                    prodQueryData.setName(prod.getProdInfoName());
//                    prodQueryData.setProdInfoId(prod.getProdinfoid().toString());
                    prodQueryData.setHeadImg(prod.getHeadimg());
                    prodQueryData.setTopImgs(prod.getTopimgs());
                }
            }
        }
        prodQueryData.setTotal(page.getTotal());
        prodQueryData.setProdInfos(prodLists);
        resp.setData(prodQueryData);
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
    }

    @Override
    public void queryProdInfoByProdType(QueryProdInfoByProdTypeReq req, QueryBaseResp resp) throws Exception {
        ProdQueryData prodQueryData = new ProdQueryData();
        List<ProdInfo> prodLists = new ArrayList<>();
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        Map<String,Object> params = new HashMap<>();
        params.put("prodType",req.getProdType());
        params.put("status", IstEnum.ProdStatus.NORMAL.getStatus());
        Page<Prod> page = (Page<Prod>) prodMapper.selectByParams(params);
        List<Prod> prods = page.getResult();
        if (prods != null && prods.size()>0){
            for(int i=0;i< prods.size();i++){
                Prod prod = prods.get(i);
                ProdInfo prodList = new ProdInfo();
//                prodList.setName(prod.getName());
                prodList.setProdId(prod.getProdid()+"");
//                prodList.setAmount(prod.getAmount());
//                prodList.setStartTime(DateUtil.getString(prod.getStarttime(),DateUtil.PATTERN_DATE_TIME));
//                prodList.setOffTime(DateUtil.getString(prod.getOfftime(),DateUtil.PATTERN_DATE_TIME));
                prodList.setOnlineTime(DateUtil.getString(prod.getOnlinetime(),DateUtil.PATTERN_DATE_TIME));
//                prodList.setOriginalfee(prod.getOriginalfee());
//                prodList.setSalefee(prod.getSalefee());
//                prodList.setSpec(prod.getSpec());
                prodLists.add(prodList);
                if (i==0){
//                    prodQueryData.setDescr(prod.getDesc());
//                    prodQueryData.setName(prod.getProdInfoName());
//                    prodQueryData.setProdInfoId(prod.getProdinfoid().toString());
                    prodQueryData.setHeadImg(prod.getHeadimg());
                    prodQueryData.setTopImgs(prod.getTopimgs());
                }
            }
        }
        prodQueryData.setTotal(page.getTotal());
        prodQueryData.setProdInfos(prodLists);
        resp.setData(prodQueryData);
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
    }

    @Override
    public void queryProdInfoByProdInfoIds(QueryProdInfoByProdInfoIdsReq req, QueryBaseResp resp) throws Exception {
        ProdQueryData prodQueryData = new ProdQueryData();
        List<ProdInfo> prodLists = new ArrayList<>();
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        Map<String,Object> params = new HashMap<>();
        params.put("prodInfoIds",req.getProdInfoIds().split(","));
        params.put("status", IstEnum.ProdStatus.NORMAL.getStatus());
        Page<Prod> page = (Page<Prod>) prodMapper.selectByParams(params);
        List<Prod> prods = page.getResult();
        if (prods != null && prods.size()>0){
            for(int i=0;i< prods.size();i++){
                Prod prod = prods.get(i);
                ProdInfo prodList = new ProdInfo();
//                prodList.setName(prod.getName());
                prodList.setProdId(prod.getProdid()+"");
//                prodList.setAmount(prod.getAmount());
//                prodList.setStartTime(DateUtil.getString(prod.getStarttime(),DateUtil.PATTERN_DATE_TIME));
//                prodList.setOffTime(DateUtil.getString(prod.getOfftime(),DateUtil.PATTERN_DATE_TIME));
                prodList.setOnlineTime(DateUtil.getString(prod.getOnlinetime(),DateUtil.PATTERN_DATE_TIME));
//                prodList.setOriginalfee(prod.getOriginalfee());
//                prodList.setSalefee(prod.getSalefee());
//                prodList.setSpec(prod.getSpec());
                prodLists.add(prodList);
                if (i==0){
//                    prodQueryData.setDescr(prod.getDesc());
//                    prodQueryData.setName(prod.getProdInfoName());
//                    prodQueryData.setProdInfoId(prod.getProdinfoid().toString());
                    prodQueryData.setHeadImg(prod.getHeadimg());
                    prodQueryData.setTopImgs(prod.getTopimgs());
                }
            }
        }
        prodQueryData.setTotal(page.getTotal());
        prodQueryData.setProdInfos(prodLists);
        resp.setData(prodQueryData);
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
    }
}
