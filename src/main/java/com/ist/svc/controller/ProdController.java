package com.ist.svc.controller;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.controller.model.*;
import com.ist.svc.service.ProdService;
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
@RequestMapping(value = "prod")
public class ProdController extends BaseController{
    @Autowired
    private ProdService prodService;

    @RequestMapping(value = "queryProdInfo")
    public QueryBaseResp queryProdInfo(HttpServletRequest request, @Valid ProdQueryReq req, BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                prodService.prodQuery(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ProdController.queryProdInfo:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "queryProdInfoByKey")
    public QueryBaseResp queryProdInfoByKey(HttpServletRequest request, @Valid QueryProdInfoByKeyReq req, BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                prodService.queryProdInfoByKey(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ProdController.queryProdInfoByKey:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
    @RequestMapping(value = "queryProdInfoByShopId")
    public QueryBaseResp queryProdInfoByShopId(HttpServletRequest request, @Valid QueryProdInfoByShopIdReq req, BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                prodService.queryProdInfoByShopId(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ProdController.queryProdInfoByShopId:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
    @RequestMapping(value = "queryProdInfoByProdType")
    public QueryBaseResp queryProdInfoByProdType(HttpServletRequest request, @Valid QueryProdInfoByProdTypeReq req, BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                prodService.queryProdInfoByProdType(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ProdController.queryProdInfoByProdType:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "queryProdInfoByProdInfoIds")
    public QueryBaseResp queryProdInfoByProdInfoIds(HttpServletRequest request, @Valid QueryProdInfoByProdInfoIdsReq req, BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                prodService.queryProdInfoByProdInfoIds(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ProdController.queryProdInfoByProdInfoIds:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
}
