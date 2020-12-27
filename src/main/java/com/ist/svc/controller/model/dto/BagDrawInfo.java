package com.ist.svc.controller.model.dto;

import lombok.Data;

@Data
public class BagDrawInfo {
    private Long drawUser;
    private Short status;
    private Float drawMoney;
    private String answer;
    private String createTime;
    private String updateTime;
}
