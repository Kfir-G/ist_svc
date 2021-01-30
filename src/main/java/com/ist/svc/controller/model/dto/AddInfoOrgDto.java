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
public class AddInfoOrgDto extends BaseReq {
    @NotBlank(message = "用户(userId)不能为空")
    @ApiModelProperty(value = "用户(userId)")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    @ApiModelProperty(value = "登陆令牌(tokenId)")
    private String tokenId;
    @NotNull(message = "省份id不能为空")
    @ApiModelProperty(value = "省份id",required=true)
    private Long provinceId;
    @ApiModelProperty(value = "省份",required=true)
    @NotBlank(message = "省份不能为空")
    private String province;
    @ApiModelProperty(value = "城市id",required=true)
    @NotNull(message = "城市id不能为空")
    private Long cityId;
    @ApiModelProperty(value = "城市",required=true)
    @NotBlank(message = "城市不能为空")
    private String city;
    @ApiModelProperty(value = "区")
    private String area;
    @ApiModelProperty(value = "区id")
    private Long areaId;
    @ApiModelProperty(value = "乡")
    private String town;
    @ApiModelProperty(value = "乡id")
    private Long townId;
    @ApiModelProperty(value = "组织id")
    private Long villageId;
    @ApiModelProperty(value = "组织")
    private String village;
    @ApiModelProperty(value = "是否乡村组织",notes = "1:是",required=true,example = "1:是")
    @NotNull(message = "是否乡村组织")
    private Integer isTownVilla;
    @ApiModelProperty(value = "组织名称")
    private String orgName;
    @ApiModelProperty(value = "别名")
    private String oldName;
    @ApiModelProperty(value = "描述")
    private String descr;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
