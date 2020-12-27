package com.ist.svc.controller.model.dto;

import com.ist.svc.controller.model.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ApiModel(description = "创建红包请求对象")
public class CNewBagReq extends BaseReq {
    @NotBlank(message = "用户(userId)不能为空")
    @ApiModelProperty(value = "用户(userId)")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    @ApiModelProperty(value = "登陆令牌(tokenId)")
    private String tokenId;
    @NotBlank(message = "收包者(talker)不能为空")
    @ApiModelProperty(value = "收包者(talker)")
    private String talker;
    @NotNull(message = "红包类型(type)不能为空")
    @ApiModelProperty(value = "红包类型(type)")
    private Integer type;
    @ApiModelProperty(value = "单个金额(money)")
    private Float money;//单个金额
    @NotNull(message="个数(amount)不能为空")
    @ApiModelProperty(value = "个数(amount)")
    private Integer amount; //个数
    @NotNull(message="总金额(sumMoney)不能为空")
    @ApiModelProperty(value = "总金额(sumMoney)")
    private Float sumMoney;
    @NotNull(message = "获得方式(getType)不能为空")
    @ApiModelProperty(value = "获得方式(getType)")
    private Integer getType;
    @NotNull(message = "分配模式(allocateType)不能为空")
    @ApiModelProperty(value = "分配模式(allocateType)")
    private Integer allocateType;
    @NotNull(message = "未成功领取前可以领几次(onceType)不能为空")
    @ApiModelProperty(value = "未成功领取前可以领几次(onceType)")
    private Integer onceType;
    @ApiModelProperty(value = "题目id(subjectId)")
    private Long subjectId;
    @ApiModelProperty(value = "封面标题title(title)")
    private String title;
    @ApiModelProperty(value = "点击红包提示语tip(tip)")
    private String tip;
    @ApiModelProperty(value = "红包延迟发放时间(delayTime)")
    private String delayTime;
    @ApiModelProperty(value = "答案或者竞猜数")
    private String answer;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
