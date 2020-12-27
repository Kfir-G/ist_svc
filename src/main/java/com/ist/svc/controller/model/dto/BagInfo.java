package com.ist.svc.controller.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BagInfo {
    private BigDecimal bagNo;
    private String talker;
    private String userId;
    private Integer type;
    private Integer status;
    private String createTime;
    private String updateTime;
    private Float sumMoney;
    private Integer amount;
    private Float money;
    private Integer getType;
    private Integer allocateType;
    private Integer onceType;
    private Long subjectId;
    private String title;
    private String tip;
    private String answer;
}
