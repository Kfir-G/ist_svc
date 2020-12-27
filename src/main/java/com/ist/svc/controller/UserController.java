package com.ist.svc.controller;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.pojo.ResultVO;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.config.IstEnum;
import com.ist.svc.config.annotation.TokenCheck;
import com.ist.svc.controller.model.*;
import com.ist.svc.controller.model.dto.ModifyUserInfoReq;
import com.ist.svc.controller.model.dto.SendValidSmsReq;
import com.ist.svc.controller.model.dto.UserBindPhoneReq;
import com.ist.svc.controller.model.dto.VerifyValidSmsReq;
import com.ist.svc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "user")
@Api(value = "用户相关")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "userRegister")
    public UserRegisterResp userRegister(HttpServletRequest request, @Valid UserRegisterReq registerReq, BindingResult bindingResult){
        UserRegisterResp resp = new UserRegisterResp();
        resp.setCode(ResultConstant.USER_REGISTER_SUCC_CODE);
        resp.setMsg(ResultConstant.USER_REGISTER_SUCC_MSG);
        try {
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(message);
                return resp;
            }
            if (StringUtils.isNoneBlank(registerReq.getBirthday()) && DateUtil.checkPattern(registerReq.getBirthday(),"yyyyMMddHHmmss")){
                resp.setCode(ResultConstant.USER_REGISTER_DATE_PATTERN_ERROR_CODE);
                resp.setMsg(ResultConstant.USER_REGISTER_DATE_PATTERN_ERROR_MSG);
                return resp;
            }
            if(vaildAppSign(request.getParameterMap())){
                userService.userRegister(registerReq,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
                return resp;
            }
        }catch (Exception e){
            logger.error("UserController.userRegister.error:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "userLogin")
    public UserLoginResp userLogin(HttpServletRequest request, @Valid UserLoginReq req,BindingResult bindingResult){
        UserLoginResp resp = new UserLoginResp();
        resp.setCode(ResultConstant.USER_LOGIN_SUCC_CODE);
        resp.setMsg(ResultConstant.USER_LOGIN_SUCC_MSG);
        try {
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(message);
                return resp;
            }

            if(vaildAppSign(request.getParameterMap())){
                userService.userLogin(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("UserController.userLogin.error:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }


    //清除缓存
    @RequestMapping(value = "clearMemUserLogin")
    public ResultVO delRedis(String userId,String loginName) throws Exception {
        userService.delRedisByUserId(userId);
        if (StringUtils.isNoneBlank(loginName)){
            userService.delRedisByLoginName(loginName);
        }
        return new ResultVO();
    }

    @RequestMapping(value = "userVerifyToken")
    public UserVerifyTokenResp userVerifyToken(HttpServletRequest request,@Valid UserVerifyTokenReq req,BindingResult bindingResult){
        UserVerifyTokenResp resp = new UserVerifyTokenResp();
        resp.setCode(ResultConstant.VERIFY_TOKEN_SUCC_CODE);
        resp.setMsg(ResultConstant.VERIFY_TOKEN_SUCC_MSG);
        try {
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(message);
                return resp;
            }
            if(vaildAppSign(request.getParameterMap())){
                userService.userVerifyToken(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("UserController.userVerifyToken.error:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "queryUserInfo")
    public QueryUserInfoResp queryUserInfo(HttpServletRequest request,@Valid QueryUserInfoReq req,BindingResult bindingResult){
        QueryUserInfoResp resp = new QueryUserInfoResp();
        resp.setCode(ResultConstant.QUERY_USER_INFO_SUCC_CODE);
        resp.setMsg(ResultConstant.QUERY_USER_INFO_SUCC_MSG);
        try {
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(message);
                return resp;
            }
            if(vaildAppSign(request.getParameterMap())){
                userService.queryUserInfo(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("UserController.queryUserInfo.error:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @ApiOperation(value = "发送短信验证码")
    @RequestMapping(value = "sendValidSmsCode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public SendValidSmsResp sendValidSms(@RequestBody @Valid SendValidSmsReq req, BindingResult bindingResult){
        SendValidSmsResp resp = new SendValidSmsResp();
        resp.setCode(ResultConstant.SEND_VALID_SMS_SUCC_CODE);
        resp.setMsg(ResultConstant.SEND_VALID_SMS_SUCC_MSG);
        try {
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(message);
                return resp;
            }
            if(vaildAppSign(req)){
                userService.sendValidSms(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("UserController.sendValidSms.error:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @ApiOperation(value = "校验短信验证码")
    @RequestMapping(value = "verifyValidSmsCode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public BaseResp verifyValidSmsCode(@RequestBody @Valid VerifyValidSmsReq req, BindingResult bindingResult){
        SendValidSmsResp resp = new SendValidSmsResp();
        resp.setCode(ResultConstant.VERIFY_VALID_SMS_CODE_SUCC_CODE);
        resp.setMsg(ResultConstant.VERIFY_VALID_SMS_CODE_SUCC_MSG);
        try {
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(message);
                return resp;
            }
            if(vaildAppSign(req)){
                userService.verifyValidSmsCode(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("UserController.verifyValidSmsCode.error:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
    @RequestMapping(value = "addUserAddress")
    public AddUserAddressResp addUserAddress(HttpServletRequest request,@Valid AddUserAddressReq req,BindingResult bindingResult){
        AddUserAddressResp resp = new AddUserAddressResp();
        resp.setCode(ResultConstant.ADD_USER_ADDRESS_SUCC_CODE);
        resp.setMsg(ResultConstant.ADD_USER_ADDRESS_SUCC_MSG);
        try {
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(message);
                return resp;
            }
            if (req.getOptType()==IstEnum.UserAddressOptType.TYPE_MODIFY.getType() && StringUtils.isBlank(req.getOldAddressId())){
                resp.setCode(ResultConstant.ADD_USER_ADDRESS_OLDADDRESSID_EMPTY_ERROR_CODE);
                resp.setMsg(ResultConstant.ADD_USER_ADDRESS_OLDADDRESSID_EMPTY_ERROR_MSG);
                return resp;
            }
            if(vaildAppSign(request.getParameterMap())){
                userService.addUserAddress(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("UserController.addUserAddress.error:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
    @RequestMapping(value = "delUserAddress")
    public DelUserAddressResp delUserAddress(HttpServletRequest request,@Valid DelUserAddressReq req,BindingResult bindingResult){
        DelUserAddressResp resp = new DelUserAddressResp();
        resp.setCode(ResultConstant.DEL_USER_ADDRESS_SUCC_CODE);
        resp.setMsg(ResultConstant.DEL_USER_ADDRESS_SUCC_MSG);
        try {
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(message);
                return resp;
            }
            if(vaildAppSign(request.getParameterMap())){
                userService.delUserAddress(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("UserController.delUserAddress.error:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
    @RequestMapping(value = "queryUserAddress")
    public QueryUserAddressResp queryUserAddress(HttpServletRequest request,@Valid QueryUserAddressReq req,BindingResult bindingResult){
        QueryUserAddressResp resp = new QueryUserAddressResp();
        resp.setCode(ResultConstant.QUERY_USER_ADDRESS_SUCC_CODE);
        resp.setMsg(ResultConstant.QUERY_USER_ADDRESS_SUCC_MSG);
        try {
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(message);
                return resp;
            }
            if (IstEnum.QueryUserAddressType.TYPE_USERID.getType()==req.getQueryType() && StringUtils.isBlank(req.getUserId())){
                resp.setCode(ResultConstant.QUERY_USER_ADDRESS_USERID_EMPTY_ERROR_CODE);
                resp.setMsg(ResultConstant.QUERY_USER_ADDRESS_USERID_EMPTY_ERROR_MSG);
                return resp;
            }
            if (IstEnum.QueryUserAddressType.TYPE_ADDRESSID.getType()==req.getQueryType() && StringUtils.isBlank(req.getAddressId())){
                resp.setCode(ResultConstant.QUERY_USER_ADDRESS_ADDRESSID_EMPTY_ERROR_CODE);
                resp.setMsg(ResultConstant.QUERY_USER_ADDRESS_ADDRESSID_EMPTY_ERROR_MSG);
                return resp;
            }
            if(vaildAppSign(request.getParameterMap())){
                userService.queryUserAddress(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("UserController.queryUserAddress.error:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "getUsersByUserIds")
    public QueryBaseResp getUsersByUserIds(HttpServletRequest request,@Valid GetUsersByUserIdsReq req,BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        resp.setCode(ResultConstant.QUERY_USER_INFO_SUCC_CODE);
        resp.setMsg(ResultConstant.QUERY_USER_INFO_SUCC_MSG);
        try {
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(message);
                return resp;
            }
            if(vaildAppSign(request.getParameterMap())){
                userService.getUsersByUserIds(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("UserController.getUsersByUserIds.error:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
    //绑定手机号
    @RequestMapping(value = "userBindPhone", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    @ApiOperation(value = "绑定手机号")
    @TokenCheck
    public BaseResp userBindPhone(@Valid @RequestBody UserBindPhoneReq req,BindingResult bindingResult){
        BaseResp resp = BaseResp.ok();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)) {
                userService.userBindPhone(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("OrderController.userBindPhone", e);
        }
        return resp;
    }

    //修改用户信息
    @RequestMapping(value = "modifyUserInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    @ApiOperation(value = "修改用户信息")
    @TokenCheck
    public BaseResp modifyUserInfo(@Valid @RequestBody ModifyUserInfoReq req, BindingResult bindingResult){
        BaseResp resp = BaseResp.ok();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)) {
                userService.modifyUserInfo(req,resp);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("OrderController.modifyUserInfo", e);
        }
        return resp;
    }
}
