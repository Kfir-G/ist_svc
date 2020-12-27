package com.ist.svc.service;


import com.ist.svc.controller.model.UserVerifyTokenReq;
import com.ist.svc.controller.model.UserVerifyTokenResp;

/**
 * @Author: sunhaitao
 */
public interface UserTokenService {
    /**
     * 根据账号，appId生成tokenId,放入redis中
     * @param accountNo
     * @param appId
     * @return
     */
     String genTokenId(String accountNo, String appId);

    /**
     * 通过tokenId取出账号
     * @param tokenId
     * @return
     */
     String checkTokenId(String tokenId);

//    /**
//     * 校验token
//     * @param req
//     * @param resp
//     */
     void verifyToken(UserVerifyTokenReq req, UserVerifyTokenResp resp);

    /**
     * 从缓存中删除TokenId
     * @param accountNo
     * @param appId
     * @return
     */
     boolean removeTokenId(String accountNo, String appId);

}
