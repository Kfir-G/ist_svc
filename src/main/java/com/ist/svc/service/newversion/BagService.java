package com.ist.svc.service.newversion;

import com.ist.svc.controller.model.BaseResp;
import com.ist.svc.controller.model.dto.*;

public interface BagService {
    ApiBaseResp newBag(CNewBagReq cNewBagReq); //新建红包

    BaseResp uptBagStatus(UptBagStatusReq req); //更新红包状态

    ApiBaseResp queryBagByNo(QueryBagByNoReq req); //查询红包详情

    ApiBaseResp queryBagDrawByNo(QueryBagDrawByNoReq req); //查看领取记录

    ApiBaseResp drawBag(DrawBagReq req);  //领红包

    ApiBaseResp queryBagsByUserId(CQueryBagsByUserIdReq req);//根据用户id查询发放红包

    ApiBaseResp queryBagDrawsByUserId(CQueryBagDrawsByUserIdReq req);//根据用户id查询红包领取记录
}
