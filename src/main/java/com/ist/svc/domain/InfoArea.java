package com.ist.svc.domain;

public class InfoArea {
    private Short areaid;

    private String province;

    private String city;

    private Short cityid;

    private String area;

    public Short getAreaid() {
        return areaid;
    }

    public void setAreaid(Short areaid) {
        this.areaid = areaid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Short getCityid() {
        return cityid;
    }

    public void setCityid(Short cityid) {
        this.cityid = cityid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}