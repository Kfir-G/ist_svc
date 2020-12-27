package com.ist.svc.domain;

import java.util.Date;

public class UserAccountBook {
    private Long transid;

    private Long subaccountid;

    private Long accountid;

    private Short accttype;

    private Short biztype;

    private Short direct;

    private Short paytype;

    private String orderid;

    private Short status;

    private String otherorder;

    private String otheracct;

    private Float money;

    private Float balance;

    private Date createtime;

    private Date updatetime;

    private Long optuserid;

    private String descr;

    public Long getTransid() {
        return transid;
    }

    public void setTransid(Long transid) {
        this.transid = transid;
    }

    public Long getSubaccountid() {
        return subaccountid;
    }

    public void setSubaccountid(Long subaccountid) {
        this.subaccountid = subaccountid;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Short getAccttype() {
        return accttype;
    }

    public void setAccttype(Short accttype) {
        this.accttype = accttype;
    }

    public Short getDirect() {
        return direct;
    }

    public void setDirect(Short direct) {
        this.direct = direct;
    }

    public Short getPaytype() {
        return paytype;
    }

    public void setPaytype(Short paytype) {
        this.paytype = paytype;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getOtherorder() {
        return otherorder;
    }

    public void setOtherorder(String otherorder) {
        this.otherorder = otherorder == null ? null : otherorder.trim();
    }

    public String getOtheracct() {
        return otheracct;
    }

    public void setOtheracct(String otheracct) {
        this.otheracct = otheracct == null ? null : otheracct.trim();
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getOptuserid() {
        return optuserid;
    }

    public void setOptuserid(Long optuserid) {
        this.optuserid = optuserid;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Short getBiztype() {
        return biztype;
    }

    public void setBiztype(Short biztype) {
        this.biztype = biztype;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}