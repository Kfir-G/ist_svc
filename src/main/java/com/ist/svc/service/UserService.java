package com.ist.svc.service;

import com.ist.svc.controller.model.*;
import com.ist.svc.controller.model.dto.ModifyUserInfoReq;
import com.ist.svc.controller.model.dto.SendValidSmsReq;
import com.ist.svc.controller.model.dto.UserBindPhoneReq;
import com.ist.svc.controller.model.dto.VerifyValidSmsReq;
import com.ist.svc.domain.UserPasswd;

/**
 * @Author: sunhaitao
 */
public interface UserService {
    void userRegister(UserRegisterReq req, UserRegisterResp resp) throws Exception; //用户注册

    void userLogin(UserLoginReq req, UserLoginResp resp) throws Exception; //用户登陆

    UserPasswd getUserPasswdByLoginName(String loginName);

    void userVerifyToken(UserVerifyTokenReq req, UserVerifyTokenResp resp) throws Exception;

    void queryUserInfo(QueryUserInfoReq req, QueryUserInfoResp resp) throws Exception;

    void sendValidSms(SendValidSmsReq req, SendValidSmsResp resp) throws Exception;

    void addUserAddress(AddUserAddressReq req, AddUserAddressResp resp) throws Exception;

    void delUserAddress(DelUserAddressReq req, DelUserAddressResp resp) throws Exception;

    void queryUserAddress(QueryUserAddressReq req, QueryUserAddressResp resp) throws Exception;

    void getUsersByUserIds(GetUsersByUserIdsReq req, QueryBaseResp resp) throws Exception;

    void delRedisByUserId(String userId) throws Exception;

    void delRedisByLoginName(String userId);

    void userBindPhone(UserBindPhoneReq req, BaseResp resp);

    void verifyValidSmsCode(VerifyValidSmsReq req, BaseResp resp);

    void modifyUserInfo(ModifyUserInfoReq req, BaseResp resp);
}
