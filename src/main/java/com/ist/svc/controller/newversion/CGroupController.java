package com.ist.svc.controller.newversion;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.config.annotation.TokenCheck;
import com.ist.svc.controller.BaseController;
import com.ist.svc.controller.model.*;
import com.ist.svc.controller.model.dto.*;
import com.ist.svc.service.newversion.GroupService;
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
@Api(value = "聊天群组相关")
public class CGroupController extends BaseController {
    @Autowired
    private GroupService groupService;
    @RequestMapping(value = "addGroup",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "加群", notes = "群主id(groupId)不能为空，被邀请者(talkers,支持多个)不为空，邀请者(inviteUserId)不为空")
    @TokenCheck
    public AddGroupResp addGroup(HttpServletRequest request, @Valid @RequestBody AddGroupReq req, BindingResult bindingResult){
        AddGroupResp resp = new AddGroupResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = groupService.addGroup(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("GroupController.addGroup",e);
        }
        return resp;
    }

    @RequestMapping(value = "createGroup",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "创建群组", notes = "optUserId不能为空，组名不能为空")
    @TokenCheck
    public CreateGroupResp createGroup(HttpServletRequest request, @Valid @RequestBody(required=false) CreateGroupReq req, BindingResult bindingResult){
        CreateGroupResp resp = new CreateGroupResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = groupService.createGroup(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("GroupController.createGroup",e);
        }
        return resp;
    }
    @RequestMapping(value = "modifyGroupInfoById",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "修改群组", notes = "群状态群名称进群方式不能同时为空")
    @TokenCheck
    public BaseResp modifyGroupInfoById(HttpServletRequest request, @Valid @RequestBody ModifyGroupInfoByIdReq req, BindingResult bindingResult){
        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = groupService.modifyGroupInfoById(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("GroupController.modifyGroupInfoById",e);
        }
        return resp;
    }
    @RequestMapping(value = "modifyGroupMemInfobyId",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "修改群成员", notes = "昵称和角色不能同时为空")
    @TokenCheck
    public BaseResp modifyGroupMemInfobyId(HttpServletRequest request, @Valid @RequestBody ModifyGroupMemInfobyIdReq req, BindingResult bindingResult){
        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = groupService.modifyGroupMemInfobyId(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("GroupController.modifyGroupMemInfobyId",e);
        }
        return resp;
    }
    @RequestMapping(value = "getGroupInfobyIds",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "查询群基本信息", notes = "groupIds不能为空")
    @TokenCheck
    public ApiBaseResp getGroupInfobyIds(HttpServletRequest request, @Valid @RequestBody GetGroupInfoByIdsReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)){
                resp = groupService.getGroupInfobyIds(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("GroupController.getGroupInfobyIds",e);
        }
        return resp;
    }

    @RequestMapping(value = "getGroupMemInfobyIds",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "查询群成员信息", notes = "groupIds不能为空")
    @TokenCheck
    public ApiBaseResp getGroupMemInfobyIds(HttpServletRequest request, @Valid @RequestBody GetGroupMemInfobyIdsReq req, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (StringUtils.isBlank(req.getGroupIds()) && StringUtils.isBlank(req.getTalkers())){
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(ResultConstant.PARAM_ERROR_MSG+"groupIds|talkers");
                return resp;
            }
            if (vaildAppSign(req)){
                resp = groupService.getGroupMemInfobyIds(req);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("GroupController.getGroupMemInfobyIds",e);
        }
        return resp;
    }


//    @RequestMapping(value = "getGroupsByUserId",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
//    @ApiOperation(value = "查询用户群组", notes = "groupId不能为空")
//    @TokenCheck
//    public GetGroupsByUserIdResp getGroupsByUserId(HttpServletRequest request, @Valid @RequestBody GetGroupsByUserIdReq req, BindingResult bindingResult){
//        GetGroupsByUserIdResp resp = new GetGroupsByUserIdResp();
//        try {
//            if (bindingResult.hasErrors()){
//                String msg = bindingResult.getFieldError().getDefaultMessage();
//                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
//                resp.setMsg(msg);
//                return resp;
//            }
//            if (vaildAppSign(req)){
//                resp = groupService.getGroupsByUserId(req);
//            }else {
//                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
//                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
//            }
//        }catch (Exception e){
//            logger.error("GroupController.getGroupsByUserId",e);
//        }
//        return resp;
//    }
}
