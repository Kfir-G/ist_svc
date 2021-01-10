package com.ist.svc.common;

/**
 * 响应状态码及描述信息
 * @Author: sunhaitao
 */
public class ResultConstant {
    public static String SUCCESS_CODE = "0";
    public static String SUCCESS_CODE_MSG = "success";

    public static String PARAM_ERROR_CODE = "901";
    public static String PARAM_ERROR_MSG = "参数缺失";
    public static String SIGN_ERROR_CODE = "903";
    public static String SIGN_ERROR_MSG = "签名校验失败";
    public static String APP_ERROR_CODE = "999";

    public static String APP_ERROR_MSG = "服务暂时不可用,请稍后再试";

    /**
     * 用户注册相关状态码
     */
    public static String USER_REGISTER_SUCC_CODE = "0";
    public static String USER_REGISTER_SUCC_MSG = "执行用户注册服务成功";
    public static String USER_REGISTER_ACCOUNT_NUMBER_EXIT_CODE = "1001";
    public static String USER_REGISTER_ACCOUNT_NUMBER_EXIT_MSG = "账号已存在";
    public static String USER_REGISTER_CREATE_UID_FAILD_CODE = "1002";
    public static String USER_REGISTER_CREATE_UID_FAILD_MSG = "生成UID出错";
    public static String USER_REGISTER_DATE_PATTERN_ERROR_CODE = "1003";
    public static String USER_REGISTER_DATE_PATTERN_ERROR_MSG = "日期格式错误";

    /**
     * 用户登陆相关状态码
     */
    public static String USER_LOGIN_SUCC_CODE = "0";
    public static String USER_LOGIN_SUCC_MSG = "执行用户登陆服务成功";
    public static String USER_LOGIN_USER_IS_NULL_ERROR_CODE = "2001";
    public static String USER_LOGIN_USER_IS_NULL_ERROR_MSG = "用户不存在";
    public static String USER_LOGIN_PASSWORD_ERROR_CODE = "2002";
    public static String USER_LOGIN_PASSWORD_ERROR_MSG = "用户密码错误";
    public static String USER_LOGIN_WEIXIN_CODE_ERROR_CODE = "2003";
    public static String USER_LOGIN_WEIXIN_CODE_ERROR_MSG = "微信code为空";
    public static String USER_LOGIN_SMS_CODE_NULL_ERR_CODE = "2004";
    public static String USER_LOGIN_SMS_CODE_NULL_ERR_MSG = "短信验证码为空";
    public static String USER_LOGIN_WEIXIN_OPEN_CODE_GET_ERROR_CODE = "2005";
    public static String USER_LOGIN_WEIXIN_OPEN_CODE_GET_ERROR_MSG = "微信code获取失败";
    public static String USER_LOGIN_PASSWORD_EMPTY_ERROR_CODE = "2006";
    public static String USER_LOGIN_PASSWORD_EMPTY_ERROR_MSG = "密码为空";
    public static String USER_LOGIN_REGISTER_ERROR_CODE = "2007";
    public static String USER_LOGIN_REGISTER_ERROR_MSG = "注册失败";
    public static String USER_LOGIN_SMS_CODE_ERROR_CODE = "2008";
    public static String USER_LOGIN_SMS_CODE_ERROR_MSG = "短信验证码错误或超时";

    /**
     * token校验返回码
     */
    public static String VERIFY_TOKEN_SUCC_CODE = "0";
    public static String VERIFY_TOKEN_SUCC_MSG = "TOKEN校验成功";
    public static String VERIFY_TOKEN_ERROR_CODE = "3001";
    public static String VERIFY_TOKEN_ERROR_MSG = "非法的TOKEN,TOKEN校验失败";
    public static String VERIFY_TOKEN_EXPIRED_CODE = "3002";
    public static String VERIFY_TOKEN_EXPIRED_MSG = "TOKEN已经失效,TOKEN校验失败";

