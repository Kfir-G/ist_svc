package com.ist.svc.config.kafka;

import lombok.Data;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Data
public class ChatMsg {
    private String receiverId;
    private Integer type;
    private List<MsgData> data;
}
