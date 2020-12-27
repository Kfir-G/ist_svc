package com.ist.svc.controller;
import com.ist.svc.common.Exception.ServiceException;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.config.annotation.TokenCheck;
import com.ist.svc.controller.model.*;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.CPayTradeReq;
import com.ist.svc.controller.model.dto.QuerySubAcctReq;
import com.ist.svc.service.OrderService;
import com.ist.svc.service.newversion.PayService;
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: sunhaitao
 */
@RestController
@RequestMapping(value = "order")
@Api(value = "支付相关")
public class OrderController extends BaseController {
    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "getCartProdList")
    public QueryBaseResp getCartProdList(HttpServletRequest request, @Valid GetCartProdListReq req, BindingResult bindingResult) {
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())) {
                orderService.getCartProdList(req, resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.getCartProdList:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "getOrderList")
    public QueryBaseResp getOrderList(HttpServletRequest request, @Valid GetOrderListReq req, BindingResult bindingResult) {
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())) {
                orderService.getOrderList(req, resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.getOrderList:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "joinCart")
    public QueryBaseResp joinCart(HttpServletRequest request, @Valid JoinCartReq req, BindingResult bindingResult) {
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())) {
                orderService.joinCart(req, resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.joinCart:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "delCart")
    public BaseResp delCart(HttpServletRequest request, @Valid DelCartReq req, BindingResult bindingResult) {
        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(request.getParameterMap())) {
                orderService.delCart(req, resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.delCart:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "order")
    public BaseResp order(HttpServletRequest request, @RequestBody @Valid OrderReq req, BindingResult bindingResult) {
        QueryBaseResp resp = new QueryBaseResp();
        try {
//            StringBuffer jb = new StringBuffer();
//            String line = null;
//            BufferedReader reader = request.getReader();
//            while ((line = reader.readLine()) != null)
//                jb.append(line);
//            String orders = request.getParameter("orders");
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            //暂时去掉签名
//            if (vaildAppSign(req)){
            orderService.order(req, resp);
//            }else {
//                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
//                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
//            }
        } catch (Exception e) {
            logger.error("OrderController.order:", e);
            if (e instanceof ServiceException) {
                return resp;
            }
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "closeOrder")
    public BaseResp closeOrder(HttpServletRequest request, @Valid CloseOrderReq req, BindingResult bindingResult) {
        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)) {
                orderService.closeOrder(req, resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.closeOrder:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "updateOrder")
    public BaseResp updateOrder(@Valid UpdateOrderReq req, BindingResult bindingResult) {
        BaseResp resp = new BaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)) {
                orderService.updateOrder(req, resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.updateOrder:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "wxPayNotify")
    public WxPayNotifyResp wxPayNotify(HttpServletRequest request) {
        WxPayNotifyResp resp = new WxPayNotifyResp();
        try {
            //参数校验
            StringBuffer reqDataBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                reqDataBuffer.append(line);
            }
            String receviceStr = reqDataBuffer.toString();
            logger.info("reqDataBuffer==>" + receviceStr);
            if (StringUtils.isBlank(receviceStr)) {
                resp.setReturnCode("FAIL");
                resp.setReturnMsg("请求内容为空");
            } else {
                //解析
                orderService.wxPayNotify(receviceStr, resp);
            }
            logger.info("wxPayNotifyReq==>" + receviceStr.toString() + ",resp==>" + resp);
        } catch (Exception e) {
            logger.error("OrderController.wxPayNotify:", e);
            resp.setReturnCode(ResultConstant.WEIXIN_NOTIFY_ERROR_CODE);
            resp.setReturnMsg(ResultConstant.APP_ERROR_MSG);
        }

        return resp;
    }

    @RequestMapping(value = "addAcctBook")
    public QueryBaseResp addAcctBook(HttpServletRequest request, @Valid @RequestBody AddAcctBookReq req, BindingResult bindingResult) {
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)) {
                orderService.addAcctBook(req, resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.addAcctBook:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "queryAcctBook")
    public QueryBaseResp queryAcctBook(HttpServletRequest request, @Valid @RequestBody QueryAcctBookReq req, BindingResult bindingResult) {
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)) {
                orderService.queryAcctBook(req, resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.queryAcctBook:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "addAcct")
    public QueryBaseResp addAcct(HttpServletRequest request, @Valid  @RequestBody AddAcctReq req, BindingResult bindingResult) {
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)) {
                orderService.addAcct(req, resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.addAcct:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    @RequestMapping(value = "addSubAcct")
    public QueryBaseResp addSubAcct(HttpServletRequest request, @Valid @RequestBody AddSubAcctReq req, BindingResult bindingResult) {
        QueryBaseResp resp = new QueryBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)) {
                orderService.addSubAcct(req, resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.addSubAcct:", e);
            resp.setCode(ResultConstant.APP_ERROR_CODE);
            resp.setMsg(ResultConstant.APP_ERROR_MSG);
        }
        return resp;
    }

    //查询子账户
    @RequestMapping(value = "querySubAcct", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    @ApiOperation(value = "查询子账户")
    @TokenCheck
    public ApiBaseResp querySubAcct(@Valid @RequestBody QuerySubAcctReq req, BindingResult bindingResult) {
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)) {
                orderService.querySubAcct(req,resp);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.querySubAcct", e);
        }
        return resp;
    }

    //预支付
    @RequestMapping(value = "prePay", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    @ApiOperation(value = "预支付")
    @TokenCheck
    public ApiBaseResp prePay(@Valid @RequestBody CPayTradeReq req, BindingResult bindingResult) {
        ApiBaseResp resp = new ApiBaseResp();
        try {
            if (bindingResult.hasErrors()) {
                String msg = bindingResult.getFieldError().getDefaultMessage();
                resp.setCode(ResultConstant.PARAM_ERROR_CODE);
                resp.setMsg(msg);
                return resp;
            }
            if (vaildAppSign(req)) {
                resp = payService.prePay(req);
            } else {
                resp.setCode(ResultConstant.SIGN_ERROR_CODE);
                resp.setMsg(ResultConstant.SIGN_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("OrderController.prePay", e);
        }
        return resp;
    }

    @RequestMapping(value = "aliPayNotify")
    public String aliPayNotify(HttpServletRequest request) {
        String result = "";
        try {
            //参数校验
            Map<String, String> params = new HashMap<String, String>();
            Map requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。
                //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }
            if (params.isEmpty()) {
                result = "fail";
            } else {
                //解析
                result = payService.aliPayNotify(params);
            }
            logger.info("aliPayNotify==>" + params.toString() + ",resp==>" + result);
        } catch (Exception e) {
            logger.error("OrderController.aliPayNotify:", e);
            result = "fail";
        }

        return result;
    }
}
