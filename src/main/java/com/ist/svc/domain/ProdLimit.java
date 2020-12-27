package com.ist.svc.domain;

import java.util.Date;

public class ProdLimit {
    private Integer prodlimitid;

    private Short tradetypeid;

    private Short prodtypeid;

    private Integer shopid;

    private Short status;

    private String name;

    private String descr;

    private Short safekeepmin;

    private Short safekeepmax;

    private Short safekeep;

    private Short safekeeparrive;

    private Short canceltype;

    private Float cancelhours;

    private Short overhourscanceltype;

    private Float cancelfee;

    private Short begincanceltype;

    private Short endcanceltype;

    private Float begincancelfee;

    private Float endcancelfee;

    private Short transfertype;

    private Short transferfeetype;

    private Float transferfee;

    private Short transfernum;

    private Float transferprice;

    private Short sharetype;

    private Short sharenum;

    private Date createtime;

    private Date updatetime;

    private Long optuserid;

    public Integer getProdlimitid() {
        return prodlimitid;
    }

    public void setProdlimitid(Integer prodlimitid) {
        this.prodlimitid = prodlimitid;
    }

    public Short getTradetypeid() {
        return tradetypeid;
    }

    public void setTradetypeid(Short tradetypeid) {
        this.tradetypeid = tradetypeid;
    }

    public Short getProdtypeid() {
        return prodtypeid;
    }

    public void setProdtypeid(Short prodtypeid) {
        this.prodtypeid = prodtypeid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Short getSafekeepmin() {
        return safekeepmin;
    }

    public void setSafekeepmin(Short safekeepmin) {
        this.safekeepmin = safekeepmin;
    }

    public Short getSafekeepmax() {
        return safekeepmax;
    }

    public void setSafekeepmax(Short safekeepmax) {
        this.safekeepmax = safekeepmax;
    }

    public Short getSafekeep() {
        return safekeep;
    }

    public void setSafekeep(Short safekeep) {
        this.safekeep = safekeep;
    }

    public Short getSafekeeparrive() {
        return safekeeparrive;
    }

    public void setSafekeeparrive(Short safekeeparrive) {
        this.safekeeparrive = safekeeparrive;
    }

    public Short getCanceltype() {
        return canceltype;
    }

    public void setCanceltype(Short canceltype) {
        this.canceltype = canceltype;
    }

    public Float getCancelhours() {
        return cancelhours;
    }

    public void setCancelhours(Float cancelhours) {
        this.cancelhours = cancelhours;
    }

    public Short getOverhourscanceltype() {
        return overhourscanceltype;
    }

    public void setOverhourscanceltype(Short overhourscanceltype) {
        this.overhourscanceltype = overhourscanceltype;
    }

    public Float getCancelfee() {
        return cancelfee;
    }

    public void setCancelfee(Float cancelfee) {
        this.cancelfee = cancelfee;
    }

    public Short getBegincanceltype() {
        return begincanceltype;
    }

    public void setBegincanceltype(Short begincanceltype) {
        this.begincanceltype = begincanceltype;
    }

    public Short getEndcanceltype() {
        return endcanceltype;
    }

    public void setEndcanceltype(Short endcanceltype) {
        this.endcanceltype = endcanceltype;
    }

    public Float getBegincancelfee() {
        return begincancelfee;
    }

    public void setBegincancelfee(Float begincancelfee) {
        this.begincancelfee = begincancelfee;
    }

    public Float getEndcancelfee() {
        return endcancelfee;
    }

    public void setEndcancelfee(Float endcancelfee) {
        this.endcancelfee = endcancelfee;
    }

    public Short getTransfertype() {
        return transfertype;
    }

    public void setTransfertype(Short transfertype) {
        this.transfertype = transfertype;
    }

    public Short getTransferfeetype() {
        return transferfeetype;
    }

    public void setTransferfeetype(Short transferfeetype) {
        this.transferfeetype = transferfeetype;
    }

    public Float getTransferfee() {
        return transferfee;
    }

    public void setTransferfee(Float transferfee) {
        this.transferfee = transferfee;
    }

    public Short getTransfernum() {
        return transfernum;
    }

    public void setTransfernum(Short transfernum) {
        this.transfernum = transfernum;
    }

    public Float getTransferprice() {
        return transferprice;
    }

    public void setTransferprice(Float transferprice) {
        this.transferprice = transferprice;
    }

    public Short getSharetype() {
        return sharetype;
    }

    public void setSharetype(Short sharetype) {
        this.sharetype = sharetype;
    }

    public Short getSharenum() {
        return sharenum;
    }

    public void setSharenum(Short sharenum) {
        this.sharenum = sharenum;
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

    public Long getOptuserid() {
        return optuserid;
    }

    public void setOptuserid(Long optuserid) {
        this.optuserid = optuserid;
    }
}