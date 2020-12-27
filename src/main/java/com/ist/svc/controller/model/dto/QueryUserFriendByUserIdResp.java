package com.ist.svc.controller.model.dto;

import com.ist.svc.domain.vo.UserFriendVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "查询好友响应")
public class QueryUserFriendByUserIdResp {
    @ApiModelProperty(value = "返回码")
    private String code;
    @ApiModelProperty(value = "返回描述")
    private String msg;
    @ApiModelProperty(value = "返回详情")
    private List<UserFriendVo> data;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
