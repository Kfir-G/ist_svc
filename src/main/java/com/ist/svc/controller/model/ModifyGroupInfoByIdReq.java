package com.ist.svc.controller.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
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
public class ModifyGroupInfoByIdReq extends BaseReq{
    @NotBlank(message = "groupId不能为空")
    @ApiModelProperty(value = "分组id",required = true)
    private String groupId;
    @NotBlank(message = "tokenId不能为空")
    @ApiModelProperty(value = "tokenId",required = true)
    private String tokenId;
    @NotBlank(message = "userId不能为空")
    @ApiModelProperty(value = "userId",required = true)
    private String userId;
    @ApiModelProperty(value = "群状态")
    private Integer status;
    @ApiModelProperty(value = "群名称")
    private String name;
    @ApiModelProperty(value = "进群方式")
    private Integer joinGroup;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
