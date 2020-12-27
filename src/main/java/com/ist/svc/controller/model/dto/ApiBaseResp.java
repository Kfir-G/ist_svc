package com.ist.svc.controller.model.dto;

import com.ist.svc.common.ResultConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "基础api响应")
public class ApiBaseResp {
    @ApiModelProperty(value = "返回码")
    private String code;
    @ApiModelProperty(value = "返回描述")
    private String msg;
    @ApiModelProperty(value = "返回详情")
    private Object data;
    public static ApiBaseResp succ(Object info){
        ApiBaseResp resp = new ApiBaseResp();
        resp.setData(info);
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
        return resp;
    }
    public static ApiBaseResp result(String code,String msg){
        ApiBaseResp resp = new ApiBaseResp();
        resp.setCode(code);
        resp.setMsg(msg);
        return resp;
    }
    public static ApiBaseResp result(String code,String msg,Object info){
        ApiBaseResp resp = new ApiBaseResp();
        resp.setCode(code);
        resp.setMsg(msg);
        resp.setData(info);
        return resp;
    }
}
