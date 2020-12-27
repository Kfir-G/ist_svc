package com.ist.svc.service.newversion;

import com.alipay.api.AlipayApiException;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.CPayTradeReq;
import com.ist.svc.domain.UserAccountBook;

import java.util.Map;

public interface PayService {
    ApiBaseResp prePay(CPayTradeReq cPayTradeReq);//预支付

    String aliPayNotify(Map<String, String> params);  //支付宝回调通知

    boolean tradeQuery(UserAccountBook userAccountBook, Integer payType) throws AlipayApiException;//订单查询（查询接入方）

}
