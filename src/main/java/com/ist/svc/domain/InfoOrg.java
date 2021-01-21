package com.ist.svc.domain;

import java.util.Date;

public class InfoOrg {
    private Integer orgid;

    private Short provinceid;

    private Short cityid;

    private String city;

    private Short areaid;

    private String area;

    private Integer townid;

    private String town;

    private Integer villageid;

    private String village;

    private Short isTownVilla;

    private String orgName;

    private String oldName;

    private Integer countNum;

    private Date createTime;

    private Date updateTime;

    public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    public Short getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Short provinceid) {
        this.provinceid = provinceid;
    }

    public Short getCityid() {
        return cityid;
    }

    public void setCityid(Short cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Short getAreaid() {
        return areaid;
    }

    public void setAreaid(Short areaid) {
        this.areaid = areaid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Integer getTownid() {
        return townid;
    }

    public void setTownid(Integer townid) {
        this.townid = townid;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public Integer getVillageid() {
        return villageid;
    }

    public void setVillageid(Integer villageid) {
        this.villageid = villageid;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village == null ? null : village.trim();
    }

    public Short getIsTownVilla() {
        return isTownVilla;
    }

    public void setIsTownVilla(Short isTownVilla) {
        this.isTownVilla = isTownVilla;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName == null ? null : oldName.trim();
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}