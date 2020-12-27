package com.ist.svc.service;

import com.ist.svc.controller.model.*;

/**
 * @Author: sunhaitao
 */
public interface ProdService {
    void prodQuery(ProdQueryReq prodQueryReq, QueryBaseResp queryBaseResp) throws Exception;

    void queryProdInfoByKey(QueryProdInfoByKeyReq req, QueryBaseResp resp) throws Exception;

    void queryProdInfoByShopId(QueryProdInfoByShopIdReq req, QueryBaseResp resp) throws Exception;

    void queryProdInfoByProdType(QueryProdInfoByProdTypeReq req, QueryBaseResp resp) throws Exception;

    void queryProdInfoByProdInfoIds(QueryProdInfoByProdInfoIdsReq req, QueryBaseResp resp) throws Exception;
}
