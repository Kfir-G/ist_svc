package com.ist.svc.controller.model;

import lombok.Data;

/**
 * @Author: sunhaitao
 */
@Data
public class WindowMsgData {
    private String msgId;
    private String windowId;
    private Integer msgType;
    private String content;
    private String sender;
    private String senderName;
    private String createTime;
    private String updateTime;
    private Integer status;
}
