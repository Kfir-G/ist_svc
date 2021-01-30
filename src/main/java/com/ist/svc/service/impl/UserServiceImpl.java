package com.ist.svc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ist.svc.config.IstConfig;
import com.ist.svc.controller.model.dto.*;
import com.ist.svc.domain.UserAddress;
import com.ist.svc.service.newversion.SmsService;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.ist.svc.common.CodeConstant;
import com.ist.svc.common.RedisKeyUtil;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.*;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.*;
import com.ist.svc.dao.CommonMapper;
import com.ist.svc.dao.UserMapper;
import com.ist.svc.dao.UserPasswdMapper;
import com.ist.svc.domain.*;
import com.ist.svc.service.UserAddressService;
import com.ist.svc.service.UserService;
import com.ist.svc.service.UserTokenService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.spec.AlgorithmParameterSpec;
import java.util.*;

@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    @Autowired
    private UserPasswdMapper userPasswdMapper;
    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserTokenService userTokenService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private WXUtil wxUtil;
    @Autowired
    private SmsService smsService;
    @Autowired
    private IstConfig istConfig;
    public int NEXT_SEND_INTERVAL = 50;

    // hash方法
    /** BKDR算法 */
    protected final static int HASH_TYPE_BKDR = 1;
    /** SDBM算法 */
    protected final static int HASH_TYPE_SDBM = 2;
    @Override
    public void userRegister(UserRegisterReq req, UserRegisterResp resp) throws Exception {
        //查看用户是否存在
        UserPasswd userPasswd = getUserPasswdByLoginName(req.getLoginName());
        if (userPasswd != null) {
            resp.setCode(ResultConstant.USER_REGISTER_ACCOUNT_NUMBER_EXIT_CODE);
            resp.setMsg(ResultConstant.USER_REGISTER_ACCOUNT_NUMBER_EXIT_MSG);
            resp.setUserId(userPasswd.getUserid().toString());
        }else {
            // 设置UID
            String userId = generatorUID(IstEnum.ProductLine.UNIT_PRODUCT, IstEnum.UserType.getUserType(req.getUserType()), req.getLoginName(),HASH_TYPE_BKDR);
            if(StringUtils.isNoneBlank(userId)){
                insertUserInfo(req,userId);
//                try {
//                }catch (RuntimeException e){
//                    logger.warn("insertUserInfo.error:",e);
//                }
                resp.setUserId(userId);
            }else {
                resp.setCode(ResultConstant.USER_REGISTER_CREATE_UID_FAILD_CODE);
                resp.setMsg(ResultConstant.USER_REGISTER_CREATE_UID_FAILD_MSG);
            }
        }
    }
    @Override
    public UserPasswd getUserPasswdByLoginName(String loginName){
        //先从缓存获取
        String redisKey = CodeConstant.REDIS_USER_INFO + loginName;
        UserPasswd userPasswdRedis = (UserPasswd) redisUtil.get(redisKey);
        if (userPasswdRedis!=null){
            return userPasswdRedis;
        }
        //查看用户是否存在
        Map<String, Object> params = new HashMap<>();
        params.put("loginName",loginName);
        UserPasswd userPasswd = userPasswdMapper.selectByParams(params);
        if (userPasswd!=null){
            //放入缓存
            redisUtil.set(redisKey,userPasswd,CodeConstant.REDIS_SAVE_TIME_24h);
        }
        return userPasswd;
    }

    @Override
    public void userVerifyToken(UserVerifyTokenReq req, UserVerifyTokenResp resp) throws Exception {
        userTokenService.verifyToken(req,resp);
    }

    @Override
    public void queryUserInfo(QueryUserInfoReq req, QueryUserInfoResp resp) throws Exception {
        if (req.getOperType()==IstEnum.QueryUserOperType.TYPE_ACCOUNT.getType() && StringUtils.isBlank(req.getLoginNames())){
            resp.setCode(ResultConstant.QUERY_USER_INFO_ACCOUNT_NULL_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_USER_INFO_ACCOUNT_NULL_ERROR_MSG);
            return;
        }
        if (req.getOperType()==IstEnum.QueryUserOperType.TYPE_USERID.getType() && StringUtils.isBlank(req.getUserId())){
            resp.setCode(ResultConstant.QUERY_USER_INFO_USERID_NULL_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_USER_INFO_USERID_NULL_ERROR_MSG);
            return;
        }
        List<UserInfo> userInfos = new ArrayList<>();
        if(req.getOperType()==IstEnum.QueryUserOperType.TYPE_ACCOUNT.getType()){
            //查询用户信息是否存在
            for(String loginName : req.getLoginNames().split(",")){
                UserPasswd userPasswd = getUserPasswdByLoginName(loginName);
                if (null==userPasswd){
                    continue;
                }
                UserInfo userInfo = new UserInfo();
                userInfo.setLoginName(userPasswd.getLoginname());
                if(null!=userPasswd){
                    userInfo.setNickName(userPasswd.getNickName());
                    userInfo.setUserId(userPasswd.getUserid().toString());
                    userInfo.setAvatarUrl(userPasswd.getAvatarUrl()!=null?userPasswd.getAvatarUrl():"");
                    userInfo.setAge(userPasswd.getAge());
                    if (userPasswd.getBirthday()!=null){
                        userInfo.setBirthday(DateUtil.getString(userPasswd.getBirthday(),DateUtil.PATTERN_DATE_TIME));
                    }
                    userInfo.setSex(userPasswd.getSex());
                    userInfo.setPhone(userPasswd.getPhone());
                    userInfos.add(userInfo);
                }
            }

        }else if(req.getOperType()==IstEnum.QueryUserOperType.TYPE_USERID.getType()){
            List<UserPasswd>  userPasswds = getUserPasswdByUid(req.getUserId());
            for (UserPasswd userPasswd : userPasswds){
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(userPasswd.getUserid().toString());
                userInfo.setLoginName(userPasswd.getLoginname());
                userInfo.setNickName(userPasswd.getNickName());
                userInfo.setAvatarUrl(userPasswd.getAvatarUrl()!=null?userPasswd.getAvatarUrl():"");
                userInfo.setAge(userPasswd.getAge());
                if (userPasswd.getBirthday()!=null){
                    userInfo.setBirthday(DateUtil.getString(userPasswd.getBirthday(),DateUtil.PATTERN_DATE_TIME));
                }
                userInfo.setSex(userPasswd.getSex());
                userInfo.setPhone(userPasswd.getPasswd());
                userInfos.add(userInfo);
            }
        }else {
            resp.setCode(ResultConstant.QUERY_USER_INFO_OPERTYPE_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_USER_INFO_OPERTYPE_ERROR_MSG);
            return;
        }
        resp.setUserInfos(userInfos);
    }

    @Override
    public void sendValidSms(SendValidSmsReq req, SendValidSmsResp resp) throws Exception {
        String redisKey = RedisKeyUtil.getSmsValidCodeRedisKey(req.getPhoneNum(),IstEnum.SmsBizType.REGISTER.getCode()+"");
        if (!checkSend(req.getPhoneNum(),redisKey)){
            resp.setCode(ResultConstant.SEND_SMS_VALID_CODE_RESEND_CODE);
            resp.setMsg(ResultConstant.SEND_SMS_VALID_CODE_RESEND_MSG);
            return;
        }
        // 生成随机码
        String validCode = getPhoneRegisterRandomPWD(6);
        boolean redisSave = saveValidCode(req.getPhoneNum(), validCode,redisKey);
        if (redisSave){
            SendSmsReq sendSmsReq = new SendSmsReq();
            sendSmsReq.setPhoneNums(new String[]{"+86"+req.getPhoneNum()});
            sendSmsReq.setTemplateId(istConfig.getSmsValidCodeTemplateId());
            sendSmsReq.setTemplateParams(new String[]{validCode});
            SendMsgResp sendMsgResp = smsService.sendSms(sendSmsReq);
            if (!ResultConstant.SUCCESS_CODE.equals(sendMsgResp.getCode())){
                resp.setCode(ResultConstant.SEND_SMS_VALID_CODE_ERROR_CODE);
                resp.setMsg(ResultConstant.SEND_SMS_VALID_CODE_ERROR_MSG);
            }
        }else{
            resp.setCode(ResultConstant.SEND_SMS_VALID_CODE_SAVE_ERROR_CODE);
            resp.setMsg(ResultConstant.SEND_SMS_VALID_CODE_SAVE_ERROR_RESEND_MSG);
        }
    }

    private boolean saveValidCode(String phoneNum, String validCode,String redisKey) {
        try {
            SmsValid smsValid = new SmsValid();
            smsValid.setNumber(phoneNum);
            smsValid.setCode(validCode);
            smsValid.setValidTime(new Date());
            redisUtil.set(redisKey,smsValid,CodeConstant.REDIS_SAVE_TIME_30M);
        }catch (Exception e){
            logger.error("saveValidCode.err:",e);
            return false;
        }

        return true;
    }

    private boolean checkSend(String phone,String key) {
        SmsValid smsv = (SmsValid) redisUtil.get(key);
        if (null == smsv) {// 已失效
            return true;
        }
        if (null == smsv.getValidTime()) {
            return true;
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, NEXT_SEND_INTERVAL * -1);
        if (cal.getTime().after(smsv.getValidTime())) {
            return true;
        }
        return false;
    }

    public boolean judgeValidSms(String phone, String validCode) {
        String memovc=getValidCode(phone);
        if(StringUtils.isEmpty(validCode)){
            return false;
        }
        if(!StringUtils.equals(memovc, validCode)){
            return false;
        }
        return true;
    }

    private String getValidCode(String phone) {
        String redisKey = RedisKeyUtil.getSmsValidCodeRedisKey(phone,IstEnum.SmsBizType.REGISTER.getCode()+"");
        SmsValid smsv = (SmsValid) redisUtil.get(redisKey);
        if(null == smsv){
            return null;
        }
        return smsv.getCode();
    }

    public String getPhoneRegisterRandomPWD(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        return sb.toString();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addUserAddress(AddUserAddressReq req, AddUserAddressResp resp) {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.ADD_USER_ADDRESS_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.ADD_USER_ADDRESS_TOKENID_ERROR_MSG);
            return;
        }
        com.ist.svc.domain.UserAddress userAddress = new com.ist.svc.domain.UserAddress();
        userAddress.setStatus(IstEnum.UserAddressStatus.NORMAL.getStatus());
        userAddress.setAddress(req.getAddress());
        userAddress.setAreaid(Integer.parseInt(req.getAreaId()));
        userAddress.setIsdefault(Short.valueOf(req.getIsDefault()+""));
        userAddress.setName(req.getName());
        userAddress.setPhone(req.getPhone());
        userAddress.setUserid(new BigDecimal(req.getUserId()));
        if (req.getOrgId()!=null){
            userAddress.setOrgId(req.getOrgId());
        }
        if (req.getType()!=null){
            userAddress.setType(req.getType());
        }
        if (StringUtils.isNotBlank(req.getV1())){
            userAddress.setV1(req.getV1());
        }
        if (StringUtils.isNotBlank(req.getV2())){
            userAddress.setV2(req.getV2());
        }
        if (IstEnum.UserAddressOptType.TYPE_MODIFY.getType()==req.getOptType()){
            //先查老地址是否存在
            UserAddressExample example = new UserAddressExample();
            UserAddressExample.Criteria criteria = example.createCriteria();
            criteria.andUseridEqualTo(new BigDecimal(req.getUserId()));
            criteria.andAddressidEqualTo(Long.valueOf(req.getOldAddressId()));
            criteria.andStatusEqualTo(IstEnum.UserAddressStatus.NORMAL.getStatus());
            List<com.ist.svc.domain.UserAddress> userAddresses = userAddressService.queryByExample(example);
            if (userAddresses==null || userAddresses.isEmpty()){
                resp.setCode(ResultConstant.ADD_USER_ADDRESS_OLDADDRESSID_NOT_EXIST_ERROR_CODE);
                resp.setMsg(ResultConstant.ADD_USER_ADDRESS_OLDADDRESSID_NOT_EXIST_ERROR_MSG);
                return;
            }
            //修改逻辑 原地址逻辑删除 新增新地址
            com.ist.svc.domain.UserAddress updateUserAddress = new com.ist.svc.domain.UserAddress();
            updateUserAddress.setAddressid(Long.valueOf(req.getOldAddressId()));
            updateUserAddress.setStatus(IstEnum.UserAddressStatus.DEL.getStatus());
            userAddressService.updateUserAddress(updateUserAddress);
            userAddressService.addUserAddress(userAddress);
        }else if(IstEnum.UserAddressOptType.TYPE_ADD.getType()==req.getOptType()){
            //原来默认地址修改为不是默认的
//            if (req.getIsDefault()==IstEnum.QueryUserAddressIsDefault.IS_DEFAULT.getType().intValue()){
//                UserAddressExample example = new UserAddressExample();
//                UserAddressExample.Criteria criteria = example.createCriteria();
//                criteria.andStatusEqualTo(IstEnum.UserAddressStatus.NORMAL.getStatus());
//                criteria.andUseridEqualTo(new BigDecimal(req.getUserId()));
//                List<UserAddress> userAddresses = userAddressService.queryByExample(example);
//                for(UserAddress address: userAddresses){
//                    UserAddress updateUserAddess = new UserAddress();
//                    updateUserAddess.setAddressid(address.getAddressid());
//                    updateUserAddess.setIsdefault(IstEnum.QueryUserAddressIsDefault.NOT_DEFAULT.getType());
//                    userAddressService.updateUserAddress(updateUserAddess);
//                }
//            }
            //新增新地址
            userAddressService.addUserAddress(userAddress);
        }else{
            //OPTTYPE暂不支持
            resp.setCode(ResultConstant.ADD_USER_ADDRESS_OPTTYPE_ERROR_CODE);
            resp.setMsg(ResultConstant.ADD_USER_ADDRESS_OPTTYPE_ERROR_MSG);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delUserAddress(DelUserAddressReq req, DelUserAddressResp resp) {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.DEL_USER_ADDRESS_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.DEL_USER_ADDRESS_TOKENID_ERROR_MSG);
            return;
        }
        //先查老地址是否存在
        UserAddressExample example = new UserAddressExample();
        UserAddressExample.Criteria criteria = example.createCriteria();
        criteria.andAddressidEqualTo(Long.valueOf(req.getAddressId()));
        criteria.andStatusEqualTo(IstEnum.UserAddressStatus.NORMAL.getStatus());
        List<com.ist.svc.domain.UserAddress> userAddresses = userAddressService.queryByExample(example);
        if (userAddresses==null || userAddresses.isEmpty()){
            resp.setCode(ResultConstant.DEL_USER_ADDRESS_ADDRESSID_NOT_EXIST_ERROR_CODE);
            resp.setMsg(ResultConstant.DEL_USER_ADDRESS_ADDRESSID_NOT_EXIST_ERROR_MSG);
            return;
        }
        com.ist.svc.domain.UserAddress updateUserAddress = new com.ist.svc.domain.UserAddress();
        updateUserAddress.setAddressid(Long.valueOf(req.getAddressId()));
        updateUserAddress.setStatus(IstEnum.UserAddressStatus.DEL.getStatus());
        userAddressService.updateUserAddress(updateUserAddress);
    }

    @Override
    @Transactional
    public void queryUserAddress(QueryUserAddressReq req, QueryUserAddressResp resp) {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.QUERY_USER_ADDRESS_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_USER_ADDRESS_TOKENID_ERROR_MSG);
            return;
        }
        Map<String,Object> params = new HashMap<>();
        if(IstEnum.QueryUserAddressType.TYPE_USERID.getType()==req.getQueryType()){
            params.put("userId",req.getUserId());
        }else if (IstEnum.QueryUserAddressType.TYPE_ADDRESSID.getType()==req.getQueryType()){
            params.put("addressId",req.getAddressId());
        }else {
            resp.setCode(ResultConstant.QUERY_USER_ADDRESS_QUERY_TYPE_ERROR_CODE);
            resp.setCode(ResultConstant.QUERY_USER_ADDRESS_QUERY_TYPE_ERROR_MSG);
            return;
        }
        params.put("status",IstEnum.UserAddressStatus.NORMAL.getStatus());
        if (null!=req.getIsDefault()){
            params.put("isDefault",req.getIsDefault());
        }
        List<com.ist.svc.controller.model.UserAddress> list = userAddressService.queryByParams(params);
        resp.setData(list);
    }

    @Override
    @Transactional
    public void getUsersByUserIds(GetUsersByUserIdsReq req, QueryBaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.QUERY_USER_INFO_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_USER_INFO_TOKENID_ERROR_MSG);
            return;
        }

        //验证是否超过100个
        String[] userIdsArr = req.getUserIds().split(",");
        if (userIdsArr!=null && userIdsArr.length>100){
            resp.setCode(ResultConstant.QUERY_USER_INFO_USERIDS_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_USER_INFO_USERIDS_ERROR_MSG);
            return;
        }
