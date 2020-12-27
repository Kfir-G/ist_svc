package com.ist.svc.controller;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.controller.model.GetShopManagerReq;
import com.ist.svc.controller.model.GetShopsByShopIdsReq;
import com.ist.svc.controller.model.QueryBaseResp;
import com.ist.svc.service.ShopService;
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
@RequestMapping(value = "shop")
public class ShopController extends BaseController{
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "getShopsByShopIds")
    public QueryBaseResp getShopsByShopIds(HttpServletRequest request,@Valid GetShopsByShopIdsReq req, BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                shopService.getShopsByShopIds(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ShopController.getShopsByShopIds:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
    @RequestMapping(value = "getShopManager")
    public QueryBaseResp getShopManager(HttpServletRequest request, @Valid GetShopManagerReq req,BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                shopService.getShopManager(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ShopController.getShopManager:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
}
