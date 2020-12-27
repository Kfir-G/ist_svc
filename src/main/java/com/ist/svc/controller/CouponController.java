package com.ist.svc.controller;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.controller.model.*;
import com.ist.svc.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Author: sunhaitao
 */
@RestController
@RequestMapping(value = "coupon")
public class CouponController extends BaseController{
    @Autowired
    private CouponService couponService;

    @RequestMapping(value = "getUserCoupon")
    public QueryBaseResp getUserCoupon(HttpServletRequest request, @Valid GetUserCouponReq req , BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                couponService.getUserCoupon(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CouponController.getUserCoupon:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "receiveCoupon")
    public BaseResp receiveCoupon(HttpServletRequest request, @Valid ReceiveCouponReq req , BindingResult bindingResult){
        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                couponService.receiveCoupon(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CouponController.receiveCoupon:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "useCoupon")
    public BaseResp useCoupon(HttpServletRequest request, @Valid UseCouponReq req , BindingResult bindingResult){
        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                couponService.useCoupon(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CouponController.useCoupon:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "getShopCoupon")
    public BaseResp getShopCoupon(HttpServletRequest request, @Valid GetShopCouponReq req , BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                couponService.getShopCoupon(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CouponController.getShopCoupon:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
}