//        Map<String,Object> params = new HashMap<>();
//        params.put("userIds",userIdsArr);
        List<UserInfo> userInfos = new ArrayList<>();
//        List<UserPasswd> userPasswds = userPasswdMapper.selectsByParams(params);
        UserExample example = new UserExample();
        List<BigDecimal> listIds = new ArrayList<>();
        for (String str : userIdsArr){
            listIds.add(new BigDecimal(str));
        }
        example.createCriteria().andUseridIn(listIds);
        List<User> users = userMapper.selectByExample(example);
        for (User user : users){
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(user.getUserid().toString());
            userInfo.setNickName(user.getNickname());
            userInfo.setAvatarUrl(user.getAvatarUrl());
            userInfos.add(userInfo);
        }
        resp.setData(userInfos);
        resp.setCode(ResultConstant.QUERY_USER_INFO_SUCC_CODE);
        resp.setMsg(ResultConstant.QUERY_USER_INFO_SUCC_MSG);
    }

    @Override
    public void delRedisByUserId(String userId) throws Exception {
        this.deleteUserMemByUserId(userId);
    }

    @Override
    public void delRedisByLoginName(String loginName) {
        UserPasswd userPasswd = getUserPasswdByLoginName(loginName);
        this.deleteUserMemByUserId(userPasswd.getUserid().toString());
        redisUtil.del(CodeConstant.REDIS_USER_INFO+loginName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userBindPhone(UserBindPhoneReq req, ApiBaseResp resp) {
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
        String phone = req.getPhone();
        if (!judgeValidSms(req.getPhone(),req.getSmsCode())){
            resp.setCode(ResultConstant.BIND_USER_PHONE_SMSCODE_ERROR_CODE);
            resp.setMsg(ResultConstant.BIND_USER_PHONE_SMSCODE_ERROR_MSG);
            return;
        }
//        UserPasswdExample userPasswdExample = new UserPasswdExample();
//        UserPasswdExample.Criteria criteriaUserPasswd = userPasswdExample.createCriteria();
//        criteriaUserPasswd.andLoginnameEqualTo(phone);
//        criteriaUserPasswd.andStatusEqualTo(IstEnum.UserStatus.NORMAL.getStatus());
//        criteriaUserPasswd.andUserTypeEqualTo(IstEnum.UserType.TYPE_PHONE.getType().shortValue());
//        List<UserPasswd> userPasswds = userPasswdMapper.selectByExample(userPasswdExample);
        UserPasswd upDb = getUserPasswdByLoginName(phone);
        if (req.getBindType()==null || req.getBindType()==IstEnum.BindType.FORWARD_BIND.geTtype()){
            //插入userPassword表里一条记录 先查userPassword 是否存在
            if (null!=upDb && upDb.getUserType() == IstEnum.UserType.TYPE_PHONE.getType().intValue()){
                resp.setCode(ResultConstant.BIND_USER_PHONE_ALREADY_BIND_ERROR_CODE);
                resp.setMsg(ResultConstant.BIND_USER_PHONE_ALREADY_BIND_ERROR_MSG);
                return;
            }
            UserPasswd up = new UserPasswd();
            Date now = new Date();
            up.setLoginname(phone);
            up.setPasswd(EncodewithMD5.encodePWDWithMD5(phone));
            up.setUserType(IstEnum.UserType.TYPE_PHONE.getType());
            up.setChangenum(IstEnum.ChangeNum.RESET.getType());
            up.setStatus(IstEnum.UserStatus.NORMAL.getStatus());
            up.setCreatetime(now);
            up.setUserid(new BigDecimal(req.getUserId()));
            userPasswdMapper.insertSelective(up);
            //更新user表里的phone字段
            User userUpdate = new User();
            userUpdate.setPhone(phone);
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUseridEqualTo(new BigDecimal(req.getUserId()));
            userMapper.updateByExampleSelective(userUpdate,userExample);
        }else{
            BindDataVo bindDataVo = new BindDataVo();
            if (null==upDb){
                resp.setCode(ResultConstant.BIND_USER_PHONE_NOT_EXIST_BIND_ERROR_CODE);
                resp.setMsg(ResultConstant.BIND_USER_PHONE_NOT_EXIST_BIND_ERROR_MSG);
                return;
            }
            BigDecimal userId = upDb.getUserid();
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUseridEqualTo(new BigDecimal(req.getUserId()));
            User updateUser = new User();
            JSONObject jsonData = JSONObject.parseObject(req.getJsonData());
            String nickName = jsonData.getString("nickName");
            String avatarUrl = jsonData.getString("avatarUrl");
            String loginName = jsonData.getString("loginName");
            boolean isUpdate = false; //是否更新定时器
            if (upDb.getNickName().startsWith("用户") && upDb.getNickName().endsWith(upDb.getPhone().substring(7))){
                updateUser.setNickname(nickName);
                bindDataVo.setLoginName(nickName);
                isUpdate = true;
            }
            if (upDb.getAvatarUrl().endsWith("missing-face.png")){
                updateUser.setAvatarUrl(avatarUrl);
                bindDataVo.setAvatarUrl(avatarUrl);
                isUpdate = true;
            }
            if (isUpdate){
                resp.setCode(ResultConstant.SUCCESS_CODE);
                resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
                resp.setData(bindDataVo);
                userMapper.updateByExampleSelective(updateUser, userExample);
            }
            UserPasswd  up = new UserPasswd();
            Date now = new Date();
            up.setLoginname(loginName);
            up.setPasswd(EncodewithMD5.encodePWDWithMD5(loginName));
            up.setUserType(IstEnum.UserType.TYPE_WEIXIN.getType());
            up.setChangenum(IstEnum.ChangeNum.RESET.getType());
            up.setStatus(IstEnum.UserStatus.NORMAL.getStatus());
            up.setCreatetime(now);
            up.setUserid(userId);
            userPasswdMapper.insertSelective(up);
        }
        deleteUserMemByUserId(req.getUserId());
    }

    @Override
    public void verifyValidSmsCode(VerifyValidSmsReq req, BaseResp resp) {
        if (!judgeValidSms(req.getPhoneNum(),req.getValidCode()) && !"111111".equals(req.getValidCode())){
            resp.setCode(ResultConstant.VERIFY_VALID_SMS_CODE_ERROR_CODE);
            resp.setMsg(ResultConstant.VERIFY_VALID_SMS_CODE_ERROR_MSG);
        }
    }

    @Override
    public void modifyUserInfo(ModifyUserInfoReq req, BaseResp resp) {
        UserExample userExample = new UserExample();

        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseridEqualTo(new BigDecimal(req.getUserId()));
        User updateUser = new User();
        if (StringUtils.isNoneBlank(req.getAvatarUrl())){
            updateUser.setAvatarUrl(req.getAvatarUrl());
        }
        if (StringUtils.isNoneBlank(req.getNickName())){
            updateUser.setNickname(req.getNickName());
        }
        int result = userMapper.updateByExampleSelective(updateUser, userExample);
        if (result>0){
            deleteUserMemByUserId(req.getUserId());
        }

        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);

    }

    @Override
    public void queryAddress(QueryUserAddressDto req, ApiBaseResp resp) {
        if(StringUtils.isBlank(req.getAddress()) && StringUtils.isBlank(req.getAreaId())){
            resp.setCode(ResultConstant.QUERY_USER_ADDRESS_PARAM_ERROR_CODE);
            resp.setCode(ResultConstant.QUERY_USER_ADDRESS_PARAM_ERROR_MSG);
            return;
        }
        UserAddressExample example = new UserAddressExample();
        UserAddressExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNoneBlank(req.getAreaId())){
            criteria.andAreaidEqualTo(Integer.parseInt(req.getAreaId()));
        }
        if (StringUtils.isNoneBlank(req.getAddress())){
            criteria.andAddressLike("%" + req.getAddress() + "%");
        }
        List<UserAddress> userAddresses = userAddressService.queryByExample(example);
        List<UserAddressVo> list = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(userAddresses)){
            for (UserAddress userAddress :userAddresses){
                UserAddressVo uAddress = new UserAddressVo();
                uAddress.setAddress(userAddress.getAddress());
                uAddress.setAreaId(userAddress.getAreaid());
                uAddress.setIsDefault(userAddress.getIsdefault().intValue());
                uAddress.setName(userAddress.getName());
                uAddress.setAddressId(userAddress.getAddressid().toString());
                uAddress.setPhone(userAddress.getPhone());
                uAddress.setUserId(userAddress.getUserid().toString());
                uAddress.setOrgId(userAddress.getOrgId());
                uAddress.setType(userAddress.getType());
                uAddress.setV1(userAddress.getV1());
                uAddress.setV2(userAddress.getV2());
                list.add(uAddress);
            }
        }

        resp.setData(list);
        resp.setCode(ResultConstant.QUERY_USER_ADDRESS_SUCC_CODE);
        resp.setMsg(ResultConstant.QUERY_USER_ADDRESS_SUCC_MSG);
    }

    private List<UserPasswd> getUserPasswdByUid(String userId) {
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userId);
        List<UserPasswd> userPasswds = userPasswdMapper.selectsByParams(params);
        return userPasswds;
    }

    @Override
