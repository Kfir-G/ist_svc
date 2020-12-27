package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class QueryWindowsData {
    private String windowId;
    private String createTime;
    private Integer type;
    private Integer shopId;
    private String shopName;
    private String shopAvatarUrl;
    private String talker;
    private String nickName;
    private String avatarUrl;
}
