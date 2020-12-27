package com.ist.svc.controller.newversion;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.controller.BaseController;
import com.ist.svc.controller.model.dto.*;
import com.ist.svc.service.newversion.IFProdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Author: sunhaitao
 */
@RestController
@RequestMapping(value = "/client/prod/")
@Api(value = "产品相关接口,供后台管理调用")
public class CProdController extends BaseController{
    private IFProdService ifProdService;
    @Autowired
    public void setIfProdService(IFProdService ifProdService) {
        this.ifProdService = ifProdService;
    }

    @PostMapping(value = "searchProdLimit",produces="application/json;charset=UTF-8")
    @ApiOperation(value = "商品限制查询", notes = "根据prodLimitIds 或者tradeTypeId,prodTypeId,ShopId，\n" +
            "tradeTypeId如 like 94201未匹配再like 942最后再like 9\n" +
            "prodTypeId和ShopId用=匹配\n" +
            "优先级ShopId> prodTypeId>tradeTypeId。\n" +
            "status非必填\n")
    public ApiBaseResp searchProdLimit(HttpServletRequest request, @Valid SearchProdLimitReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        if (bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            resp.setCode(ResultConstant.PARAM_ERROR_CODE);
            resp.setMsg(msg);
            return resp;
        }
        if (StringUtils.isBlank(req.getProdLimitIds()) && StringUtils.isBlank(req.getProdTypeId()) && StringUtils.isBlank(req.getShopId()) && StringUtils.isBlank(req.getTradeTypeId())){
            resp.setCode(ResultConstant.PARAM_ERROR_CODE);
            resp.setMsg(ResultConstant.PARAM_ERROR_MSG);
            return resp;
        }
        if (vaildAppSign(request.getParameterMap())){
            ifProdService.searchProdLimit(req,resp);
        }else{
            resp.setCode(ResultConstant.SIGN_ERROR_CODE);
            resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
        }
        return resp;
    }

    @PostMapping(value = "getProdListByProdIds",produces="application/json;charset=UTF-8")
    @ApiOperation(value = "根据商品ids查询商品概要信息", notes = "返回Prod_summary全部字段")
    public ApiBaseResp getProdListByProdIds(HttpServletRequest request, @Valid GetProdListByProdIdsReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        if (bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            resp.setCode(ResultConstant.PARAM_ERROR_CODE);
            resp.setMsg(msg);
            return resp;
        }
        if (vaildAppSign(request.getParameterMap())){
            ifProdService.getProdListByProdIds(req,resp);
        }else{
            resp.setCode(ResultConstant.SIGN_ERROR_CODE);
            resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
        }
        return resp;
    }
    @PostMapping(value = "searchProd",produces="application/json;charset=UTF-8")
    @ApiOperation(value = "搜索商品", notes = "返回Prod_summary全部字段")
    public ApiBaseResp searchProd(HttpServletRequest request, @Valid SearchProdReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        if (bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            resp.setCode(ResultConstant.PARAM_ERROR_CODE);
            resp.setMsg(msg);
            return resp;
        }
        if (vaildAppSign(request.getParameterMap())){
            ifProdService.searchProd(req,resp);
        }else{
            resp.setCode(ResultConstant.SIGN_ERROR_CODE);
            resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
        }
        return resp;
    }
}
