package com.ist.svc.domain;

import java.util.Date;
import java.util.List;

public class UserCoupon {
    private Long id;

    private Long userid;

    private Integer shopid;

    private Integer prodid;

    private Integer couponid;

    private Integer no;

    private Short status;

    private Date createtime;

    private Date endtime;

    private Date usertime;

    private Long orderid;

    //shopCoupon
    private Integer type;

    private Long conditionMoney;

    private Long money;
    private String shopname;
    private String couponname;
    private String descr;

    //ShopCouponProd
    List<ShopCouponProd> shopCouponProds;

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

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getUsertime() {
        return usertime;
    }

    public void setUsertime(Date usertime) {
        this.usertime = usertime;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getConditionMoney() {
        return conditionMoney;
    }

    public void setConditionMoney(Long conditionMoney) {
        this.conditionMoney = conditionMoney;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getShopName() {
        return shopname;
    }

    public void setShopName(String shopName) {
        this.shopname = shopName;
    }

    public String getCouponName() {
        return couponname;
    }

    public void setCouponName(String couponName) {
        this.couponname = couponName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getCouponname() {
        return couponname;
    }

    public void setCouponname(String couponname) {
        this.couponname = couponname;
    }

    public List<ShopCouponProd> getShopCouponProds() {
        return shopCouponProds;
    }

    public void setShopCouponProds(List<ShopCouponProd> shopCouponProds) {
        this.shopCouponProds = shopCouponProds;
    }
}