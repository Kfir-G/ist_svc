package com.ist.svc.controller.model.dto;

import com.ist.svc.controller.model.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: sunhaitao
 */
@Data
@ApiModel(description = "添加组织请求对象")
public class QueryInfoOrgDto extends BaseReq {
    @NotBlank(message = "用户(userId)不能为空")
    @ApiModelProperty(value = "用户(userId)")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    @ApiModelProperty(value = "登陆令牌(tokenId)")
    private String tokenId;
    @ApiModelProperty(value = "orgId")
    private Long orgId;
    @NotNull(message = "区id不能为空")
    @ApiModelProperty(value = "区id")
    private Long areaId;
    @ApiModelProperty(value = "乡id")
    private Long townId;
    @ApiModelProperty(value = "组织id")
    private Long villageId;
    @ApiModelProperty(value = "组织名称")
    private String orgName;
    @ApiModelProperty(value = "别名")
    private String oldName;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
