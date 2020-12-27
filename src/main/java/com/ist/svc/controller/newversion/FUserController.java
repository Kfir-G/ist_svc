package com.ist.svc.controller.newversion;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.pojo.ResultVO;
import com.ist.svc.common.util.ResultUtil;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.BaseController;
import com.ist.svc.controller.model.UserLoginReq;
import com.ist.svc.controller.model.UserLoginResp;
import com.ist.svc.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author: sunhaitao
 */
@RestController
@RequestMapping(value = "/front/user/")
@Api(value = "后台用户,供后台管理调用")
public class FUserController extends BaseController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResultVO login(HttpServletRequest request, @Valid UserLoginReq req, BindingResult bindingResult,
                          HttpSession session) {
        UserLoginResp resp = new UserLoginResp();
        try {
            resp.setCode(ResultConstant.USER_LOGIN_SUCC_CODE);
            resp.setMsg(ResultConstant.USER_LOGIN_SUCC_MSG);
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
                resp.setMsg(message);
                return ResultUtil.errorResultVO(IstEnum.ResultEnum.OPERATE_FAIL,resp.getMsg());
            }
            if(vaildAppSign(request.getParameterMap())){
                userService.userLogin(req,resp);
                if (ResultConstant.SUCCESS_CODE.equals(resp.getCode())){
                    session.setAttribute("user", resp);
                    return ResultUtil.okResultVO(resp);
                }else{
                    return ResultUtil.errorResultVO(IstEnum.ResultEnum.OPERATE_FAIL,resp.getMsg());
                }
            }else{
                return ResultUtil.errorResultVO(IstEnum.ResultEnum.OPERATE_FAIL,ResultConstant.SIGN_ERROR_MSG);
            }

        } catch (Exception e) {
            logger.error("FUserController.login.error:",e);
            return ResultUtil.errorResultVO(IstEnum.ResultEnum.OPERATE_FAIL,e.getMessage());
        }
    }
    @GetMapping("/logout")
    public ResultVO logout(HttpSession session) {
        session.removeAttribute("user");
        return ResultUtil.okResultVO(null);
    }
    @GetMapping("/current-user")
    public ResultVO getCurrentUser(HttpSession session){
        UserLoginResp resp = (UserLoginResp) session.getAttribute("user");
        if (resp == null){
            return ResultUtil.errorResultVO(IstEnum.ResultEnum.OPERATE_FAIL,"用户未登录");
        }
        return ResultUtil.okResultVO(resp);
    }
}
