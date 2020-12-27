package com.ist.svc.service;

import com.ist.svc.controller.model.GetShopManagerReq;
import com.ist.svc.controller.model.GetShopsByShopIdsReq;
import com.ist.svc.controller.model.QueryBaseResp;

/**
 * @Author: sunhaitao
 */
public interface ShopService {
    void getShopsByShopIds(GetShopsByShopIdsReq req, QueryBaseResp resp) throws Exception;

    void getShopManager(GetShopManagerReq req, QueryBaseResp resp) throws Exception;
}
