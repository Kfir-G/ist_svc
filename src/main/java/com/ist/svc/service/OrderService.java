package com.ist.svc.service;

import com.ist.svc.controller.model.*;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.QuerySubAcctReq;


/**
 * @Author: sunhaitao
 */
public interface OrderService {
    void getCartProdList(GetCartProdListReq req, QueryBaseResp resp)throws Exception;

    void getOrderList(GetOrderListReq req, QueryBaseResp resp)throws Exception;

    void joinCart(JoinCartReq req, QueryBaseResp resp) throws Exception;

    void delCart(DelCartReq req, BaseResp resp) throws Exception;

    void order(OrderReq req, QueryBaseResp resp) throws Exception;

    void closeOrder(CloseOrderReq req, BaseResp resp) throws Exception;

    void updateOrder(UpdateOrderReq req, BaseResp resp) throws Exception;

    void wxPayNotify(String receviceStr, WxPayNotifyResp resp) throws Exception;

    void addAcctBook(AddAcctBookReq req, QueryBaseResp resp) throws Exception;

    void queryAcctBook(QueryAcctBookReq req, QueryBaseResp resp) throws Exception;

    void addAcct(AddAcctReq req, QueryBaseResp resp) throws Exception;

    void addSubAcct(AddSubAcctReq req, QueryBaseResp resp) throws Exception;

    void querySubAcct(QuerySubAcctReq req, ApiBaseResp resp);
}