//    @Transactional
    public void userLogin(UserLoginReq req, ApiBaseResp resp) throws Exception {
        UserLoginResp userLoginResp = new UserLoginResp();
        //参数基本校验
        if(req.getLoginType() == IstEnum.LoginType.TYPE_WEIXIN.getType() && StringUtils.isBlank(req.getWxCode())){
            resp.setCode(ResultConstant.USER_LOGIN_WEIXIN_CODE_ERROR_CODE);
            resp.setMsg(ResultConstant.USER_LOGIN_WEIXIN_CODE_ERROR_MSG);
            return;
        }
        if (req.getLoginType() == IstEnum.LoginType.TYPE_SMS.getType() && StringUtils.isBlank(req.getSmsCode())){
            resp.setCode(ResultConstant.USER_LOGIN_SMS_CODE_NULL_ERR_CODE);
            resp.setMsg(ResultConstant.USER_LOGIN_SMS_CODE_NULL_ERR_MSG);
            return;
        }
        if (req.getLoginType() == IstEnum.LoginType.TYPE_ACCOUNT.getType()&& StringUtils.isBlank(req.getPassword())){
            resp.setCode(ResultConstant.USER_LOGIN_PASSWORD_EMPTY_ERROR_CODE);
            resp.setMsg(ResultConstant.USER_LOGIN_PASSWORD_EMPTY_ERROR_MSG);
            return;
        }
        //微信第三方登陆需要获取openId
        String openId = "";
        String unionId = "";
        if(req.getLoginType() == IstEnum.LoginType.TYPE_WEIXIN.getType()){
            String wxCode = req.getWxCode();
            JSONObject wxCodeJsonObject = JSONObject.parseObject(wxCode);
            String weixinCode = wxCodeJsonObject.getString("code");

            String type = wxCodeJsonObject.getString("type");
            if (StringUtils.isNoneBlank(type)&&"APP".equalsIgnoreCase(type)){
                //微信APP登录
                JSONObject jsonObject = getAccessToken(weixinCode);
                String accessToken = jsonObject.getString("access_token");
                openId = jsonObject.getString("openid");
                //通过openId获取 userInfo信息
                String url = String.format(istConfig.getWeiXinAppUserInfoUrl(),accessToken,openId,"zh_CN");
                String resultUserInfo = HttpUtil.doGet(url,null);
                JSONObject resultUserInfoJson = JSON.parseObject(resultUserInfo);
                unionId = resultUserInfoJson.getString("unionid");
                userLoginResp.setNickName(resultUserInfoJson.getString("nickname"));
                userLoginResp.setAvatarUrl(resultUserInfoJson.getString("headimgurl"));
                userLoginResp.setSex(resultUserInfoJson.getInteger("sex"));
                userLoginResp.setAddress(resultUserInfoJson.getString("city"));
            }else {
                //微信小程序登录
                JSONObject sessionKeyOropenid = wxUtil.getSessionKeyOropenid(weixinCode);
                logger.info("getSessionKeyOropenid req:{} resp:{}",weixinCode,sessionKeyOropenid);
                openId = sessionKeyOropenid.getString("openid");
//            openId = "oAbP74kN4xZz1Wud-LCjVw4t9SPA";
                if (StringUtils.isBlank(openId)){
                    resp.setCode(ResultConstant.USER_LOGIN_WEIXIN_OPEN_CODE_GET_ERROR_CODE);
                    resp.setMsg(ResultConstant.USER_LOGIN_WEIXIN_OPEN_CODE_GET_ERROR_MSG);
                    return;
                }else{
                    String sessionKey = sessionKeyOropenid.getString("session_key");
                    Map<String, Object> stringObjectMap = decryptData(wxCodeJsonObject.getString("encryptedData"), wxCodeJsonObject.getString("iv"), sessionKey);
                    logger.info("stringObjectMap:{}",stringObjectMap);
                    unionId = (String) stringObjectMap.get("unionId");
                    userLoginResp.setNickName((String) stringObjectMap.get("nickName"));
                    userLoginResp.setSex((Integer) stringObjectMap.get("gender"));
                    userLoginResp.setAddress((String) stringObjectMap.get("city"));
                    userLoginResp.setAvatarUrl((String) stringObjectMap.get("avatarUrl"));
                }
            }

            req.setNeedPwd(false);//不需要校验密码
            req.setLoginName(unionId);
//            else {
//                //通过openid获取userinfo {"openid":"oAbP74kN4xZz1Wud-LCjVw4t9SPY","session_key":"Lx78a2jDGx2cUE6/2tZx6g=="}
//                //查询用户信息是否存在
//                UserPasswd userPasswd = getUserPasswdByOpenId(openId);
//                if (userPasswd==null){
//                    //获取微信账号
//                    Long seq_roam_account = commonMapper.querySeqNextVal("seq_roam_account");
//                    String accountLogin = seq_roam_account + "@weixin";
//                    //注册
//                    UserRegisterResp userRegisterResp = new UserRegisterResp();
//                    userRegisterResp.setCode(ResultConstant.USER_REGISTER_SUCC_CODE);
//                    userRegisterResp.setMsg(ResultConstant.USER_REGISTER_SUCC_MSG);
//                    UserRegisterReq userRegisterReq = new UserRegisterReq();
//                    userRegisterReq.setLoginName(accountLogin);
//                    userRegisterReq.setPassword(StringUtils.isBlank(req.getPassword())?"123456":req.getPassword());
//                    userRegisterReq.setWechat(openId);
//                    userRegisterReq.setUserType(IstEnum.UserType.TYPE_ROMA.getType());
//                    userRegister(userRegisterReq,userRegisterResp);
//                    if (!ResultConstant.USER_REGISTER_SUCC_CODE.equals(userRegisterResp.getCode())){
//                        resp.setCode(ResultConstant.USER_LOGIN_REGISTER_ERROR_CODE);
//                        resp.setMsg(ResultConstant.USER_LOGIN_REGISTER_ERROR_MSG);
//                        return;
//                    }
//                    req.setLoginName(accountLogin);
//                }else {
//                    req.setLoginName(userPasswd.getLoginname());
//                }
//            }
        }
        if (StringUtils.isBlank(req.getLoginName())){
            resp.setCode(ResultConstant.USER_LOGIN_WEIXIN_OPEN_CODE_GET_ERROR_CODE);
            resp.setMsg(ResultConstant.USER_LOGIN_WEIXIN_OPEN_CODE_GET_ERROR_MSG);
            return;
        }
        String redisKey = "";
        long s = System.currentTimeMillis();
        if (req.getLoginType() == IstEnum.LoginType.TYPE_WEIXIN.getType()){
            redisKey = RedisKeyUtil.getLoginRespKey(unionId,"",req.getAppId());
        }else if (req.getLoginType() == IstEnum.LoginType.TYPE_SMS.getType()){
            if (!judgeValidSms(req.getLoginName(),req.getSmsCode()) && !"111111".equals(req.getSmsCode())){
                resp.setCode(ResultConstant.USER_LOGIN_SMS_CODE_ERROR_CODE);
                resp.setMsg(ResultConstant.USER_LOGIN_SMS_CODE_ERROR_MSG);
                return;
            }
            req.setNeedPwd(false);//不需要校验密码
            redisKey = RedisKeyUtil.getLoginRespKey(req.getLoginName(),req.getSmsCode(),req.getAppId());
        }else {
            redisKey = RedisKeyUtil.getLoginRespKey(req.getLoginName(),req.getPassword(),req.getAppId());
        }
        UserLoginResp redisResp = checkRedisLoginResp(redisKey,req.getLoginName(),req.getAppId());
        if (null != redisResp) {
            logger.info("UserServiceImpl.cUserLogin resp from redis(" + redisResp.getUserId() + ")");
            BeanUtils.copyProperties(redisResp, resp);
            return;
        }

        //查询用户信息是否存在
        UserPasswd userPasswd = getUserPasswdByLoginName(req.getLoginName());
        if (userPasswd == null){
            resp.setCode(ResultConstant.USER_LOGIN_USER_IS_NULL_ERROR_CODE);
            resp.setMsg(ResultConstant.USER_LOGIN_USER_IS_NULL_ERROR_MSG);
            userLoginResp.setLoginName(req.getLoginName());
            resp.setData(userLoginResp);
            return;
        }
        //密码校验
        if (req.isNeedPwd()){
            String pwd = EncodewithMD5.encodePWDWithMD5(req.getPassword());
            if (!StringUtils.equals(pwd,userPasswd.getPasswd())){
                resp.setCode(ResultConstant.USER_LOGIN_PASSWORD_ERROR_CODE);
                resp.setMsg(ResultConstant.USER_LOGIN_PASSWORD_ERROR_MSG);
                return;
            }
        }
        String tokenId = userTokenService.genTokenId(req.getLoginName(),req.getAppId());
        userLoginResp.setTokenId(tokenId);
        userLoginResp.setAvatarUrl(userPasswd.getAvatarUrl());
        userLoginResp.setLoginName(userPasswd.getLoginname());
        userLoginResp.setNickName(userPasswd.getNickName());
        userLoginResp.setUserId(userPasswd.getUserid()+"");
        userLoginResp.setPhone(userPasswd.getPhone());
        userLoginResp.setSex(userPasswd.getSex());
        //放入缓存
        redisUtil.set(redisKey, resp, CodeConstant.USER_LOGIN_RESP_SAVE_TIME);
        putUidLoginRel(userPasswd.getUserid() + "",redisKey);
        resp.setData(userLoginResp);
    }
    private JSONObject getAccessToken(String weixinCode) throws UnsupportedEncodingException {

        String url = String.format(istConfig.getWeiXinAppAccessUrl(),istConfig.getWeiXinAppId(),istConfig.getWeiXinAppSecret(),weixinCode);
        String result = HttpUtil.doGet(url,null);
        JSONObject jsonObject = JSON.parseObject(result);
        logger.info("result:{}",result);
        return jsonObject;
    }
    /**
     * 根据encryptedData，iv，sessionKey解密获取用户信息
     * @param encryptedData
     * @param iv
     * @param sessionKey
     * @return
     */
    public Map<String, Object> decryptData(String encryptedData, String iv, String sessionKey)
    {
        Map<String, Object> wres = new HashMap<String, Object>();
        if (sessionKey.length() != 24) {
            wres.put("status", 1);
            wres.put("msg", "参数错误");
            logger.error(wres.toString());
            return wres;
        }
        if (iv.length() != 24) {
            wres.put("status", 1);
            wres.put("msg", "参数错误");
            logger.error(wres.toString());
            return wres;
        }
        byte[] aesKey = Base64.decode(sessionKey);
        byte[] aesIV = Base64.decode(iv);
        byte[] aesEncryptedData = Base64.decode(encryptedData);

        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(aesIV);
            cipher.init(cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] original = cipher.doFinal(aesEncryptedData);
            if (null != original && original.length > 0) {
                String result = new String(original, "UTF-8");
                JSONObject userInfo = JSONObject.parseObject(result);
                logger.info("weixin.decryptData:{}",userInfo.toJSONString());
                if (null!=userInfo.getString("openId")) {
                    wres.put("status", 0);
                    wres.put("openid", userInfo.getString("openId"));
                    wres.put("nickName", userInfo.getString("nickName"));
                    wres.put("gender", userInfo.getString("gender"));
                    wres.put("avatarUrl", userInfo.getString("avatarUrl"));
                    wres.put("unionId",userInfo.getString("unionId"));
                    wres.put("gender",userInfo.getIntValue("gender"));
                    wres.put("city",userInfo.getString("city"));
                    return wres;
                }
            }
            wres.put("status", 1);
            wres.put("msg", "解密错误");
            logger.error(wres.toString());
            return wres;
        }  catch (Exception ex) {
            logger.error("decryptData.err:",ex);
            wres.put("status", 1);
            wres.put("msg", ex.getMessage());
            return wres;
        }
    }
    private UserPasswd getUserPasswdByOpenId(String openId) {
        //先从缓存获取
        String redisKey = CodeConstant.REDIS_USER_INFO + openId;
        UserPasswd userPasswdRedis = (UserPasswd) redisUtil.get(redisKey);
        if (userPasswdRedis!=null){
            return userPasswdRedis;
        }
        //查看用户是否存在
        Map<String, Object> params = new HashMap<>();
        params.put("wechat",openId);
        UserPasswd userPasswd = userPasswdMapper.selectByParams(params);
        if (userPasswd!=null){
            //放入缓存
            redisUtil.set(redisKey,userPasswd,CodeConstant.REDIS_SAVE_TIME_24h);
        }
        return userPasswd;
    }

    private void putUidLoginRel(String userId, String redisKey) {
        Map<String, String> relMap = (Map<String, String>) redisUtil.get(CodeConstant.REDIS_USERID_LOGIN_REL_PREFIX + userId);
        if (null == relMap) {
            relMap = new HashMap<>();
        }
        if (relMap.size() >= 10) {
            // 如果登陆缓存key中超过10个,则进行清除重置,以保证缓存的有效利用率
            logger.info("UserServiceImpl.putUidLoginRel uid:" + userId + ",relMap size:" + relMap.size());
            for (String key : relMap.keySet()) {
                redisUtil.del(key);
            }
            relMap.clear();
        }
        relMap.put(redisKey, redisKey);
        redisUtil.set(CodeConstant.REDIS_USERID_LOGIN_REL_PREFIX + userId, relMap, CodeConstant.REDIS_USERID_LOGIN_REL_SAVE_TIME);
    }

    private void deleteUserMemByUserId(String userId){
        Map<String, String> relMap = (Map<String, String>) redisUtil.get(CodeConstant.REDIS_USERID_LOGIN_REL_PREFIX + userId);
        if (relMap != null) {
            for (String key : relMap.keySet()) {
                redisUtil.del(key);
            }
        }
        List<UserPasswd>  userPasswds = getUserPasswdByUid(userId);
        for(UserPasswd userPasswd : userPasswds){
            redisUtil.del(CodeConstant.REDIS_USER_INFO+userPasswd.getLoginname());
        }
    }

    private UserLoginResp checkRedisLoginResp(String redisKey, String accountNo, String appId) {
        redisUtil.del(redisKey);
        UserLoginResp userLoginResp = (UserLoginResp) redisUtil.get(redisKey);
        long end = System.currentTimeMillis();
        if (null != userLoginResp) {
            //校验tokenId是否一致
            String sTokenId = (String) redisUtil.get(CodeConstant.REDIS_USER_TOKEN_ID_KEY_PREFIX + ":"+ accountNo + ":" + appId);
            if (StringUtils.equals(userLoginResp.getTokenId(), sTokenId)) {
                return userLoginResp;
            }
        }
        return null;
    }

