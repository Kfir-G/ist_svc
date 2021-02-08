package com.ist.svc.domain;

import java.util.Date;

public class GradeProc {
    private Long gradeid;

    private Long userid;

    private String nickname;

    private String name;

    private Long orderid;

    private Long detailid;

    private Integer shopid;

    private Long prodinfoid;

    private Integer prodid;

    private String spec;

    private Short status;

    private Short type;

    private Short grade;

    private Date createtime;

    private Date starttime;

    private String descr;

    private String imgs;

    private String video;

    private Short descrgrade;

    private Short deliverygrade;

    private Short servicegrade;

    private Date replytime;

    private String reply;

    private Date appendtime;

    private String appenddescr;

    private Short zannum;

    private Short anonym;

    public Long getGradeid() {
        return gradeid;
    }

    public void setGradeid(Long gradeid) {
        this.gradeid = gradeid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Long getProdinfoid() {
        return prodinfoid;
    }

    public void setProdinfoid(Long prodinfoid) {
        this.prodinfoid = prodinfoid;
    }

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
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

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public Short getDescrgrade() {
        return descrgrade;
    }

    public void setDescrgrade(Short descrgrade) {
        this.descrgrade = descrgrade;
    }

    public Short getDeliverygrade() {
        return deliverygrade;
    }

    public void setDeliverygrade(Short deliverygrade) {
        this.deliverygrade = deliverygrade;
    }

    public Short getServicegrade() {
        return servicegrade;
    }

    public void setServicegrade(Short servicegrade) {
        this.servicegrade = servicegrade;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public Date getAppendtime() {
        return appendtime;
    }

    public void setAppendtime(Date appendtime) {
        this.appendtime = appendtime;
    }

    public String getAppenddescr() {
        return appenddescr;
    }

    public void setAppenddescr(String appenddescr) {
        this.appenddescr = appenddescr == null ? null : appenddescr.trim();
    }

    public Short getZannum() {
        return zannum;
    }

    public void setZannum(Short zannum) {
        this.zannum = zannum;
    }

    public Short getAnonym() {
        return anonym;
    }

    public void setAnonym(Short anonym) {
        this.anonym = anonym;
    }
}