    /**
     * 用户信息查询返回码
     */
    public static String QUERY_USER_INFO_SUCC_CODE = "0";
    public static String QUERY_USER_INFO_SUCC_MSG = "执行用户信息查询服务成功";
    public static String QUERY_USER_INFO_ACCOUNT_NULL_ERROR_CODE = "4001";
    public static String QUERY_USER_INFO_ACCOUNT_NULL_ERROR_MSG = "登陆用户名为空";
    public static String QUERY_USER_INFO_USERID_NULL_ERROR_CODE = "4002";
    public static String QUERY_USER_INFO_USERID_NULL_ERROR_MSG = "userId为空";
    public static String QUERY_USER_INFO_OPERTYPE_ERROR_CODE = "4003";
    public static String QUERY_USER_INFO_OPERTYPE_ERROR_MSG = "查询操作类型不支持";
    public static String QUERY_USER_INFO_TOKENID_ERROR_CODE = "4004";
    public static String QUERY_USER_INFO_TOKENID_ERROR_MSG = "token校验失效";
    public static String QUERY_USER_INFO_USERIDS_ERROR_CODE = "4005";
    public static String QUERY_USER_INFO_USERIDS_ERROR_MSG = "userIds超过上限";

    /**
     * 发送短信验证码返回码
     */
    public static String SEND_VALID_SMS_SUCC_CODE = "0";
    public static String SEND_VALID_SMS_SUCC_MSG = "发送短信验证码成功";

    /**
     * 用户地址添加返回码
     */
    public static String ADD_USER_ADDRESS_SUCC_CODE = "0";
    public static String ADD_USER_ADDRESS_SUCC_MSG = "地址添加成功";
    public static String ADD_USER_ADDRESS_OLDADDRESSID_EMPTY_ERROR_CODE = "6001";
    public static String ADD_USER_ADDRESS_OLDADDRESSID_EMPTY_ERROR_MSG = "原地址id为空";
    public static String ADD_USER_ADDRESS_TOKENID_ERROR_CODE = "6002";
    public static String ADD_USER_ADDRESS_TOKENID_ERROR_MSG = "token校验失效";
    public static String ADD_USER_ADDRESS_OPTTYPE_ERROR_CODE = "6002";
    public static String ADD_USER_ADDRESS_OPTTYPE_ERROR_MSG = "token校验失效";
    public static String ADD_USER_ADDRESS_OLDADDRESSID_NOT_EXIST_ERROR_CODE = "6003";
    public static String ADD_USER_ADDRESS_OLDADDRESSID_NOT_EXIST_ERROR_MSG = "原地址不存在";

    /**
     * 用户地址刪除返回码
     */
    public static String DEL_USER_ADDRESS_SUCC_CODE = "0";
    public static String DEL_USER_ADDRESS_SUCC_MSG = "地址删除成功";
    public static String DEL_USER_ADDRESS_TOKENID_ERROR_CODE = "7001";
    public static String DEL_USER_ADDRESS_TOKENID_ERROR_MSG = "token校验失效,地址删除失败";
    public static String DEL_USER_ADDRESS_ADDRESSID_NOT_EXIST_ERROR_CODE = "7001";
    public static String DEL_USER_ADDRESS_ADDRESSID_NOT_EXIST_ERROR_MSG = "原地址不存在,地址刪除失败";

    /**
     * 用户地址查询返回码
     */
    public static String QUERY_USER_ADDRESS_SUCC_CODE = "0";
    public static String QUERY_USER_ADDRESS_SUCC_MSG = "查询地址成功";
    public static String QUERY_USER_ADDRESS_TOKENID_ERROR_CODE = "8001";
    public static String QUERY_USER_ADDRESS_TOKENID_ERROR_MSG = "token校验失效";
    public static String QUERY_USER_ADDRESS_USERID_EMPTY_ERROR_CODE = "8002";
    public static String QUERY_USER_ADDRESS_USERID_EMPTY_ERROR_MSG = "用户userId为空";
    public static String QUERY_USER_ADDRESS_ADDRESSID_EMPTY_ERROR_CODE = "8003";
    public static String QUERY_USER_ADDRESS_ADDRESSID_EMPTY_ERROR_MSG = "地址id为空";
    public static String QUERY_USER_ADDRESS_QUERY_TYPE_ERROR_CODE = "8004";
    public static String QUERY_USER_ADDRESS_QUERY_TYPE_ERROR_MSG = "查询类型暂不支持";

