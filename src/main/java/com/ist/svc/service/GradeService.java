package com.ist.svc.service;

import com.ist.svc.controller.model.BaseResp;
import com.ist.svc.controller.model.GetProdGradeReq;
import com.ist.svc.controller.model.GradeOrderReq;
import com.ist.svc.controller.model.QueryBaseResp;

/**
 * @Author: sunhaitao
 */
public interface GradeService {
    void gradeOrder(GradeOrderReq req, BaseResp resp) throws Exception;

    void getProdGradeList(GetProdGradeReq req, QueryBaseResp resp) throws Exception;
}
