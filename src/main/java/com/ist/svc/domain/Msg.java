package com.ist.svc.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Msg {
    private Long timeid;

    private Long windowid;

    private Long no;

    private Short msgtype;

    private String content;

    private Short contentType;

    private Long sender;

    private Long talker;

    private String senderame;

    private Short status;

    private Date createtime;

    private Date updatetime;

    private Long shopId;

}