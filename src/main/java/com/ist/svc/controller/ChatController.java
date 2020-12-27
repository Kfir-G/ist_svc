package com.ist.svc.controller;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.controller.model.*;
import com.ist.svc.service.ChatService;
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
@RequestMapping(value = "chat")
public class ChatController extends BaseController{
    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "sendMsg")
    public SendMsgResp sendMsg(HttpServletRequest request, @Valid SendMsgReq req, BindingResult bindingResult){
        SendMsgResp resp = new SendMsgResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                chatService.sendMsg(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ChatController.sendMsg:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "queryWindowMsg")
    public QueryBaseResp queryWindowMsg(HttpServletRequest request, @Valid QueryWindowMsgReq req,BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                chatService.queryWindowMsg(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ChatController.queryWindowMsg:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
    @RequestMapping(value = "createWindow")
    public CreateWindowResp createWindow(HttpServletRequest request, @Valid CreateWindowReq req, BindingResult bindingResult){
        CreateWindowResp resp = new CreateWindowResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                chatService.createWindow(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ChatController.createWindow:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
    @RequestMapping(value = "queryMsgByWindowIds")
    public QueryBaseResp queryMsgByWindowIds(HttpServletRequest request, @Valid QueryMsgByWindowIdsReq req,BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                chatService.queryMsgByWindowIds(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ChatController.queryMsgByWindowIds:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "updateMsgStatus")
    public BaseResp updateMsgStatus(HttpServletRequest request, @Valid UpdateMsgStatusReq req, BindingResult bindingResult){
        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                chatService.updateMsgStatus(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ChatController.updateMsgStatus:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "queryWindows")
    public BaseResp queryWindows(HttpServletRequest request, @Valid QueryWindowsReq req, BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())){
                chatService.queryWindows(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("ChatController.queryWindows:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
}
