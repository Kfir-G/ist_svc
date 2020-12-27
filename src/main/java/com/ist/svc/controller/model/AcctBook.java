package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class AcctBook {
    private String transId;
    private String subAccountId;
    private String accountId;
    private Integer acctType;
    private Integer direct;
    private Integer payType;
    private Float money;
    private String orderId;
    private Integer status;
    private String createTime;
    private String updateTime;
    private Float balance;
    private String descr;
    private String otherOrder;
    private String otherAcct;

}
