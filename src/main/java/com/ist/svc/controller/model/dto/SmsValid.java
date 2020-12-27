package com.ist.svc.controller.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SmsValid {
    private String number;
    private String code;
    private Date validTime;
}
