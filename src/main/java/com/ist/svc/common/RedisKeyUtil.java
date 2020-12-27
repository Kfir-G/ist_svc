package com.ist.svc.common;

import com.ist.svc.common.util.EncodewithMD5;

import java.math.BigDecimal;

/**
 * @Author: sunhaitao
 */
public class RedisKeyUtil {
    public static String getLoginRespKey(String loginName,String password,String appId){
        String redisKey = CodeConstant.REDIS_USER_LOGIN_RESP_PREFIX + EncodewithMD5.encodeWithMD5(loginName + ":" + password + ":" + appId);
        return redisKey;
    }

    public static String getBagDrawAmountFromRedis(String bagNo){
        String redisKey = CodeConstant.REDIS_BAG_DRAW_AMOUNT_PREFIX + bagNo;
        return redisKey;
    }

    public static String getBagDrawConcurrentUiBagNo(String userId,String bagNo){
        return CodeConstant.REIDS_BAG_DRAW_CONCURRENT_UID_BAGNO + userId + ":" + bagNo;
    }

    public static String getBagDrawConcurrentBagNo(String bagNo){
        return CodeConstant.REIDS_BAG_DRAW_CONCURRENT_BAGNO  + bagNo;
    }

    public static String getSmsValidCodeRedisKey(String phone,String smsBizType) {
        return CodeConstant.REDIS_SMS_VALID_CODE + phone + ":" + smsBizType;
    }

    public static String getBagBalanceMoneyKey(String bagNo){
        return CodeConstant.REIDS_BAG_BALANCE_MONEY_BAGNO  + bagNo;
    }

    public static String getBagRedisKey(String bagNo) {
        return CodeConstant.REIDS_BAG_BAGNO + bagNo;
    }

    public static String getBagDrawRecordKey(BigDecimal bagNo, String userId) {
        return CodeConstant.REDIS_BAG_DRAW_RECORD_USERID_BAGNO + bagNo+":" + userId;
    }

    public static String getBagSectionMinMaxBagNo(String bagNo){
        return CodeConstant.REIDS_BAG_SECTION_MIN_MAX_BAGNO  + bagNo;
    }
    public static String getBagEffectDrawByBagNo(String bagNo){
        return CodeConstant.REIDS_BAG_EFFECT_DRAW_BAGNO  + bagNo;
    }
    public static String getBagDrawRecordsFromRedis(String bagNo){
        String redisKey = CodeConstant.REDIS_BAG_DRAW_RECORDS_PREFIX + bagNo;
        return redisKey;
    }
}
