package com.ist.svc.domain;

import java.util.Date;

public class UserSubAccount {
    private Long subaccountid;

    private Long accountid;

    private Short accttype;

    private Short status;

    private Float balance;

    private Date createtime;

    private Date updatetime;

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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}