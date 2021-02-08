package com.ist.svc.controller.newversion;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.config.annotation.TokenCheck;
import com.ist.svc.controller.BaseController;
import com.ist.svc.controller.model.dto.AddInfoPublicKeyValueDto;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.QueryInfoPublicValueByPublicKeyDto;
import com.ist.svc.controller.model.dto.QueryInfoPublicValueByPublicKeyNoTokenDto;
import com.ist.svc.service.newversion.IInfoPublicKeyService;
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
@Api(value = "key-value")
public class CInfoPublicKeyController extends BaseController {
    @Autowired
    private IInfoPublicKeyService infoPublicKeyService;

    @RequestMapping(value = "queryInfoPublicValueByPublicKey", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    @ApiOperation(value = "查询key对应的value")
    @TokenCheck
    public ApiBaseResp queryInfoPublicValueByPublicKey(@Valid @RequestBody QueryInfoPublicValueByPublicKeyDto dto, BindingResult bindingResult) {
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(dto)){
                resp = infoPublicKeyService.queryInfoPublicValueByPublicKey(dto);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("CInfoPublicKeyController.queryInfoPublicValueByPublicKey", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "queryInfoPublicValueByPublicKeyNoToken", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    @ApiOperation(value = "查询key对应的value")
    @TokenCheck
    public ApiBaseResp queryInfoPublicValueByPublicKeyNoToken(@Valid @RequestBody QueryInfoPublicValueByPublicKeyNoTokenDto dto, BindingResult bindingResult) {
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(dto)){
                resp = infoPublicKeyService.queryInfoPublicValueByPublicKeyNoToken(dto);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("CInfoPublicKeyController.queryInfoPublicValueByPublicKeyNoToken", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "addInfoPublicKeyValue", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    @ApiOperation(value = "添加key-value")
    @TokenCheck
    public ApiBaseResp addInfoPublicKeyValue(@Valid @RequestBody AddInfoPublicKeyValueDto dto, BindingResult bindingResult) {
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(dto)){
                resp = infoPublicKeyService.addInfoPublicKeyValue(dto);
            }else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("CInfoPublicKeyController.addInfoPublicKeyValue", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
}
