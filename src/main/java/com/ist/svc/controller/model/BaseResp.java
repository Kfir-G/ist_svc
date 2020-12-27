package com.ist.svc.controller.model;

import com.ist.svc.common.ResultConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: sunhaitao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResp {
    private String code;
    private String msg;
    public static BaseResp ok(){
        BaseResp resp = new BaseResp();
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
        return resp;
    }

    public static BaseResp result(String code,String msg){
        BaseResp resp = new BaseResp();
        resp.setCode(code);
        resp.setMsg(msg);
        return resp;
    }
}
