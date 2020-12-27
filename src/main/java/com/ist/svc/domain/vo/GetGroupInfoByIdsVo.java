package com.ist.svc.domain.vo;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class GetGroupInfoByIdsVo {
    private String groupId;
    private Integer status;
    private String createTime;
    private String updateTime;
    private String optUserId;
    private Integer joinGroup;
    private String groupName;
    private String avatarUrl;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
