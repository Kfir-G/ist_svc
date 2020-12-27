package com.ist.svc.domain;

import java.util.Date;

public class Cart {
    private Long id;

    private Long userid;

    private Integer shopid;

    private Integer prodinfoid;

    private Integer prodid;

    private Float cartfee;

    private Short amount;

    private Short selected;

    private Date createtime;

    private Date updatetime;
    //Prod商品
    private String name;//商品name
    private String spec;//规格
    private Float saleFee;
    //Prod_info
    private String headImg;

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

    public Integer getProdinfoid() {
        return prodinfoid;
    }

    public void setProdinfoid(Integer prodinfoid) {
        this.prodinfoid = prodinfoid;
    }

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public Float getCartfee() {
        return cartfee;
    }

    public void setCartfee(Float cartfee) {
        this.cartfee = cartfee;
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    public Short getSelected() {
        return selected;
    }

    public void setSelected(Short selected) {
        this.selected = selected;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Float getSaleFee() {
        return saleFee;
    }

    public void setSaleFee(Float saleFee) {
        this.saleFee = saleFee;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}