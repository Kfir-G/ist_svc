package com.ist.svc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Bag implements Serializable {
    private BigDecimal bagNo;

    private Short type;

    private Short status;

    private String transid;

    private Short getType;

    private Short allocateType;

    private Short onceType;

    private Long talker;

    private Long userid;

    private Short amount;

    private Float money;

    private Date createtime;

    private Date updatetime;

    private Integer subjectId;

    private Float sumMoney;

    private String title;

    private String tip;

    private Date delayTime;

    private String answer;

    public BigDecimal getBagNo() {
        return bagNo;
    }

    public void setBagNo(BigDecimal bagNo) {
        this.bagNo = bagNo;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid == null ? null : transid.trim();
    }

    public Short getGetType() {
        return getType;
    }

    public void setGetType(Short getType) {
        this.getType = getType;
    }

    public Short getAllocateType() {
        return allocateType;
    }

    public void setAllocateType(Short allocateType) {
        this.allocateType = allocateType;
    }

    public Short getOnceType() {
        return onceType;
    }

    public void setOnceType(Short onceType) {
        this.onceType = onceType;
    }

    public Long getTalker() {
        return talker;
    }

    public void setTalker(Long talker) {
        this.talker = talker;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Float getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Float sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }

    public Date getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Date delayTime) {
        this.delayTime = delayTime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}