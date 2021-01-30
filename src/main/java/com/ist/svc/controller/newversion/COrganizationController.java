package com.ist.svc.controller.newversion;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.config.annotation.TokenCheck;
import com.ist.svc.controller.BaseController;
import com.ist.svc.controller.model.dto.AddInfoOrgDto;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.QueryInfoOrgDto;
import com.ist.svc.controller.model.dto.QueryInfoVillageDto;
import com.ist.svc.service.newversion.IOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
@Api(value = "组织相关")
public class COrganizationController extends BaseController {
    @Autowired
    private IOrganizationService organizationService;

    @RequestMapping(value = "queryInfoVillage",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "查询村庄信息")
    @TokenCheck
    public ApiBaseResp queryInfoVillage(@Valid @RequestBody QueryInfoVillageDto queryInfoVillageDto, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (StringUtils.isBlank(queryInfoVillageDto.getTown()) && StringUtils.isBlank(queryInfoVillageDto.getAreaId()) && StringUtils.isBlank(queryInfoVillageDto.getVillage())){
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(ResultConstant.PARAM_ERROR_MSG+"town|areaId|village");
                return resp;
            }
            if (vaildAppSign(queryInfoVillageDto)){
                resp = organizationService.queryInfoVillage(queryInfoVillageDto);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("COrganizationController.queryInfoVillage",e);
        }
        return resp;
    }

    @RequestMapping(value = "addInfoOrg",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "添加组织")
    @TokenCheck
    public ApiBaseResp addInfoOrg(@Valid @RequestBody AddInfoOrgDto addInfoOrgDto, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(addInfoOrgDto)){
                resp = organizationService.addInfoOrg(addInfoOrgDto);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("COrganizationController.addInfoOrg",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "queryInfoOrg",produces="application/json;charset=UTF-8",method = RequestMethod.POST,consumes="application/json;charset=UTF-8")
    @ApiOperation(value = "查询组织")
    @TokenCheck
    public ApiBaseResp queryInfoOrg(@Valid @RequestBody QueryInfoOrgDto queryInfoOrgDto, BindingResult bindingResult){
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(queryInfoOrgDto)){
                resp = organizationService.queryInfoOrg(queryInfoOrgDto);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        }catch (Exception e){
            logger.error("COrganizationController.queryInfoOrg",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
}
