package com.ist.svc.controller.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class DrawBagInfo {
    private BigDecimal bagNo;
    private Short status;
    private float blanceAmount;
    private float blanceMoney;
}
