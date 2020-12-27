package com.ist.svc.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class ModifyGroupMemInfobyIdReq extends BaseReq{
    @NotBlank(message = "tokenId不能为空")
    @ApiModelProperty(value = "tokenId",required = true)
    private String tokenId;
    @NotBlank(message = "userId不能为空")
    @ApiModelProperty(value = "userId",required = true)
    private String userId;
    @NotBlank(message = "memberId不能为空")
    @ApiModelProperty(value = "memberId",required = true)
    private String memberId;
    @ApiModelProperty(value = "role",notes = "1成员，2管理员")
    private Integer role;
    @ApiModelProperty(value = "groupNickName",notes = "昵称")
    private String groupNickName;
    @ApiModelProperty(value = "status")
    private Integer status;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
