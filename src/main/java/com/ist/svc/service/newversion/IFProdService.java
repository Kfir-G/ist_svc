package com.ist.svc.service.newversion;

import com.ist.svc.controller.model.dto.*;

/**
 * @Author: sunhaitao
 */
public interface IFProdService {
    void searchProdLimit(SearchProdLimitReq req, ApiBaseResp resp);

    void getProdListByProdIds(GetProdListByProdIdsReq req, ApiBaseResp resp);

    void searchProd(SearchProdReq req, ApiBaseResp resp);
}
