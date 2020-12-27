package com.ist.svc.domain;

import java.util.Date;

public class ProdSaleProd {
    private Integer id;

    private Integer saleid;

    private Integer shopid;

    private Integer prodid;

    private Short status;

    private Long userid;

    private Date createtime;

    private Date canneltime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleid() {
        return saleid;
    }

    public void setSaleid(Integer saleid) {
        this.saleid = saleid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getCanneltime() {
        return canneltime;
    }

    public void setCanneltime(Date canneltime) {
        this.canneltime = canneltime;
    }
}