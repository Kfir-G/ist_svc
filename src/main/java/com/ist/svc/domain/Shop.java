package com.ist.svc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Shop {
    private Integer shopid;

    private Short tradetype;

    private String shopname;

    private String avatarurl;

    private Short cityid;

    private Short areaid;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Date createtime;

    private Date updatetime;

    private Float grade;

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Short getTradetype() {
        return tradetype;
    }

    public void setTradetype(Short tradetype) {
        this.tradetype = tradetype;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public Short getCityid() {
        return cityid;
    }

    public void setCityid(Short cityid) {
        this.cityid = cityid;
    }

    public Short getAreaid() {
        return areaid;
    }

    public void setAreaid(Short areaid) {
        this.areaid = areaid;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
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

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }
}