    /**
     * 获取用户已领取的优惠券返回码
     */
    public static String GET_USER_COUPON_TOKENID_ERROR_CODE = "9001";
    public static String GET_USER_COUPON_TOKENID_ERROR_MSG = "token校验失效";

    /**
     * 领取优惠券返回码
     */
    public static String RECEIVE_COUPON_SUCC_CODE = "0";
    public static String RECEIVE_COUPON_SUCC_MSG = "用户领取优惠券成功";
    public static String RECEIVE_COUPON_TOKENID_ERROR_CODE = "10001";
    public static String RECEIVE_COUPON_TOKENID_ERROR_MSG = "token校验失效";
    public static String RECEIVE_COUPON_STATUS_ERROR_CODE = "10002";
    public static String RECEIVE_COUPON_STATUS_ERROR_MSG = "劵已下线";
    public static String RECEIVE_COUPON_TIME_BEFORE_ERROR_CODE = "10003";
    public static String RECEIVE_COUPON_TIME_BEFORE_ERROR_MSG = "领取时间未到";
    public static String RECEIVE_COUPON_TIME_OVER_ERROR_CODE = "10004";
    public static String RECEIVE_COUPON_TIME_OVER_ERROR_MSG = "领取时间已结束";
    public static String RECEIVE_COUPON_BE_REBBED_ERROR_CODE = "10005";
    public static String RECEIVE_COUPON_BE_REBBED_ERROR_MSG = "劵已被领完,欢迎下次再来!";
    public static String RECEIVE_COUPON_NOT_EXIST_ERROR_CODE = "10006";
    public static String RECEIVE_COUPON_NOT_EXIST_ERROR_MSG = "劵不存在,欢迎下次再来!";

    /**
     * 使用优惠券返回码
     */
    public static String USE_COUPON_NO_RECORD_SUCC_CODE = "0";
    public static String USE_COUPON_NO_RECORD_SUCC_MSG= "使用优惠劵成功";
    public static String USE_COUPON_NO_RECORD_ERROR_CODE = "10101";
    public static String USE_COUPON_NO_RECORD_ERROR_MSG= "沒有优惠券记录";
    public static String USE_COUPON_TOKENID_ERROR_CODE = "10102";
    public static String USE_COUPON_TOKENID_ERROR_MSG = "token校验失效";
    public static String USE_COUPON_USED_ERROR_CODE = "10103";
    public static String USE_COUPON_USED_ERROR_MSG = "优惠券已使用";
    public static String USE_COUPON_TIME_OVER_ERROR_CODE = "10104";
    public static String USE_COUPON_TIME_OVER_ERROR_MSG = "该劵已过期";

    /**
     * 获取购物车返回码
     */
    public static String GET_CARTPROD_LIST_SUCC_CODE = "0";
    public static String GET_CARTPROD_LIST_SUCC_MSG = "获取购物车成功";
    public static String GET_CARTPROD_LIST_TOKENID_ERROR_CODE = "10201";
    public static String GET_CARTPROD_LIST_TOKENID_ERROR_MSG = "token校验失效,获取购物车失败";

    /**
     * 获取用户订单列表
     */
    public static String GET_ORDER_LIST_SUCC_CODE = "0";
    public static String GET_ORDER_LIST_SUCC_MSG = "获取订单列表成功";
    public static String GET_ORDER_LIST_TOKENID_ERROR_CODE = "10301";
    public static String GET_ORDER_LIST_TOKENID_ERROR_MSG = "token校验失效,获取订单列表失败";

    /**
     * 商品加入购物车返回码
     */

