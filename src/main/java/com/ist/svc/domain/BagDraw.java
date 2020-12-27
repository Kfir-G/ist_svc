package com.ist.svc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BagDraw implements Serializable {
    private Long id;

    private BigDecimal bagNo;

    private Long drawUser;

    private Short status;

    private Short blanceAmount;

    private Float blanceMoney;

    private Float drawMoney;

    private String answer;

    private Date createtime;

    private Date updatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBagNo() {
        return bagNo;
    }

    public void setBagNo(BigDecimal bagNo) {
        this.bagNo = bagNo;
    }

    public Long getDrawUser() {
        return drawUser;
    }

    public void setDrawUser(Long drawUser) {
        this.drawUser = drawUser;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getBlanceAmount() {
        return blanceAmount;
    }

    public void setBlanceAmount(Short blanceAmount) {
        this.blanceAmount = blanceAmount;
    }

    public Float getBlanceMoney() {
        return blanceMoney;
    }

    public void setBlanceMoney(Float blanceMoney) {
        this.blanceMoney = blanceMoney;
    }

    public Float getDrawMoney() {
        return drawMoney;
    }

    public void setDrawMoney(Float drawMoney) {
        this.drawMoney = drawMoney;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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
}