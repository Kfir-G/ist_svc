package com.ist.svc.controller;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.controller.model.BaseResp;
import com.ist.svc.controller.model.GetProdGradeReq;
import com.ist.svc.controller.model.GradeOrderReq;
import com.ist.svc.controller.model.QueryBaseResp;
import com.ist.svc.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Author: sunhaitao
 */
@RestController
@RequestMapping(value = "grade")
public class GradeController extends BaseController{
    @Autowired
    private GradeService gradeService;

    @RequestMapping(value = "gradeOrder")
    public BaseResp gradeOrder(HttpServletRequest request, @RequestBody @Valid GradeOrderReq req, BindingResult bindingResult){
        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
//            if (vaildAppSign(req)){
            gradeService.gradeOrder(req,resp);
//            }else {
//                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
//                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
//            }
        }catch (Exception e){
            logger.error("GradeController.gradeOrder:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
    @RequestMapping(value = "getProdGradeList")
    public QueryBaseResp getProdGradeList(HttpServletRequest request,@Valid GetProdGradeReq req, BindingResult bindingResult){
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()){
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            gradeService.getProdGradeList(req,resp);
        }catch (Exception e){
            logger.error("GradeController.getProdGradeList:",e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }
}
