package com.ist.svc.controller.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Data
public class ProdGrade {
    private String prodInfoId;
    private String gradeId;
    private String userId;
    private String orderId;
    private String detailId;
    private String shopId;
    private String prodId;
    private Integer anonym;
    private String nikeName;
    private String name;
    private String createTime;
    private String startTime;
    private Integer grade;
    private String spec;
    private String descr;
    private List<String> imgs;
    private String video;
    private String reply;
    private String replyTime;
    private String appendTime;
    private String appendDescr;
    private Integer zanNum;
}
