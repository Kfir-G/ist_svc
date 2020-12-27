package com.ist.svc.controller.model;

import lombok.Data;

/**
 * @Author: sunhaitao
 */
@Data
public class ManagerInfo {
    private Integer owner;
    private Integer cs;
    private String nickName;
    private String userId;
    private Integer status;
    private String job;        //职务说明
    private String cancelTime; //退出时间
    private String shopId;
    private Integer jobType; //职务类型
}