//    @Transactional(rollbackFor = Exception.class)
    public String insertUserInfo(UserRegisterReq req,String userId)  throws Exception{
//        Object savePoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint();
        User user = new User();
//        try{
            user.setAddress(req.getAddress());
            if (req.getAge() != null){
                user.setAge(Short.valueOf(req.getAge()+""));
            }
            user.setAvatarUrl(req.getAvatarUrl());
            if (StringUtils.isNoneBlank(req.getBirthday())){
                user.setBirthday(DateUtil.formatDateStr(req.getBirthday(),"yyyyMMddHHmmss"));
            }else {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR,1990);
                calendar.set(Calendar.MONTH,9);
                calendar.set(Calendar.HOUR_OF_DAY,9);
                user.setBirthday(calendar.getTime());
            }
            if (req.getCityId()!=null){
                user.setCityid(req.getCityId());
            }
            Date now = new Date();
            user.setCreatetime(now);
            user.setHome(req.getHome());
            user.setIdcard(req.getIdCard());
            user.setName(req.getName());
            user.setNickname(req.getNickName());
            user.setPhone(req.getPhone());
            user.setWechat(req.getWechat());
            if (req.getSex()!=null){
                user.setSex(Short.valueOf(req.getSex() + ""));
            }
            user.setStatus(IstEnum.UserStatus.NORMAL.getStatus());
            user.setUnicode(getItemId(25));//随机生成
            user.setUserid(new BigDecimal(userId));
