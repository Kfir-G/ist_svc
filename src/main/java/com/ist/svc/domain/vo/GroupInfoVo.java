package com.ist.svc.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class GroupInfoVo {
    private Long groupId;

    private Short status;

    private Date createTime;

    private Date updateTime;

    private Long optUserId;

    private Short joinGroup;

    private String groupName;

    private String avatarUrl;
}
