package com.ist.svc.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;

/**
 */
@Setter
@Getter
public class GetGroupMemInfobyIdsReq extends BaseReq{
    @NotBlank(message = "tokenId不能为空")
    @ApiModelProperty(value = "tokenId",required = true)
    private String tokenId;
    @NotBlank(message = "userId不能为空")
    @ApiModelProperty(value = "userId",required = true)
    private String userId;
    @ApiModelProperty(value = "groupIds")
    private String groupIds;
    @ApiModelProperty(value = "talkers",required = true)
    private String talkers;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