    public static String JOIN_CART_SUCC_CODE = "0";
    public static String JOIN_CART_SUCC_MSG = "加入购物车成功";
    public static String JOIN_CART_TOKENID_ERROR_CODE = "10401";
    public static String JOIN_CART_TOKENID_ERROR_MSG = "token校验失效";
    public static String JOIN_CART_PROD_NOT_EXSIT_ERROR_CODE = "10402";
    public static String JOIN_CART_PROD_NOT_EXSIT_ERROR_MSG = "商品不存在";
    public static String JOIN_CART_PROD_STATUS_ERROR_CODE = "10403";
    public static String JOIN_CART_PROD_STATUS_ERROR_MSG = "商品状态不正常";

    /**
     * 商品从购物车删除返回码
     */

    public static String DEL_CART_SUCC_CODE = "0";
    public static String DEL_CART_SUCC_MSG = "删除购物车成功";
    public static String DEL_CART_TOKENID_ERROR_CODE = "10501";
    public static String DEL_CART_TOKENID_ERROR_MSG = "token校验失效";

    /**
     * 商家查询优惠券返回码
     */
    public static String GET_SHOP_COUPON_SUCC_CODE = "0";
    public static String GET_SHOP_COUPON_SUCC_MSG= "商家查询优惠劵成功";
    public static String GET_SHOP_COUPON_TOKENID_ERROR_CODE = "10601";
    public static String GET_SHOP_COUPON_TOKENID_ERROR_MSG = "token校验失效";

    /**
     * 下单返回码
     */
    public static String ORDER_SUCC_CODE = "0";
    public static String ORDER_SUCC_MSG= "下单成功";
    public static String ORDER_TOKENID_ERROR_CODE = "10701";
    public static String ORDER_TOKENID_ERROR_MSG = "token校验失效";
    public static String ORDER_DETAIL_ERROR_CODE = "10702";
    public static String ORDER_DETAIL_ERROR_MSG = "details没有";
    public static String ORDER_LIST_ERROR_CODE = "10703";
    public static String ORDER_LIST_ERROR_MSG = "orders没有";

    /**
     * 取消订单返回码
     */
    public static String CLOSE_ORDER_SUCC_CODE = "0";
    public static String CLOSE_ORDER_SUCC_MSG= "取消订单成功";
    public static String CLOSE_ORDER_TOKENID_ERROR_CODE = "10801";
    public static String CLOSE_ORDER_TOKENID_ERROR_MSG = "token校验失效";
    public static String CLOSE_ORDER_NOT_EXIST_ERROR_CODE = "10802";
    public static String CLOSE_ORDER_NOT_EXIST_ERROR_MSG = "订单不存在";
    public static String CLOSE_ORDER_STATUS_ERROR_CODE = "10803";
    public static String CLOSE_ORDER_STATUS_ERROR_MSG = "订单目前状态不支持取消";

    /**
     * 发送聊天返回码
     */
    public static String SEND_MSG_SUCC_CODE = "0";
    public static String SEND_MSG_SUCC_MSG= "发送消息成功";
    public static String SEND_MSG_TOKENID_ERROR_CODE = "10901";
    public static String SEND_MSG_TOKENID_ERROR_MSG = "token校验失效";
    public static String SEND_MSG_WINDOWTYPE_NULL_ERROR_CODE = "10902";
    public static String SEND_MSG_WINDOWTYPE_NULL_ERROR_MSG = "窗口消息类型为空";

    /**
     * 查询聊天窗口消息返回码
     */
    public static String QUERY_WINDOW_MSG_SUCC_CODE = "0";
    public static String QUERY_WINDOW_MSG_SUCC_MSG= "查询聊天窗口成功";
    public static String QUERY_WINDOW_MSG_TOKENID_ERROR_CODE = "11001";
    public static String QUERY_WINDOW_MSG_TOKENID_ERROR_MSG = "token校验失效";
    public static String QUERY_WINDOW_MSG_PARAME_ERROR_CODE = "11002";
    public static String QUERY_WINDOW_MSG_PARAME_ERROR_MSG = "shopId，talker不能同时为空";

