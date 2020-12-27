package com.ist.svc.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: sunhaitao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdInfo {
    private String prodId;  //产品id
    private float originalfee; //原价
    private float salefee;   //售价
    private Integer amount;  //库存数量
    private String spec; //规格
    private String name;  //商品名称
    private String onlineTime; //销售开始日期(yyyymmddhh24miss)
    private String offTime;  //销售截止日期(yyyymmddhh24miss)
    private String startTime; //服务开始日期
    private String shopId;
}
