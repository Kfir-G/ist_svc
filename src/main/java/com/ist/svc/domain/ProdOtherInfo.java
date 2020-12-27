package com.ist.svc.domain;

import java.util.Date;

public class ProdOtherInfo {
    private Integer prodinfoid;

    private Float minprice;

    private Float maxprice;

    private Integer sales;

    private Float grade;

    private Date updatetime;

    //prodInfo

    private String prodInfoName;
    private String desc;
    private String headimg;

    private String topimgs;

    public Integer getProdinfoid() {
        return prodinfoid;
    }

    public void setProdinfoid(Integer prodinfoid) {
        this.prodinfoid = prodinfoid;
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

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getProdInfoName() {
        return prodInfoName;
    }

    public void setProdInfoName(String prodInfoName) {
        this.prodInfoName = prodInfoName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getTopimgs() {
        return topimgs;
    }

    public void setTopimgs(String topimgs) {
        this.topimgs = topimgs;
    }
}