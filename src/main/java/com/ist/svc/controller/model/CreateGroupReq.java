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
public class CreateGroupReq extends BaseReq{
    @NotBlank(message = "optUserId不能为空")
    @ApiModelProperty(value = "操作人",required = true)
    private String optUserId;
    @ApiModelProperty(value = "组名",required = true)
    private String groupName;
    @ApiModelProperty(value = "进群方式")
    private Integer joinGroup;
    @ApiModelProperty(value = "头像地址方式")
    private String avatarUrl;
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
