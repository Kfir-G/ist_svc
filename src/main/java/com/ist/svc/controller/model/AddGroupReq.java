package com.ist.svc.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class AddGroupReq extends BaseReq{
    @NotBlank(message = "群主id(groupId)不能为空")
    @ApiModelProperty(value = "群主id",required = true)
    private String groupId;
    @NotBlank(message = "被邀请者(talkers,支持多个)为空")
    @ApiModelProperty(value = "被邀请者",required = true)
    private String talkers;
    @NotBlank(message = "邀请者(inviteUserId)为空")
    @ApiModelProperty(value = "邀请者",required = true)
    private String inviteUserId;
    private Short role;
    @NotBlank(message = "用户(userId)不能为空")
    @ApiModelProperty(value = "用户(userId)")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    @ApiModelProperty(value = "登陆令牌(tokenId)")
    private String tokenId;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
