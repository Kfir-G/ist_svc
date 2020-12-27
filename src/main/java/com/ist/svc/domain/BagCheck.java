package com.ist.svc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BagCheck {
    private BigDecimal bagNo;

    private Float money;

    private Short result;

    private Float drawMoney;

    private Short amount;

    private Float backMoney;

    private Date createtime;

    private Date updatetime;

    public BigDecimal getBagNo() {
        return bagNo;
    }

    public void setBagNo(BigDecimal bagNo) {
        this.bagNo = bagNo;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Short getResult() {
        return result;
    }

    public void setResult(Short result) {
        this.result = result;
    }

    public Float getDrawMoney() {
        return drawMoney;
    }

    public void setDrawMoney(Float drawMoney) {
        this.drawMoney = drawMoney;
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    public Float getBackMoney() {
        return backMoney;
    }

    public void setBackMoney(Float backMoney) {
        this.backMoney = backMoney;
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