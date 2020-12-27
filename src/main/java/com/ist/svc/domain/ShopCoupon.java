package com.ist.svc.domain;

import java.util.Date;
import java.util.List;

public class ShopCoupon {
    private Integer couponid;

    private Integer shopid;

    private Short status;

    private Short allprod;

    private Short type;

    private Float conditionmoney;

    private Float money;

    private Integer amount;

    private Integer take;

    private Date onlinetime;

    private Date offtime;

    private Date starttime;

    private Date endtime;

    private Date createtime;

    private Date updatetime;

    private String shopname;

    private String couponname;

    private String descr;

    private Long userid;

    List<ShopCouponProd> shopCouponProds;

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getAllprod() {
        return allprod;
    }

    public void setAllprod(Short allprod) {
        this.allprod = allprod;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Float getConditionmoney() {
        return conditionmoney;
    }

    public void setConditionmoney(Float conditionmoney) {
        this.conditionmoney = conditionmoney;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTake() {
        return take;
    }

    public void setTake(Integer take) {
        this.take = take;
    }

    public Date getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(Date onlinetime) {
        this.onlinetime = onlinetime;
    }

    public Date getOfftime() {
        return offtime;
    }

    public void setOfftime(Date offtime) {
        this.offtime = offtime;
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

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getCouponname() {
        return couponname;
    }

    public void setCouponname(String couponname) {
        this.couponname = couponname == null ? null : couponname.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public List<ShopCouponProd> getShopCouponProds() {
        return shopCouponProds;
    }

    public void setShopCouponProds(List<ShopCouponProd> shopCouponProds) {
        this.shopCouponProds = shopCouponProds;
    }
}