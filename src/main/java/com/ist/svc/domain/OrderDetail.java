package com.ist.svc.domain;

import java.util.Date;

public class OrderDetail {
    private Long detailid;

    private Long orderid;

    private Long userid;

    private Integer shopid;

    private Integer prodinfoid;

    private Integer prodid;

    private String name;

    private String headimg;

    private String spec;

    private Short status;

    private Float salefee;

    private Integer amount;

    private Float sumfee;

    private Integer discountid;

    private Float discountfee;

    private Integer couponid;

    private Float couponfee;

    private Float fee;

    private Float freightfee;

    private Short delivery;

    private String deliveryno;

    private Float payfee;

    private String descr;

    private Short safekeep;

    private Float safekeepmoney;

    private Long transferorderid;

    private Date createtime;

    private Date updatetime;

    private Date reservetime;

    private Date usetime;

    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Float getSalefee() {
        return salefee;
    }

    public void setSalefee(Float salefee) {
        this.salefee = salefee;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getSumfee() {
        return sumfee;
    }

    public void setSumfee(Float sumfee) {
        this.sumfee = sumfee;
    }

    public Integer getDiscountid() {
        return discountid;
    }

    public void setDiscountid(Integer discountid) {
        this.discountid = discountid;
    }

    public Float getDiscountfee() {
        return discountfee;
    }

    public void setDiscountfee(Float discountfee) {
        this.discountfee = discountfee;
    }

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public Float getCouponfee() {
        return couponfee;
    }

    public void setCouponfee(Float couponfee) {
        this.couponfee = couponfee;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Float getFreightfee() {
        return freightfee;
    }

    public void setFreightfee(Float freightfee) {
        this.freightfee = freightfee;
    }

    public Short getDelivery() {
        return delivery;
    }

    public void setDelivery(Short delivery) {
        this.delivery = delivery;
    }

    public String getDeliveryno() {
        return deliveryno;
    }

    public void setDeliveryno(String deliveryno) {
        this.deliveryno = deliveryno == null ? null : deliveryno.trim();
    }

    public Float getPayfee() {
        return payfee;
    }

    public void setPayfee(Float payfee) {
        this.payfee = payfee;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Short getSafekeep() {
        return safekeep;
    }

    public void setSafekeep(Short safekeep) {
        this.safekeep = safekeep;
    }

    public Float getSafekeepmoney() {
        return safekeepmoney;
    }

    public void setSafekeepmoney(Float safekeepmoney) {
        this.safekeepmoney = safekeepmoney;
    }

    public Long getTransferorderid() {
        return transferorderid;
    }

    public void setTransferorderid(Long transferorderid) {
        this.transferorderid = transferorderid;
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

    public Date getReservetime() {
        return reservetime;
    }

    public void setReservetime(Date reservetime) {
        this.reservetime = reservetime;
    }

    public Date getUsetime() {
        return usetime;
    }

    public void setUsetime(Date usetime) {
        this.usetime = usetime;
    }
}