package com.ist.svc.controller.model;

import lombok.Data;

/**
 * @Author: sunhaitao
 */
@Data
public class CartProdData {
    private String prodId;
    private String userId;
    private String id;
    private String prodInfoId;
    private String shopId;
    private String headImg;
    private String name;
    private Float saleFee;
    private String spec;
    private Integer amount;
    private Float cartFee;
    private Integer selected;
    private String createTime;
    private String updateTime;
}
