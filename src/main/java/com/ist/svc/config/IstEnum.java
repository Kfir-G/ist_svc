package com.ist.svc.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 枚举都定义于次
 *
 */
public interface IstEnum {

    enum SeqName implements IstEnum {
        USER_ID("seq_user_id","UID序列"),
        USER_COUPON_NO("seq_user_coupon_no","用户领取劵生成的劵号"),
        ROAM_ACCOUNT("seq_roam_account","漫游账号序列"),
        WINDOW_ID("seq_window_id","消息窗口序列"),
        ORDER_ID("seq_order_id","订单id序列"),
        TRANS_ID("seq_trans_id_order","支付流水"),
        ORDER_NO("seq_order_no","订单号序列");
        private String seqValue;
        private String desc;
        SeqName (String seqValue,String desc){
            this.seqValue = seqValue;
            this.desc = desc;
        }
        public String getSeqValue() {
            return seqValue;
        }
        public String getDesc() {
            return desc;
        }
    }


    /**
     * 用户账号类型
     */
    enum UserType implements IstEnum {
        TYPE_PHONE(1,"手机号"),
        TYPE_ROMA(2,"漫游"),
        TYPE_EMAIL(3,"邮箱");

        private Integer type;
        private String typeDesc;
        UserType(Integer type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Integer getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static UserType getUserType(int code) {
            for (UserType type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
        public static List<Integer> getTypes(){
            List<Integer> types = new ArrayList<>();
            for (UserType type : values()){
                types.add(type.getType());

            }
            return types;
        }
    }

    enum ProductLine implements IstEnum {
        UNIT_PRODUCT(105, "统一产品线");
        private int code;
        private String desc;

        ProductLine(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }


    /**
     * 用户账号状态
     *      NORMAL      (1, "正常")
     *      LOGOUT      (2, "注销")
     */
    enum UserAccountStatus implements IstEnum {
        NORMAL(1, "正常"),
        LOGOUT(2, "注销");

        private int status;
        private String desc;

        UserAccountStatus(int status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public int getStatus() {
            return status;
        }

        public String getDesc() {
            return desc;
        }

    }

    /**
     * 用户劵状态
     *      NOT_USED      (1, "未使用")
     *      USED      (2, "已使用")
     */
    enum UserCouponStatus implements IstEnum {
        NOT_USED(Short.valueOf("1"), "未使用"),
        USED(Short.valueOf("2"), "已使用");

        private short status;
        private String desc;

        UserCouponStatus(short status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public short getStatus() {
            return status;
        }

        public String getDesc() {
            return desc;
        }

    }

    /**
     * 用户登陆类型
     */
    enum LoginType implements IstEnum {
        TYPE_ACCOUNT(1,"账号密码"),
        TYPE_SMS(2,"短信验证码"),
        TYPE_WEIXIN(3,"微信第三方登陆"),
        TYPE_WEIXIN_APP(4,"微信APP登陆");

        private Integer type;
        private String typeDesc;
        LoginType(Integer type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Integer getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static LoginType getUserType(int code) {
            for (LoginType type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 用户ChangeNum
     */
    enum ChangeNum implements IstEnum {
        RESET(Short.valueOf("0"),"需要重置");

        private short type;
        private String typeDesc;
        ChangeNum(short type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public short getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static ChangeNum getUserType(short code) {
            for (ChangeNum type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 用户状态
     */
    enum UserStatus implements IstEnum {
        NORMAL(Short.valueOf("1"),"正常"),
        REPORT_LOSS(Short.valueOf("2"),"挂失"),
        TITLE(Short.valueOf("9"),"封号");

        private short status;
        private String statusDesc;
        UserStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static UserStatus getStatusType(short status) {
            for (UserStatus userStatus : values()) {
                if (userStatus.getStatus() == status) {
                    return userStatus;
                }
            }
            return null;
        }
    }

    /**
     * 查询用户信息操作类型
     */
    enum QueryUserOperType implements IstEnum {
        TYPE_ACCOUNT(1,"通过登陆账号查询"),
        TYPE_USERID(2,"通过userId查询");

        private Integer type;
        private String typeDesc;
        QueryUserOperType(Integer type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Integer getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static QueryUserOperType getOperType(int code) {
            for (QueryUserOperType type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 添加用户地址作类型
     */
    enum UserAddressOptType implements IstEnum {
        TYPE_ADD(1,"添加"),
        TYPE_MODIFY(2,"修改");

        private Integer type;
        private String typeDesc;
        UserAddressOptType(Integer type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Integer getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static UserAddressOptType getOperType(int code) {
            for (UserAddressOptType type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 用户地址状态
     */
    enum UserAddressStatus implements IstEnum {
        NORMAL(Short.valueOf("1"),"正常"),
        DEL(Short.valueOf("2"),"刪除");

        private short status;
        private String statusDesc;
        UserAddressStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static UserAddressStatus getStatusType(short status) {
            for (UserAddressStatus userStatus : values()) {
                if (userStatus.getStatus() == status) {
                    return userStatus;
                }
            }
            return null;
        }
    }

    /**
     * 查询用户地址类型
     */
    enum QueryUserAddressType implements IstEnum {
        TYPE_USERID(1,"通过USERID查询"),
        TYPE_ADDRESSID(2,"通过ADDRESSID查询");

        private Integer type;
        private String typeDesc;
        QueryUserAddressType(Integer type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Integer getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static QueryUserAddressType getOperType(int code) {
            for (QueryUserAddressType type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 查询用户地址类型
     */
    enum QueryUserAddressIsDefault implements IstEnum {
        IS_DEFAULT(Short.valueOf("1"),"默认"),
        NOT_DEFAULT(Short.valueOf("0"),"不是默认");

        private Short type;
        private String typeDesc;
        QueryUserAddressIsDefault(Short type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Short getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static QueryUserAddressIsDefault getOperType(int code) {
            for (QueryUserAddressIsDefault type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 产品状态
     */
    enum ProdStatus implements IstEnum {
        NORMAL(Short.valueOf("1"),"正常"),
        OFFLINE(Short.valueOf("2"),"下线"),
        NOT_ON_LINE((short)0,"未上线");

        private short status;
        private String statusDesc;
        ProdStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static ProdStatus getStatusType(short status) {
            for (ProdStatus prodStatus : values()) {
                if (prodStatus.getStatus() == status) {
                    return prodStatus;
                }
            }
            return null;
        }
    }

    enum ResultEnum implements IstEnum{

        SUCCESS(0, "success"),
        OPERATE_FAIL(1000, "操作失败"),
        ;
        ResultEnum(int code,String msg){
            this.code = code;
            this.msg = msg;
        }
        public int getCode(){
            return code;
        }
        int code;
        String msg;
    }

    /**
     * 订单状态
     */
    enum OrderStatus implements IstEnum {
        CANCEL(Short.valueOf("0"),"取消"),
        NOT_PAY(Short.valueOf("2"),"未付款"),
        PAY((short)4,"已付款"),
        DELIVERY((short)8,"配送中"),
        COMPLETED((short)10,"已付款");

        private short status;
        private String statusDesc;
        OrderStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static OrderStatus getStatusType(short status) {
            for (OrderStatus orderStatus : values()) {
                if (orderStatus.getStatus() == status) {
                    return orderStatus;
                }
            }
            return null;
        }
    }

    /**
     * 聊天消息状态
     */
    enum MsgStatus implements IstEnum {
        NOT_DELIVERY(Short.valueOf("-1"),"未送达"),
        NOT_READ(Short.valueOf("0"),"未读"),
        READ(Short.valueOf("1"),"已读"),
        UNDO(Short.valueOf("2"),"撤销");

        private short status;
        private String statusDesc;
        MsgStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static MsgStatus getStatusType(short status) {
            for (MsgStatus userStatus : values()) {
                if (userStatus.getStatus() == status) {
                    return userStatus;
                }
            }
            return null;
        }
    }

    /**
     * 聊天消息状态
     */
    enum GradeProcStatus implements IstEnum {
        EFFECT_MOT_DISPLAY(Short.valueOf("0"),"生效但不显示"),
        MODIFY(Short.valueOf("2"),"修改后"),
        NORMAL(Short.valueOf("1"),"正常"),
        DELETE(Short.valueOf("-1"),"删除");

        private short status;
        private String statusDesc;
        GradeProcStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static GradeProcStatus getStatusType(short status) {
            for (GradeProcStatus gradeProcStatus : values()) {
                if (gradeProcStatus.getStatus() == status) {
                    return gradeProcStatus;
                }
            }
            return null;
        }
    }

    /**
     * 账户状态
     */
    enum AcctStatus implements IstEnum {
        NORMAL(Short.valueOf("1"),"正常"),
        LOCK(Short.valueOf("2"),"下线");

        private short status;
        private String statusDesc;
        AcctStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static AcctStatus getStatusType(short status) {
            for (AcctStatus acctStatus : values()) {
                if (acctStatus.getStatus() == status) {
                    return acctStatus;
                }
            }
            return null;
        }
    }

    /**
     * 账本状态
     */
    enum AcctBookStatus implements IstEnum {
        TO_BE_PAY(Short.valueOf("0"),"发起支付"),
        PAY_FINISH(Short.valueOf("1"),"完成支付");

        private Short status;
        private String statusDesc;
        AcctBookStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public Short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static AcctBookStatus getStatusType(Short status) {
            for (AcctBookStatus acctStatus : values()) {
                if (acctStatus.getStatus() == status) {
                    return acctStatus;
                }
            }
            return null;
        }
    }

    /**
     * 账本类型
     */
    enum AcctType implements IstEnum {
        CASH(1,"现金"),
        INTEGRAL(2,"积分"),
        BOND(3,"保证金"),
        BAG(10,"红包金币"),
        BAG_COIN(11,"红包金币"),
        BOOK(99,"记账");

        private int type;
        private String typeDesc;
        AcctType(int type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public int getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static AcctType getStatusType(short status) {
            for (AcctType acctType : values()) {
                if (acctType.getType() == status) {
                    return acctType;
                }
            }
            return null;
        }
    }

    /**
     * 账本类型
     */
    enum AcctUserType implements IstEnum {
        USER(0,"用户id"),
        MERCHANT(1,"商户id");

        private int type;
        private String typeDesc;
        AcctUserType(int type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public int getAcctUserType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static AcctUserType getAcctUserType(short status) {
            for (AcctUserType acctType : values()) {
                if (acctType.getAcctUserType() == status) {
                    return acctType;
                }
            }
            return null;
        }
    }

    /**
     * 好友分组类型
     */
    enum GroupType implements IstEnum{
        /**
         * -1 黑名单
         * 2 亲友
         * 4 好友
         * 6 同学
         * 8 同事
         * 10 朋友
         * 12 其他
         */
        BLACK((short)-1,"否"),
        FFRIEND((short)2,"亲友"),
        GFRIEND((short)4,"好友"),
        CLASSMATE((short)6,"同学"),
        FRIEND((short)10,"朋友"),
        OTHER((short)12,"其他");

        private short code;
        private String desc;
        GroupType(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static GroupType getGroupType(short c){
            for (GroupType item : GroupType.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 分组状态
     */
    enum GroupStatus implements IstEnum{
        /**
         * 1 正常
         * 2 解散
         * 5 禁言
         */
        NORMAL((short)1,"正常"),
        DISMISS((short)2,"解散"),
        SILENCE((short)5,"禁言");

        private short code;
        private String desc;
        GroupStatus(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static GroupStatus getGroupStatus(short c){
            for (GroupStatus item : GroupStatus.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 成员角色
     */
    enum MemberRole implements IstEnum{
        /**
         * 0 成员
         * 1 创建者
         * 2 管理员
         */
        MEMBER((short)0,"成员"),
        CREATER((short)2,"创建者"),
        ADMINE((short)5,"管理员");

        private short code;
        private String desc;
        MemberRole(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static MemberRole getMemRole(short c){
            for (MemberRole item : MemberRole.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }
    /**
     * 红包状态
     */
    enum BagStatus implements IstEnum{
        INIT((short)0,"创建待支付"),
        PAY_COMPLETE((short)1,"支付完成"),
        PROVIDE((short)2,"待发放"),
        PROVIDEING((short)3,"发放中"),
        PROVIDE_FINISH((short)5,"发放完"),
        MOT_PROVIDE_FEFUND((short)6,"未发放部分已退款"),
        FEFUND_ALL((short)7,"全部退款");

        private short code;
        private String desc;
        BagStatus(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static BagStatus getBagStatus(short c){
            for (BagStatus item : BagStatus.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 红包分配类型
     */
    enum BagAllocateType implements IstEnum{
        RANDOM((short)1,"随机"),
        AVERAGE((short)2,"平均"),
        SPECIFIC((short)2,"特定");

        private short code;
        private String desc;
        BagAllocateType(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getBagAllocateType() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static BagAllocateType getBagAllocateType(short c){
            for (BagAllocateType item : BagAllocateType.values()) {
                if (item.getBagAllocateType() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 账本业务类型
     */
    enum BookBizType implements IstEnum{
        ORDER((short)1,"订单"),
        BAG((short)2,"红包");

        private short code;
        private String desc;
        BookBizType(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static BookBizType getBookBizType(short c){
            for (BookBizType item : BookBizType.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 红包类型
     */
    enum BagType implements IstEnum{
        NORMAL((short)11,"普通红包"),
        LUCK((short)12,"拼手气"),
        GUESS((short)21,"竞猜"),
        ANSWER((short)31,"答题");

        private short code;
        private String desc;
        BagType(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static BagType getBagType(short c){
            for (BagType item : BagType.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 领取记录状态
     */
    enum BagDrawStatus implements IstEnum{
        DRAW_SUCC((short)1,"成功领取(竞猜分账)"),
        NO_SUCC_DRAW((short)2,"非成功领取(有效竞猜或有效答题)"),
        NOT_EFFECTIVE((short)3,"无效(竞猜/错误答题)");

        private short code;
        private String desc;
        BagDrawStatus(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static BagDrawStatus getBagDrawStatus(short c){
            for (BagDrawStatus item : BagDrawStatus.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 领取记录状态
     */
    enum BagCheckResult implements IstEnum{
        NORMAL((short)1,"正常"),
        LESS_COLLAR((short)2,"少领"),
        MULTI_COLLAR((short)3,"多领");

        private short code;
        private String desc;
        BagCheckResult(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static BagCheckResult getBagCheckResult(short c){
            for (BagCheckResult item : BagCheckResult.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 支付来源
     */
    enum PayType implements IstEnum{
        INSIDE(0,"内部"),
        WEIXIN(1,"微信"),
        ALIPAY(2,"支付宝"),
        BANK(3,"银行转账");

        private Integer code;
        private String desc;
        PayType(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static PayType getPayType(short c){
            for (PayType item : PayType.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 短信业务类型
     */
    enum SmsBizType implements IstEnum{
        REGISTER(1,"注册短信验证码");

        private Integer code;
        private String desc;
        SmsBizType(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static SmsBizType getSmsBizType(short c){
            for (SmsBizType item : SmsBizType.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }
    /**
     * 红包领取次数限制
     */
    enum BagOnceType implements IstEnum{
        NOT_LIMIT(-1,"不限"),
        ONCE_LIMIT(1,"一次机会");

        private Integer code;
        private String desc;
        BagOnceType(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static BagOnceType getBagOnceType(short c){
            for (BagOnceType item : BagOnceType.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 红包领取次数限制
     */
    enum TradeType implements IstEnum{
        JSAPI("JSAPI","JSAPI支付"),
        APP("APP","APP支付");

        private String code;
        private String desc;
        TradeType(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public String getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static TradeType getTradeType(String c){
            for (TradeType item : TradeType.values()) {
                if (item.getCode().equals(c)) {
                    return item;
                }
            }
            return null;
        }
    }
}
