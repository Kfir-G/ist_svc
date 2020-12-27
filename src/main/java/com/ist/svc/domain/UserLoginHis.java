package com.ist.svc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class UserLoginHis {
    private Long id;

    private Long userid;

    private Date createtime;

    private Short citycode;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String device;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Short getCitycode() {
        return citycode;
    }

    public void setCitycode(Short citycode) {
        this.citycode = citycode;
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

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }
}