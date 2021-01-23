package com.ist.svc.controller.newversion;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.config.annotation.TokenCheck;
import com.ist.svc.controller.BaseController;
import com.ist.svc.controller.model.BaseResp;
import com.ist.svc.controller.model.dto.*;
import com.ist.svc.service.newversion.UserFriendService;
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
 * @Author: sunhaitao
 */
@RestController
@Api(value = "用户好友相关")
public class CUserFriendController extends BaseController {
    @Autowired
    private UserFriendService userFriendService;
    @RequestMapping(value = "queryUserFriendByUserId",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "根据userId查询好友列表", notes = "userId不能为空")
    @TokenCheck
    public QueryUserFriendByUserIdResp queryUserFriendByUserId(@Valid @RequestBody(required=false) QueryUserFriendByUserIdReq req, BindingResult bindingResult){
        QueryUserFriendByUserIdResp resp = new QueryUserFriendByUserIdResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = userFriendService.queryUserFriendByUserId(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CUserFriendController.queryUserFriendByUserId",e);
        }
        return resp;
    }

    @RequestMapping(value = "joinUserFriendNotify",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "好友通过通知", notes = "userId不能为空")
    @TokenCheck
    public BaseResp joinUserFriendNotify(@Valid @RequestBody(required=false) JoinUserFriendNotifyReq req, BindingResult bindingResult){

        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = userFriendService.joinUserFriendNotify(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CUserFriendController.joinUserFriendNotify",e);
        }
        return resp;
    }

    @RequestMapping(value = "modifyUserFriend",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "修改好友备注或分组类型", notes = "userId不能为空")
    @TokenCheck
    public BaseResp modifyUserFriend(@Valid @RequestBody(required=false) ModifyUserFriendReq req, BindingResult bindingResult){

        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = userFriendService.modifyUserFriend(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("CUserFriendController.modifyUserFriend",e);
        }
        return resp;
    }
}
