package com.ist.svc.domain;

import java.util.Date;

public class InfoCity {
    private Short cityid;

    private String province;

    private Date city;

    public Short getCityid() {
        return cityid;
    }

    public void setCityid(Short cityid) {
        this.cityid = cityid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public Date getCity() {
        return city;
    }

    public void setCity(Date city) {
        this.city = city;
    }
}