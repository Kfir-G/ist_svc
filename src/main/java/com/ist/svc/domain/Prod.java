package com.ist.svc.domain;

import java.util.Date;

public class Prod {
    private Integer prodid;

    private Short deleted;

    private Short prodtypeid;

    private Integer shopid;

    private Short provinceid;

    private Short cityid;

    private Short status;

    private String prodname;

    private String headimg;

    private String topimgs;

    private String video;

    private String descr;

    private String parameterjson;

    private String matter;

    private Short delivery;

    private Short buylimit;

    private Short buylimitdays;

    private Date onlinetime;

    private Date offlinetime;

    private Date salestarttime;

    private Date saleendtime;

    private Short isprecard;

    private Short hascanceltype;

    private Date createtime;

    private Date updatetime;

    private Long optuserid;

    //扩展字段
    private Float saleFee;//商品售价

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public Short getProdtypeid() {
        return prodtypeid;
    }

    public void setProdtypeid(Short prodtypeid) {
        this.prodtypeid = prodtypeid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
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

    public String getTopimgs() {
        return topimgs;
    }

    public void setTopimgs(String topimgs) {
        this.topimgs = topimgs == null ? null : topimgs.trim();
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public String getParameterjson() {
        return parameterjson;
    }

    public void setParameterjson(String parameterjson) {
        this.parameterjson = parameterjson == null ? null : parameterjson.trim();
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter == null ? null : matter.trim();
    }

    public Short getDelivery() {
        return delivery;
    }

    public void setDelivery(Short delivery) {
        this.delivery = delivery;
    }

    public Short getBuylimit() {
        return buylimit;
    }

    public void setBuylimit(Short buylimit) {
        this.buylimit = buylimit;
    }

    public Short getBuylimitdays() {
        return buylimitdays;
    }

    public void setBuylimitdays(Short buylimitdays) {
        this.buylimitdays = buylimitdays;
    }

    public Date getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(Date onlinetime) {
        this.onlinetime = onlinetime;
    }

    public Date getOfflinetime() {
        return offlinetime;
    }

    public void setOfflinetime(Date offlinetime) {
        this.offlinetime = offlinetime;
    }

    public Date getSalestarttime() {
        return salestarttime;
    }

    public void setSalestarttime(Date salestarttime) {
        this.salestarttime = salestarttime;
    }

    public Date getSaleendtime() {
        return saleendtime;
    }

    public void setSaleendtime(Date saleendtime) {
        this.saleendtime = saleendtime;
    }

    public Short getIsprecard() {
        return isprecard;
    }

    public void setIsprecard(Short isprecard) {
        this.isprecard = isprecard;
    }

    public Short getHascanceltype() {
        return hascanceltype;
    }

    public void setHascanceltype(Short hascanceltype) {
        this.hascanceltype = hascanceltype;
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

    public Long getOptuserid() {
        return optuserid;
    }

    public void setOptuserid(Long optuserid) {
        this.optuserid = optuserid;
    }

    public Float getSaleFee() {
        return saleFee;
    }

    public void setSaleFee(Float saleFee) {
        this.saleFee = saleFee;
    }
}