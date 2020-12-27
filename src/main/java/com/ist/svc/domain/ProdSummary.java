package com.ist.svc.domain;

import java.util.Date;

public class ProdSummary {
    private Integer prodid;

    private Integer shopid;

    private Float minprice;

    private Float maxprice;

    private Integer sales;

    private Short isstock;

    private Short ishot;

    private Short seqfactor;

    private Float grade;

    private Date createtime;

    private Date updatetime;

    private Short status;

    private String prodname;

    private String headimg;

    private Short provinceid;

    private Short cityid;

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
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

    public Short getIsstock() {
        return isstock;
    }

    public void setIsstock(Short isstock) {
        this.isstock = isstock;
    }

    public Short getIshot() {
        return ishot;
    }

    public void setIshot(Short ishot) {
        this.ishot = ishot;
    }

    public Short getSeqfactor() {
        return seqfactor;
    }

    public void setSeqfactor(Short seqfactor) {
        this.seqfactor = seqfactor;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname == null ? null : prodname.trim();
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
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
}