    /**
     * 创建聊天窗口消息返回码
     */
    public static String CREATE_WINDOW_SUCC_CODE = "0";
    public static String CREATE_WINDOW_SUCC_MSG= "创建聊天窗口成功";
    public static String CREATE_WINDOW_TOKENID_ERROR_CODE = "11101";
    public static String CREATE_WINDOW_TOKENID_ERROR_MSG = "token校验失效,创建聊天窗口失败";

    /**
     * 商店信息查询返回码
     */
    public static String GET_SHOP_INFO_SUCC_CODE = "0";
    public static String GET_SHOP_INFO_SUCC_MSG = "查询商店信息成功";
    public static String GET_SHOP_TOKENID_ERROR_CODE = "11201";
    public static String GET_SHOP_TOKENID_ERROR_MSG = "token校验失效";
    public static String GET_SHOP_SHOPIDS_ERROR_CODE = "11202";
    public static String GET_SHOP_SHOPIDS_ERROR_MSG = "shopIds超过上限";

    /**
     * 根据窗口id查询聊天窗口消息返回码
     */
    public static String QUERY_MSG_BYWINDOWIDS_SUCC_CODE = "0";
    public static String QUERY_MSG_BYWINDOWIDS_SUCC_MSG= "查询聊天信息成功";
    public static String QUERY_MSG_BYWINDOWIDS_TOKENID_ERROR_CODE = "11301";
    public static String QUERY_MSG_BYWINDOWIDS_TOKENID_ERROR_MSG = "token校验失效";
    public static String QUERY_MSG_BYWINDOWIDS_ERROR_CODE = "11302";
    public static String QUERY_MSG_BYWINDOWIDS_ERROR_MSG = "windowIds超过上限";

    /**
     * 用户评价返回码
     */
    public static String GRADE_ORDER_SUCC_CODE = "0";
    public static String GRADE_ORDER_SUCC_MSG= "用户评价成功";
    public static String GRADE_ORDER_TOKENID_ERROR_CODE = "11401";
    public static String GRADE_ORDER_TOKENID_ERROR_MSG = "token校验失效,用户评价失败";

    /**
     * 更新消息状态返回码
     */
    public static String UPDATE_MSG_SUCC_CODE = "0";
    public static String UPDATE_MSG_SUCC_MSG= "更新消息状态成功";
    public static String UPDATE_MSG_TOKENID_ERROR_CODE = "11501";
    public static String UPDATE_MSG_TOKENID_ERROR_MSG = "token校验失效,更新消息状态失败";
    public static String UPDATE_MSG_BYWINDOWIDS_ERROR_CODE = "11502";
    public static String UPDATE_MSG_BYWINDOWIDS_ERROR_MSG = "msgIds超过上限";

    /**
     * 查询商家管理权限返回码
     */
    public static String GET_SHOP_MANAGER_SUCC_CODE = "0";
    public static String GET_SHOP_MANAGER_SUCC_MSG= "获取商家管理人员权限信息成功";
    public static String GET_SHOP_MANAGER_TOKENID_ERROR_CODE = "11501";
    public static String GET_SHOP_MANAGER_TOKENID_ERROR_MSG = "token校验失效,获取商家管理人员权限信息失败";

    /**
     * 订单状态更新返回码
     */

    public static String UPDATE_ORDER_SUCC_CODE = "0";
    public static String UPDATE_ORDER_SUCC_MSG= "订单状态更新成功";
    public static String UPDATE_ORDER_TOKENID_ERROR_CODE = "11601";
    public static String UPDATE_ORDER_TOKENID_ERROR_MSG = "token校验失效,订单状态更新失败";
    public static String UPDATE_ORDER_NOT_EXIST_ERROR_CODE = "11602";
    public static String UPDATE_ORDER_NOT_EXIST_ERROR_MSG = "订单不存在,订单状态更新失败";
    public static String UPDATE_ORDER_DELIVERY_NO_NULL_ERROR_CODE = "11603";
    public static String UPDATE_ORDER_DELIVERY_NO_NULL_ERROR_MSG = "运单号为空,订单状态更新失败";

