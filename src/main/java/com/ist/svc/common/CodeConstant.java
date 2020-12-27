package com.ist.svc.common;

import java.io.File;

/**
 * 常量定义
 */
public class CodeConstant {
    public static final int DISPLACEMENT_NUMBER = 2;

    public static final String REDIS_USER_LOGIN_RESP_PREFIX = "IST:USERLOGIN:RESP";
    public static final String REDIS_USER_TOKEN_ID_KEY_PREFIX = "IST:USER:TOKENID";
    public static final String REDIS_USER_INFO = "IST:USERINFO:PREFIX:";
    public static final String REDIS_USERID_LOGIN_REL_PREFIX = "IST:USERID:LOGIN:REL:";
    public static final String REDIS_APP_KEY_PREFIX = "IST:APP:SECRET:";
    public static final String REDIS_BAG_DRAW_AMOUNT_PREFIX = "IST:BAG:DRAW:AMOUNT:";
    public static final String REIDS_BAG_DRAW_CONCURRENT_UID_BAGNO="IST:BAG:DRAW:CONCURRENT:UID:BAGNO:";
    public static final String REIDS_BAG_DRAW_CONCURRENT_BAGNO="IST:BAG:DRAW:CONCURRENT:BAGNO:";
    public static final String REDIS_SMS_VALID_CODE="IST:SMS:VALID:CODE:";
    public static final String REIDS_BAG_BALANCE_MONEY_BAGNO="IST:BAG:BALANCE:MONEY:BAGNO:";
    public static final String REIDS_BAG_BAGNO="IST:BAG:BAGNO:2020122310384550000000001520001229788021079543";
    public static final String REDIS_BAG_DRAW_RECORD_USERID_BAGNO="IST:BAG:DRAW:RECORD:USERID:BAGNO";
    public static final String REIDS_BAG_SECTION_MIN_MAX_BAGNO="IST:BAG:MIN:MAX:BAGNO:";
    public static final String REIDS_BAG_EFFECT_DRAW_BAGNO="IST:BAG:EFFECT:DRAW:BAGNO:";
    public static final String REDIS_BAG_DRAW_RECORDS_PREFIX = "IST:BAG:DRAW:RECORDS:";

    public static final long REDIS_SAVE_TIME_24h = 24*60*60;
    public static final long USER_TOKEN_ID_SAVE_TIME = 365*24*60*60;
    public static final long USER_LOGIN_RESP_SAVE_TIME = 3*24*60*60;
    public static final long REDIS_USERID_LOGIN_REL_SAVE_TIME = 3*24*60*60;
    public static final long REDIS_SAVE_TIME_5S = 5;
    public static final long REDIS_SAVE_TIME_5M = 5*60;

    public static final String ENVIRONMENT_NO="3";

    public interface Path{
        public static final String IST_IMAGE = File.separator+"ist";
    }
}
