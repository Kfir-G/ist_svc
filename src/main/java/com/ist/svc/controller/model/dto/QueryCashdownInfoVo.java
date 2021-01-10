package com.ist.svc.controller.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class QueryCashdownInfoVo {
    private Long ownUserId;

    private Short type;

    private String name;

    private String cashNo;

    private Float sumMoney;

    private Float rate;

    private Float freeMoney;

    private Short status;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
