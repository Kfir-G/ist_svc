package com.ist.svc.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "成员响应对象")
public class MemberVo {
    private String memberId;
    private String seq;
    private Integer status;
    private String talker;
    private String groupNickName;
    private String avatarUrl;
    private String createTime;
    private String updateTime;
    private String optUserId;
    private String inviteUserId;
    private Integer role;
    private String lockTime;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
