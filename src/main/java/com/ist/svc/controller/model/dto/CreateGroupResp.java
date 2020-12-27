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
@ApiModel(description = "创建分组响应")
public class CreateGroupResp {
    @ApiModelProperty(value = "返回码")
    private String code;
    @ApiModelProperty(value = "返回描述")
    private String msg;
    @ApiModelProperty(value = "返回详情")
    private CreateGroupData data;

    public static CreateGroupResp succ(CreateGroupData info){
        CreateGroupResp resp = new CreateGroupResp();
        resp.setData(info);
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
        return resp;
    }
}
