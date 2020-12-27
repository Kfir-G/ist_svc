package com.ist.svc.domain;

import java.util.Date;

public class ProdInfo {
    private Integer prodinfoid;

    private Short prodtype;

    private Integer shopid;

    private String name;

    private String headimg;

    private String topimgs;

    private String descr;

    private Date createtime;

    private Date updatetime;

    private Short cityid;

    private Float minprice;

    private Float maxprice;

    private Integer sales;

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

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getTopimgs() {
        return topimgs;
    }

    public void setTopimgs(String topimgs) {
        this.topimgs = topimgs == null ? null : topimgs.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
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

    public Short getCityid() {
        return cityid;
    }

    public void setCityid(Short cityid) {
        this.cityid = cityid;
    }

    public Float getMinprice() {
        return minprice;
    }

    public void setMinprice(Float minprice) {
        this.minprice = minprice;
    }

    public Float getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(Float maxprice) {
        this.maxprice = maxprice;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}