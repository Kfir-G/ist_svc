package com.ist.svc.domain;

public class ShopCouponProd {
    private Long id;

    private Integer couponid;

    private Integer prodinfoid;

    private Integer prodid;

    private String headimg;

    private String prodname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
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

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname == null ? null : prodname.trim();
    }
}