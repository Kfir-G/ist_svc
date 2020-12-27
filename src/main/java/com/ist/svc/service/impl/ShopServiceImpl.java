package com.ist.svc.service.impl;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.controller.model.*;
import com.ist.svc.dao.ShopManagerMapper;
import com.ist.svc.dao.ShopMapper;
import com.ist.svc.domain.Shop;
import com.ist.svc.domain.ShopExample;
import com.ist.svc.domain.ShopManager;
import com.ist.svc.domain.ShopManagerExample;
import com.ist.svc.service.ShopService;
import com.ist.svc.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sunhaitao
 */
@Service(value = "shopService")
public class ShopServiceImpl extends BaseServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ShopManagerMapper shopManagerMapper;
    @Autowired
    private UserTokenService userTokenService;
    @Override
    public void getShopsByShopIds(GetShopsByShopIdsReq req, QueryBaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.GET_SHOP_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.GET_SHOP_TOKENID_ERROR_MSG);
            return;
        }
        //验证是否超过100个
        String[] userIdsArr = req.getShopIds().split(",");
        if (userIdsArr!=null && userIdsArr.length>100){
            resp.setCode(ResultConstant.GET_SHOP_SHOPIDS_ERROR_CODE);
            resp.setMsg(ResultConstant.GET_SHOP_SHOPIDS_ERROR_MSG);
            return;
        }
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        List<Integer> list = new ArrayList<>();
        for (String temp : Arrays.asList(req.getShopIds().split(","))){
            list.add(Integer.parseInt(temp));
        }
        criteria.andShopidIn(list);
        List<Shop> shops = shopMapper.selectByExample(example);
        List<ShopInfo> shopInfos = new ArrayList<>();
        for (Shop shop : shops){
            ShopInfo info = new ShopInfo();
            info.setAvatarUrl(shop.getAvatarurl());
            info.setShopId(shop.getShopid().toString());
            info.setShopName(shop.getShopname());
            shopInfos.add(info);
        }
        resp.setCode(ResultConstant.GET_SHOP_INFO_SUCC_CODE);
        resp.setMsg(ResultConstant.GET_SHOP_INFO_SUCC_MSG);
        resp.setData(shopInfos);
    }

    @Override
    public void getShopManager(GetShopManagerReq req, QueryBaseResp resp) throws Exception {
        resp.setCode(ResultConstant.GET_SHOP_MANAGER_SUCC_CODE);
        resp.setMsg(ResultConstant.GET_SHOP_MANAGER_SUCC_MSG);
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.GET_SHOP_MANAGER_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.GET_SHOP_MANAGER_TOKENID_ERROR_MSG);
            return;
        }
        ShopManagerExample example = new ShopManagerExample();
        ShopManagerExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(Long.valueOf(req.getUserId()));
        List<ShopManager> shopManagers = shopManagerMapper.selectByExample(example);
        List<ManagerInfo> listMi = new ArrayList<>();
        if (shopManagers!=null && shopManagers.size()>0){
            for (ShopManager shopManager : shopManagers){
                ManagerInfo managerInfo = new ManagerInfo();
                managerInfo.setCancelTime(shopManager.getCanceltime()!=null?DateUtil.getString(shopManager.getCanceltime(),DateUtil.PATTERN_DATE_TIME):"");
                managerInfo.setCs(shopManager.getCs()!=null?shopManager.getCs().intValue():0);
                managerInfo.setJob(shopManager.getJob()!=null?shopManager.getJob():"");
                managerInfo.setNickName(shopManager.getNickname()!=null?shopManager.getNickname():"");
                managerInfo.setStatus(shopManager.getStatus().intValue());
                managerInfo.setOwner(shopManager.getOwner().intValue());
                managerInfo.setUserId(shopManager.getUserid().toString());
                managerInfo.setShopId(shopManager.getShopid().toString());
                managerInfo.setJobType(shopManager.getJobtype().intValue());
                listMi.add(managerInfo);
            }
        }
        resp.setData(listMi);
    }
}
