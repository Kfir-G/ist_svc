package com.ist.svc.controller.newversion;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.config.annotation.TokenCheck;
import com.ist.svc.controller.BaseController;
import com.ist.svc.controller.model.BaseResp;
import com.ist.svc.controller.model.dto.*;
import com.ist.svc.service.newversion.BagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 红包相关控制器
 */
@RestController
@Api(value = "红包相关")
public class CBagController extends BaseController {
    @Autowired
    private BagService bagService;
    //创建红包
    @RequestMapping(value = "newBag",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "创建红包")
    @TokenCheck
    public ApiBaseResp newBag(@Valid @RequestBody CNewBagReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = bagService.newBag(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CBagController.newBag",e);
        }
        return resp;
    }

    //更新红包状态
    @RequestMapping(value = "uptBagStatus",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "更新红包状态")
    @TokenCheck
    public BaseResp uptBagStatus(@Valid @RequestBody UptBagStatusReq req, BindingResult bindingResult){
        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = bagService.uptBagStatus(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CBagController.uptBagStatus",e);
        }
        return resp;
    }
    //根据红包编号查询红包详情
    @RequestMapping(value = "queryBagByNo",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "根据红包编号查询红包详情")
    @TokenCheck
    public ApiBaseResp queryBagByNo(@Valid @RequestBody QueryBagByNoReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = bagService.queryBagByNo(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CBagController.queryBagByNo",e);
        }
        return resp;
    }

    //根据红包编号查询领取记录
    @RequestMapping(value = "queryBagDrawByNo",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "根据红包编号查询领取记录")
    @TokenCheck
    public ApiBaseResp queryBagDrawByNo(@Valid @RequestBody QueryBagDrawByNoReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = bagService.queryBagDrawByNo(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CBagController.queryBagDrawByNo",e);
        }
        return resp;
    }
    //领红包
    @RequestMapping(value = "drawBag",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "领红包")
    @TokenCheck
    public ApiBaseResp drawBag(@Valid @RequestBody DrawBagReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = bagService.drawBag(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CBagController.drawBag",e);
            throw e;
        }
        return resp;
    }

    //根据用户id查询发放红包
    @RequestMapping(value = "queryBagsByUserId",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "根据用户id查询发放红包")
    @TokenCheck
    public ApiBaseResp queryBagsByUserId(@Valid @RequestBody CQueryBagsByUserIdReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = bagService.queryBagsByUserId(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CBagController.queryBagsByUserId",e);
        }
        return resp;
    }
    //根据用户id查询红包领取记录
    @RequestMapping(value = "queryBagDrawsByUserId",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "根据用户id查询红包领取记录")
    @TokenCheck
    public ApiBaseResp queryBagDrawsByUserId(@Valid @RequestBody CQueryBagDrawsByUserIdReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = bagService.queryBagDrawsByUserId(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CBagController.queryBagDrawsByUserId",e);
        }
        return resp;
    }
}