    /**
     * 评价查询返回码
     */
    public static String GET_PROD_GRADE_LIST_SUCC_CODE = "0";
    public static String GET_PROD_GRADE_LIST_SUCC_MSG= "获取评价列表成功";

    public static String QUERY_WINDOWS_SUCC_CODE = "0";
    public static String QUERY_WINDOWS_SUCC_MSG = "查询聊天窗口成功";
    public static String QUERY_WINDOWS_TOKENID_ERROR_CODE = "11701";
    public static String QUERY_WINDOWS_TOKENID_ERROR_MSG = "token校验失效,查询聊天窗口失败";

    /**
     * 微信通知返回码
     */
    public static String WEIXIN_NOTIFY_SUCC_CODE = "SUCCESS";
    public static String WEIXIN_NOTIFY_SUCC_MSG = "OK";
    public static String WEIXIN_NOTIFY_ERROR_CODE = "FAIL";
    public static String WEIXIN_NOTIFY_SIGN_CHECK_ERROR_MSG = "签名失败";

    /**
     * 添加账本记录
     */
    public static String ADD_ACCT_BOOK_SUCC_CODE = "0";
    public static String ADD_ACCT_BOOK_SUCC_MSG= "添加账本记录成功";
    public static String ADD_ACCT_BOOK_TOKENID_ERROR_CODE = "11801";
    public static String ADD_ACCT_BOOK_TOKENID_ERROR_MSG = "token校验失效";
    public static String ADD_ACCT_BOOK_ACCT_LOCK_ERROR_CODE = "11802";
    public static String ADD_ACCT_BOOK_ACCT_LOCK_ERROR_MSG = "账户已锁定";
    public static String ADD_ACCT_BOOK_SUBACCT_LOCK_ERROR_CODE = "11803";
    public static String ADD_ACCT_BOOK_SUBACCT_LOCK_ERROR_MSG = "子账户已锁定";
    public static String ADD_ACCT_BOOK_BALANCE_LOW_ERROR_CODE = "11804";
    public static String ADD_ACCT_BOOK_BALANCE_LOW_ERROR_MSG = "余额不足";
    public static String ADD_ACCT_BOOK_STATUS_ERROR_CODE = "11805";
    public static String ADD_ACCT_BOOK_STATUS_ERROR_MSG = "状态异常,添加账本记录失败";
    public static String ADD_ACCT_BOOK_UPDATE_SUB_ACCT_ERROR_CODE = "11806";
    public static String ADD_ACCT_BOOK_UPDATE_SUB_ACCT_ERROR_MSG = "子账本更新异常,添加账本记录失败";


    /**
     * 查询账本信息
     */
    public static String QUERY_ACCT_BOOK_SUCC_CODE = "0";
    public static String QUERY_ACCT_BOOK_SUCC_MSG= "查询账本记录成功";
    public static String QUERY_ACCT_BOOK_TOKENID_ERROR_CODE = "11901";
    public static String QUERY_ACCT_BOOK_TOKENID_ERROR_MSG = "token校验失效,查询账本记录失败";
    public static String QUERY_ACCT_BOOK_NULL_ERROR_CODE = "11902";
    public static String QUERY_ACCT_BOOK_NULL_ERROR_MSG = "transId和subAccountId不能同时为空,查询账本记录失败";

    /**
     * 添加账户
     */
    public static String ADD_ACCT_SUCC_CODE = "0";
    public static String ADD_ACCT_SUCC_MSG= "添加账户成功";
    public static String ADD_ACCT_TOKENID_ERROR_CODE = "12001";
    public static String ADD_ACCT_TOKENID_ERROR_MSG = "token校验失效,添加账户失败";
    public static String ADD_ACCT_LOCK_ERROR_CODE = "12002";
    public static String ADD_ACCT_LOCK_ERROR_MSG = "账户已锁定,添加账户失败";

