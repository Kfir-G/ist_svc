package com.ist.svc.service.impl;

import com.ist.svc.common.CodeConstant;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.EncryptUtil;
import com.ist.svc.common.util.RedisUtil;
import com.ist.svc.controller.model.UserVerifyTokenReq;
import com.ist.svc.controller.model.UserVerifyTokenResp;
import com.ist.svc.domain.UserPasswd;
import com.ist.svc.service.UserService;
import com.ist.svc.service.UserTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: sunhaitao
 */
@Service(value = "userTokenService")
public class UserTokenServiceImpl extends BaseServiceImpl implements UserTokenService {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public String genTokenId(String accountNo, String appId) {
        StringBuilder sourceSb = new StringBuilder(CodeConstant.REDIS_USER_TOKEN_ID_KEY_PREFIX);
        sourceSb.append(":");
        sourceSb.append(accountNo).append(":");
        sourceSb.append(appId);
        String redisKey = sourceSb.toString();
        sourceSb.append(":").append(System.currentTimeMillis());
        String tokenId = EncryptUtil.xorEncoder(sourceSb.toString());
        redisUtil.set(redisKey,tokenId,CodeConstant.USER_TOKEN_ID_SAVE_TIME);
        return tokenId;
    }

    @Override
    public String checkTokenId(String tokenId) {
        String accountNo = "";
        String appId = "";
        String decodeStr = EncryptUtil.xorDecoder(tokenId);
        if (StringUtils.isBlank(decodeStr) || decodeStr.indexOf(":") == -1){
            return null;
        }
        decodeStr = decodeStr.substring(decodeStr.indexOf(":") + 1);
        if(StringUtils.isBlank(decodeStr) || decodeStr.indexOf(":") == -1)
        {
            return null;
        }
        decodeStr = decodeStr.substring(decodeStr.indexOf(":") + 1);
        if(StringUtils.isBlank(decodeStr) || decodeStr.indexOf(":") == -1)
        {
            return null;
        }
        decodeStr = decodeStr.substring(decodeStr.indexOf(":") + 1);
        if(StringUtils.isBlank(decodeStr) || decodeStr.indexOf(":") == -1)
        {
            return null;
        }
        accountNo = decodeStr.substring(0, decodeStr.indexOf(":"));
        if(StringUtils.isBlank(accountNo))
        {
            return null;
        }
        decodeStr = decodeStr.substring(decodeStr.indexOf(":") + 1);
        if(StringUtils.isBlank(decodeStr) || decodeStr.indexOf(":") == -1)
        {
            return null;
        }
        appId = decodeStr.substring(0, decodeStr.indexOf(":"));
        if(StringUtils.isBlank(appId))
        {
            return null;
        }
        decodeStr = decodeStr.substring(decodeStr.indexOf(":") + 1);
        if(StringUtils.isBlank(decodeStr))
        {
            return null;
        }
        StringBuilder sourceSb = new StringBuilder(CodeConstant.REDIS_USER_TOKEN_ID_KEY_PREFIX);
        sourceSb.append(":");
        sourceSb.append(accountNo).append(":");
        sourceSb.append(appId);
        String redisKey = sourceSb.toString();
        String tokenIdTemp = (String) redisUtil.get(redisKey);
        if (tokenIdTemp != null && tokenIdTemp.equals(tokenId)) {
            return accountNo;
        }
        return null;
    }

    @Override
    public void verifyToken(UserVerifyTokenReq req, UserVerifyTokenResp resp) {
        String tokenId = req.getTokenId();
        if (StringUtils.isBlank(tokenId)){
            resp.setCode(ResultConstant.VERIFY_TOKEN_ERROR_CODE);
            resp.setMsg(ResultConstant.VERIFY_TOKEN_ERROR_MSG);
            return;
        }
        String accountNo = this.checkTokenId(tokenId);
        if (accountNo == null){
            resp.setCode(ResultConstant.VERIFY_TOKEN_ERROR_CODE);
            resp.setMsg(ResultConstant.VERIFY_TOKEN_ERROR_MSG);
            return;
        }
        if ("".equals(accountNo)){
            resp.setCode(ResultConstant.VERIFY_TOKEN_EXPIRED_CODE);
            resp.setMsg(ResultConstant.VERIFY_TOKEN_EXPIRED_MSG);
            return;
        }
        resp.setCode(ResultConstant.VERIFY_TOKEN_SUCC_CODE);
        resp.setMsg(ResultConstant.VERIFY_TOKEN_SUCC_MSG);
        resp.setLoginName(accountNo);
        UserPasswd userInfo = userService.getUserPasswdByLoginName(accountNo);
        if (userInfo == null){
            resp.setCode(ResultConstant.VERIFY_TOKEN_EXPIRED_CODE);
            resp.setMsg(ResultConstant.VERIFY_TOKEN_EXPIRED_MSG);
            return;
        }else {
            if (!StringUtils.equalsIgnoreCase(userInfo.getUserid().toString(),req.getUserId())){
                resp.setCode(ResultConstant.VERIFY_TOKEN_EXPIRED_CODE);
                resp.setMsg(ResultConstant.VERIFY_TOKEN_EXPIRED_MSG);
            }
            resp.setUserId(userInfo.getUserid() + "");
        }
    }

    @Override
    public boolean removeTokenId(String accountNo, String appId) {
        return false;
    }
}
