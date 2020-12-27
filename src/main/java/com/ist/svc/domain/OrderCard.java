package com.ist.svc.domain;

import java.util.Date;

public class OrderCard {
    private Long orderid;

    private Long userid;

    private Integer shopid;

    private Integer prodid;

    private Date starttime;

    private Date endtime;

    private Float total;

    private Float once;

    private Float usenum;

    private Float leavenum;

    private Short canceltype;

    private Short endcanceltype;

    private Short channel;

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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

    public Float getUsenum() {
        return usenum;
    }

    public void setUsenum(Float usenum) {
        this.usenum = usenum;
    }

    public Float getLeavenum() {
        return leavenum;
    }

    public void setLeavenum(Float leavenum) {
        this.leavenum = leavenum;
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

    public Short getChannel() {
        return channel;
    }

    public void setChannel(Short channel) {
        this.channel = channel;
    }
}