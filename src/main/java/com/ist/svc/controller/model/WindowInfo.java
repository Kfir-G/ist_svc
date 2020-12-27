package com.ist.svc.controller.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Data
public class WindowInfo {
    private String windowId;
    private Integer type;
    private String shopId;
    private String shopName;
    private String shopAvatarUrl;
    private String talker;
    private String nickName;
    private String avatarUrl;
    private String createTime;//窗口创建时间
    List<WindowMsgData> msgs;
}