    /**
     * 添加子账户
     */
    public static String ADD_SUB_ACCT_SUCC_CODE = "0";
    public static String ADD_SUB_ACCT_SUCC_MSG= "添加子账户成功";
    public static String ADD_SUB_ACCT_TOKENID_ERROR_CODE = "12101";
    public static String ADD_SUB_ACCT_TOKENID_ERROR_MSG = "token校验失效,添加子账户失败";
    public static String ADD_SUB_ACCT_LOCK_ERROR_CODE = "12102";
    public static String ADD_SUB_ACCT_LOCK_ERROR_MSG = "账户已锁定,添加子账户失败";
    public static String ADD_SUB_SUBACCT_LOCK_ERROR_CODE = "12103";
    public static String ADD_SUB_SUBACCT_LOCK_ERROR_MSG = "子账户已锁定,添加子账户失败";

    /**
     * 商品限制查询
     */
    public static String SEARCH_PROD_LIMIT_SUCC_CODE="0";
    public static String SEARCH_PROD_LIMIT_SUCC_MSG="商品限制查询成功";
    public static String SEARCH_PROD_LIMIT_TOKENID_ERROR_CODE="12201";
    public static String SEARCH_PROD_LIMIT_TOKENID_ERROR_MSG="token校验失败,商品限制查询失败";

    /**
     * 商品概要查询
     */
    public static String QUERY_PROD_SUMMARY_SUCC_CODE = "0";
    public static String QUERY_PROD_SUMMARY_SUCC_MSG = "商品概要信息查询成功";

    /**
     * 商品搜索查询
     */
    public static String SEARCH_PROD_SUCC_CODE = "0";
    public static String SEARCH_PROD_SUCC_MSG = "商品概要信息查询成功";

    /**
     * addGroup
     */
    public static String ADD_GROUP_ERR_CODE = "12301";
    public static String ADD_GROUP_ERR_MSG = "群成员加入有失败";

    /**
     * 红包相关
     */
    public static String BAG_STATUS_ALREADY_ERROR_CODE = "12401";
    public static String BAG_STATUS_ALREADY_ERROR_MSG = "红包状态已经是变更的状态,红包状态变更失败";
    public static String BAG_STATUS_REFUND_ERROR_CODE = "12402";
    public static String BAG_STATUS_REFUND_ERROR_MSG = "红包状态是发放完,不能退款,红包状态变更失败";
    public static String BAG_NOT_EXIST_ERROR_CODE = "";
    public static String BAG_NOT_EXIST_ERROR_MSG = "";
    public static String BAG_NEW_NO_ERROR_CODE = "12501";
    public static String BAG_NEW_NO_ERROR_MSG = "红包编号错误,红包创建失败";
    public static String BAG_NEW_ANSWER_NULL_ERROR_CODE = "12502";
    public static String BAG_NEW_ANSWER_NULL_ERROR_MSG = "答案或者竞猜数字为空,红包创建失败";

    public static String DRAW_BAG_NOT_EXSIT_ERROR_CODE = "12601";
    public static String DRAW_BAG_NOT_EXSIT_ERROR_MSG = "红包和收包人关系不存在,领取失败";
    public static String DRAW_BAG_NOT_PAY_ERROR_CODE = "12602";
    public static String DRAW_BAG_NOT_PAY_ERROR_MSG = "红包未支付,领取失败";
    public static String DRAW_BAG_FINISH_ERROR_CODE = "12603";
    public static String DRAW_BAG_FINISH_ERROR_MSG = "红包已领完";
    public static String DRAW_BAG_TIME_OUT_ERROR_CODE = "12604";
    public static String DRAW_BAG_TIME_OUT_ERROR_MSG = "红包已过期,领取失败";
    public static String DRAW_BAG_REPEAT_REQ_ERROR_CODE = "12605";
    public static String DRAW_BAG_REPEAT_REQ_ERROR_MSG = "重复请求,红包领取失败";
    public static String DRAW_BAG_RECORD_IS_EXIST_ERROR_CODE = "12606";
    public static String DRAW_BAG_RECORD_IS_EXIST_ERROR_MSG = "该用户已经领取过,红包领取失败";
    public static String DRAW_BAG_ANSWER_NULL_ERROR_CODE = "12607";
    public static String DRAW_BAG_ANSWER_NULL_ERROR_MSG = "answer为空,红包领取失败";
    public static String DRAW_BAG_ANSWER_ERROR_CODE = "12608";
    public static String DRAW_BAG_ANSWER_ERROR_MSG = "答案错误,红包领取失败";
    public static String DRAW_BAG_ALLOCATE_ERROR_CODE = "12609";
    public static String DRAW_BAG_ALLOCATE_ERROR_MSG = "红包分配类型错误,红包领取失败";
    public static String DRAW_BAG_RECORD_ONECE_TYPE_LIMIT_ERROR_CODE = "12610";
    public static String DRAW_BAG_RECORD_ONECE_TYPE_LIMIT_ERROR_MSG = "已超过领取次数,红包领取失败";
    public static String DRAW_BAG_RECORD_GUESS_SUCC_CODE = "12611";
    public static String DRAW_BAG_RECORD_GUESS_SUCC_MSG = "红包领取成功";


