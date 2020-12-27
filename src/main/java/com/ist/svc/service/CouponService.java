package com.ist.svc.service;

import com.ist.svc.controller.model.*;

/**
 * @Author: sunhaitao
 */
public interface CouponService {
    void getUserCoupon(GetUserCouponReq req, QueryBaseResp resp) throws  Exception;

    void receiveCoupon(ReceiveCouponReq req, BaseResp resp) throws  Exception;

    void useCoupon(UseCouponReq req, BaseResp resp) throws  Exception;

    void getShopCoupon(GetShopCouponReq req, QueryBaseResp resp) throws  Exception;

    void useCouponOrder(UseCouponReq req, BaseResp resp) throws  Exception;
}
