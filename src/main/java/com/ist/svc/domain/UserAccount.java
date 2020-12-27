package com.ist.svc.domain;

import java.util.Date;

public class UserAccount {
    private Long accountid;

    private Long ownuserid;

    private Short usertype;

    private String name;

    private Short status;

    private Date createtime;

    private Date updatetime;

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Long getOwnuserid() {
        return ownuserid;
    }

    public void setOwnuserid(Long ownuserid) {
        this.ownuserid = ownuserid;
    }

    public Short getUsertype() {
        return usertype;
    }

    public void setUsertype(Short usertype) {
        this.usertype = usertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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