    public static String BIND_USER_PHONE_ALREADY_BIND_ERROR_CODE = "12701";
    public static String BIND_USER_PHONE_ALREADY_BIND_ERROR_MSG = "该手机号已被绑定,不能再次绑定.";
    public static String BIND_USER_PHONE_SMSCODE_ERROR_CODE = "12702";
    public static String BIND_USER_PHONE_SMSCODE_ERROR_MSG = "短信验证码错误,手机号绑定失败";
    public static String BIND_USER_PHONE_NOT_EXIST_BIND_ERROR_CODE = "12703";
    public static String BIND_USER_PHONE_NOT_EXIST_BIND_ERROR_MSG = "该手机号不存在，绑定失败";

    public static String SEND_SMS_VALID_CODE_ERROR_CODE = "12801";
    public static String SEND_SMS_VALID_CODE_ERROR_MSG = "短信验证码发送失败,稍后再试";
    public static String SEND_SMS_VALID_CODE_RESEND_CODE = "12802";
    public static String SEND_SMS_VALID_CODE_RESEND_MSG = "重复请求,短信验证码发送失败";
    public static String SEND_SMS_ERROR_CODE = "12803";
    public static String SEND_SMS_ERROR_MSG = "短信发送失败";
    public static String SEND_SMS_VALID_CODE_SAVE_ERROR_CODE = "12804";
    public static String SEND_SMS_VALID_CODE_SAVE_ERROR_RESEND_MSG = "验证码保存失败,短信验证码发送失败";

    public static String VERIFY_VALID_SMS_CODE_ERROR_CODE = "12901";
    public static String VERIFY_VALID_SMS_CODE_ERROR_MSG = "验证码不正确,短信校验失败";
    public static String VERIFY_VALID_SMS_CODE_SUCC_CODE = "12902";
    public static String VERIFY_VALID_SMS_CODE_SUCC_MSG = "验证码不正确,校验失败";

    /**
     * 统一预支付
     */
    public static String PRE_PAY_WX_CODE_EMPTY_ERROR_CODE = "13101";
    public static String PRE_PAY_WX_CODE_EMPTY_ERROR_MSG = "微信code为空,jspapi支付失败";
    public static final String PRE_PAY_WEIXIN_ACCESS_TOKEN_FAILD_ERROR_CODE = "13102";
    public static final String PRE_PAY_WEIXIN_ACCESS_TOKEN_FAILD_ERROR_MSG = "微信支付,获取access_token失败";

    public static final String PRE_PAY_WEIXIN_PREPAYID_FAILD_ERROR_CODE = "13103";
    public static final String PRE_PAY_WEIXIN_PREPAYID_FAILD_ERROR_MSG = "微信支付,获取prepayid失败";

    /**
     * 账号绑定
     */
    public static String USER_CASH_ACCT_BIND_EXIST_ERROR_CODE = "13201";
    public static String USER_CASH_ACCT_BIND_EXIST_ERROR_MSG = "账号已存在,绑定失败";
}
