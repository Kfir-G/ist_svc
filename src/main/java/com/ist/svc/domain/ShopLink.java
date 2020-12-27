package com.ist.svc.domain;

import java.util.Date;

public class ShopLink {
    private Integer shopid;

    private Integer footshopid;

    private Short foottype;

    private Short status;

    private Date createtime;

    private Date updatetime;

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getFootshopid() {
        return footshopid;
    }

    public void setFootshopid(Integer footshopid) {
        this.footshopid = footshopid;
    }

    public Short getFoottype() {
        return foottype;
    }

    public void setFoottype(Short foottype) {
        this.foottype = foottype;
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