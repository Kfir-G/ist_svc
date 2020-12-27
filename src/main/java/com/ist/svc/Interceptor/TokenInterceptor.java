package com.ist.svc.Interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ist.svc.common.Exception.SvcException;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.config.RequestWrapper;
import com.ist.svc.config.annotation.TokenCheck;
import com.ist.svc.controller.model.UserVerifyTokenReq;
import com.ist.svc.controller.model.UserVerifyTokenResp;
import com.ist.svc.service.UserTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: sunhaitao
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private UserTokenService userTokenService;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            HandlerMethod handlerMethod = ((HandlerMethod) handler);

            if (handlerMethod.getMethod().isAnnotationPresent(TokenCheck.class)) {
                RequestWrapper requestWrapper = new RequestWrapper(request);
                String body = requestWrapper.getBody();
                JSONObject jsonObject1 = JSON.parseObject(body);
                if (null==jsonObject1){
                    throw new SvcException(ResultConstant.PARAM_ERROR_CODE,"tokenId不能为空");
                }
                String tokenId = jsonObject1.getString("tokenId");
                String userId = jsonObject1.getString("userId");
                String appId = jsonObject1.getString("appId");
                if(StringUtils.isEmpty(tokenId)){
                    throw new SvcException(ResultConstant.PARAM_ERROR_CODE,"tokenId不能为空");
                }
                if(StringUtils.isEmpty(userId)){
                    throw new SvcException(ResultConstant.PARAM_ERROR_CODE,"用户ID不能为空");
                }
                if(StringUtils.isEmpty(appId)){
                    throw new SvcException(ResultConstant.PARAM_ERROR_CODE,"应用ID不能为空");
                }
                log.info("token校验开始,tokenId: >>>: "+tokenId);
                try {
                    //校验token
                    UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
                    userVerifyTokenReq.setTokenId(tokenId);
                    userVerifyTokenReq.setUserId(userId);
                    UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
                    userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
                    if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
                        throw new SvcException(userVerifyTokenResp.getCode(),userVerifyTokenResp.getMsg());
                    }else {
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    log.warn("token校验失败,tokenId: >>>: "+tokenId);
                }
                throw new SvcException(ResultConstant.VERIFY_TOKEN_ERROR_CODE,ResultConstant.VERIFY_TOKEN_ERROR_MSG);
            }
        }
        return true;
    }

    public  String getOpenApiRequestData(HttpServletRequest request){
        try {

            int contentLength = request.getContentLength();
            if (contentLength < 0) {
                return null;
            }
            byte buffer[] = new byte[contentLength];
            for (int i = 0; i < contentLength;) {

                int readlen = request.getInputStream().read(buffer, i, contentLength - i);
                if (readlen == -1) {
                    break;
                }
                i += readlen;
            }

            String charEncoding = request.getCharacterEncoding();
            if (charEncoding == null) {
                charEncoding = "UTF-8";
            }
            return new String(buffer, charEncoding);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
