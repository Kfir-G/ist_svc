package com.ist.svc.controller.model.dto;
import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "商品限制查询请求对象")
public class SearchProdLimitReq extends FBaseReq {
    @NotBlank(message = "用户(userId)不能为空")
    @ApiModelProperty(value = "用户唯一userId")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    @ApiModelProperty(value = "登陆tokenId")
    private String tokenId;
    @ApiModelProperty(value = "登录账号")
    private String loginName;
    @ApiModelProperty(value = "产品限制id")
    private String prodLimitIds;  //产品限制id
    @ApiModelProperty(value = "行业分类id")
    private String tradeTypeId;   //行业分类id
    @ApiModelProperty(value = "产品类别id")
    private String prodTypeId;    //产品类别id
    @ApiModelProperty(value = "商店id")
    private String shopId;         //商店id
    @ApiModelProperty(value = "商店状态")
    private Integer status;        //商品状态
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