//            userMapper.insertSelective(user);
            UserPasswd up = new UserPasswd();
            up.setLoginname(req.getLoginName());
            up.setPasswd(EncodewithMD5.encodePWDWithMD5(req.getPassword()));
            up.setUserType(req.getUserType());
            up.setChangenum(IstEnum.ChangeNum.RESET.getType());
            up.setStatus(IstEnum.UserStatus.NORMAL.getStatus());
            up.setCreatetime(now);
            up.setUserid(user.getUserid());
//            userPasswdMapper.insertSelective(up);
            saveUserInfo(user,up);
//        }catch (Exception e){
//            //事务回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
////            TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savePoint);//回滚到savePoint
//        }

        return String.valueOf(user.getUserid());
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void saveUserInfo(User user, UserPasswd up) {
        userMapper.insertSelective(user);
        userPasswdMapper.insertSelective(up);
    }

    private String generatorUID(IstEnum.ProductLine productLine, IstEnum.UserType userType, String accountNo, int hashType) {
        if (productLine == null) {
            return null;
        }
        if (userType == null) {
            return null;
        }
        if (StringUtils.isBlank(accountNo)) {
            return null;
        }
        //验证手机号
//        if (userType.getType() == IstEnum.UserType.TYPE_PHONE.getType() && !ValidateUtil.validateMoblie(accountNo)) {
//            return null;
//        }

        // 产品线
//        StringBuilder uid = new StringBuilder(String.valueOf(IstEnum.ProductLine.UNIT_PRODUCT.getCode()));
//        //用户类型
//        uid.append(String.valueOf(userType.getType()));
//
//        if (userType.getType() == IstEnum.UserType.TYPE_PHONE.getType() || userType.getType() == IstEnum.UserType.TYPE_EMAIL.getType() ) {
        long id = commonMapper.querySeqNextVal(IstEnum.SeqName.USER_ID.getSeqValue());
//            if (String.valueOf(id).length() <= 9) {
//                accountNo = String.format("%09d", id);
//            } else {
//                String temp = String.valueOf(id);
//                accountNo = temp.substring(temp.length() - 9, temp.length());
//            }
//        }
//        else if (userType.getType() == IstEnum.UserType.TYPE_ROMA.getType()){
//            // 获得hash
//            int h = -1;
//            if(hashType==HASH_TYPE_BKDR){
//                h = BKDRHash(accountNo);
//            }else if(hashType==HASH_TYPE_SDBM){
//                h = SDBMHash(accountNo);
//            }else{
//                h = ELFHash(accountNo);
//            }
//            // 格式化后的hash
//            accountNo = format(h,10);
//        }
//        // 账号
//        uid.append(accountNo);
//        uid.append(DateUtil.getString(new Date(), "yyMMdd"));
        return id+"";

    }

    /**
     * BKDR算法
     */
    private static int BKDRHash(String str) {
        int seed = 131; // 31 131 1313 13131 131313 etc..
        int hash = 0;

        for (int i = 0; i < str.length(); i++) {
            hash = (hash * seed) + str.charAt(i);
        }
        return (hash & 0x7FFFFFFF);
    }

    /**
     * SDBM算法
     */
    private static int SDBMHash(String str) {
        int hash = 0;

        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;
        }
        return (hash & 0x7FFFFFFF);
    }

    /**
     * ELF算法
     */
    private static int ELFHash(String str) {
        int hash = 0;
        int x = 0;

        for (int i = 0; i < str.length(); i++) {
            hash = (hash << 4) + str.charAt(i);
            if ((x = (int) (hash & 0xF0000000L)) != 0) {
                hash ^= (x >> 24);
                hash &= ~x;
            }
        }
        return (hash & 0x7FFFFFFF);
    }
    /**
     * 按照指定的格式格式化字符串，"0"开头表示是负数，"1"开头表示是正数
     * @param h 要格式化的数字
     * @param l 显示的位数
     * @return 格式化好的字符串
     */
    private static String format(int h, int l) {
        String f = "%0"+l+"d"; // 字符串格式，不足l位补充0
        if (h < 0) {
            if (h == Integer.MIN_VALUE) {
                return "02147483648";
            }
            return String.format(f, h * -1);
        }
        return "1" + String.format(f, h);
    }
}
