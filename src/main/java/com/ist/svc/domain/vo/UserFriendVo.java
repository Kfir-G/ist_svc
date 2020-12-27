package com.ist.svc.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "好友响应对象")
public class UserFriendVo {
    @ApiModelProperty(value = "id")
    private long id;
    @ApiModelProperty(value = "用户id")
    private String userId;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "用户分组类型")
    private Integer groupType;
    @ApiModelProperty(value = "friendGroupId")
    private long friendGroupId;
    @ApiModelProperty(value = "fUserId")
    private String fUserId;
    @ApiModelProperty(value = "markName")
    private String markName;

}
