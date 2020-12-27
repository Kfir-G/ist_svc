package com.ist.svc.domain;

import java.util.Date;

public class ProdHis {
    private Integer hisid;

    private Integer prodid;

    private Integer prodinfoid;

    private Short prodtype;

    private Integer shopid;

    private String name;

    private Float total;

    private Float once;

    private Float originalfee;

    private Float salefee;

    private Short delivery;

    private Short status;

    private Date onlinetime;

    private Date offtime;

    private Short monthnum;

    private Short starttype;

    private Date starttime;

    private Date endtime;

    private Short canceltype;

    private Short endcanceltype;

    private Short afekeep;

    private Short transfer;

    private Short channel;

    private Integer amount;

    private Date createtime;

    private Date updatetime;

    private Long userid;

    public Integer getHisid() {
        return hisid;
    }

    public void setHisid(Integer hisid) {
        this.hisid = hisid;
    }

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public Integer getProdinfoid() {
        return prodinfoid;
    }

    public void setProdinfoid(Integer prodinfoid) {
        this.prodinfoid = prodinfoid;
    }

    public Short getProdtype() {
        return prodtype;
    }

    public void setProdtype(Short prodtype) {
        this.prodtype = prodtype;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getOnce() {
        return once;
    }

    public void setOnce(Float once) {
        this.once = once;
    }

    public Float getOriginalfee() {
        return originalfee;
    }

    public void setOriginalfee(Float originalfee) {
        this.originalfee = originalfee;
    }

    public Float getSalefee() {
        return salefee;
    }

    public void setSalefee(Float salefee) {
        this.salefee = salefee;
    }

    public Short getDelivery() {
        return delivery;
    }

    public void setDelivery(Short delivery) {
        this.delivery = delivery;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(Date onlinetime) {
        this.onlinetime = onlinetime;
    }

    public Date getOfftime() {
        return offtime;
    }

    public void setOfftime(Date offtime) {
        this.offtime = offtime;
    }

    public Short getMonthnum() {
        return monthnum;
    }

    public void setMonthnum(Short monthnum) {
        this.monthnum = monthnum;
    }

    public Short getStarttype() {
        return starttype;
    }

    public void setStarttype(Short starttype) {
        this.starttype = starttype;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Short getCanceltype() {
        return canceltype;
    }

    public void setCanceltype(Short canceltype) {
        this.canceltype = canceltype;
    }

    public Short getEndcanceltype() {
        return endcanceltype;
    }

    public void setEndcanceltype(Short endcanceltype) {
        this.endcanceltype = endcanceltype;
    }

    public Short getAfekeep() {
        return afekeep;
    }

    public void setAfekeep(Short afekeep) {
        this.afekeep = afekeep;
    }

    public Short getTransfer() {
        return transfer;
    }

    public void setTransfer(Short transfer) {
        this.transfer = transfer;
    }

    public Short getChannel() {
        return channel;
    }

    public void setChannel(Short channel) {
        this.channel = channel;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}