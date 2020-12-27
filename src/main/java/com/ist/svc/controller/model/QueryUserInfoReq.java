package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class QueryUserInfoReq extends BaseReq{
    @NotNull(message = "operType不能为空")
    private Integer operType;
    private String userId;
    private String loginNames;

}
