package com.ist.svc.controller.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "商品限制查询info对象")
public class SearchProdLimit {
    @ApiModelProperty(value = "商品限制id")
    private Integer prodLimitId;
    @ApiModelProperty(value = "行业类型id")
    private Short tradeTypeId;
    @ApiModelProperty(value = "行业类型id")
    private Short prodTypeId;
    @ApiModelProperty(value = "商铺id")
    private Integer shopId;
    @ApiModelProperty(value = "状态1:正常 2:失效")
    private Short status;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "说明")
    private String descr;
    @ApiModelProperty(value = "平台保管金额比例最低值")
    private Short safeKeepMin;
    @ApiModelProperty(value = "平台保管金额比例最高值")
    private Short safeKeepMax;
    @ApiModelProperty(value = "平台保管金额比例默认值（推荐值）需介于Safekeepmin和Safekeepmax之间。默认0， 百分百：40 表示交由平台保管40%支付费用，每次消费返还商家。")
    private Short safeKeep;
    @ApiModelProperty(value = "保证金给付商家 1.用户全部消费完 2.每次消费支付相应部分")
    private Short safeKeepArrive;
    @ApiModelProperty(value = "服务未开始退订类型")
    private Short cancelType;
    @ApiModelProperty(value = "未开始可退订时间")
    private Float cancelHours;
    @ApiModelProperty(value = "超过可退订时间退订规定")
    private Short overHoursCancelType;
    @ApiModelProperty(value = "扣除上限（超过或未超过可退时间）")
    private Short cancelFee;
    @ApiModelProperty(value = "已开始未过期退订类型")
    private Short beginCancelType;
    @ApiModelProperty(value = "过期未消费（完）退订类型")
    private Short endCancelType;
    @ApiModelProperty(value = "已开始未过期退订类型")
    private Float beginCancelFee;
    @ApiModelProperty(value = "过期未消费（完）退订类型")
    private Float endCancelFee;
    @ApiModelProperty(value = "转让类型")
    private Short transferType;
    @ApiModelProperty(value = "转让服务费类型")
    private Short transferFeeType;
    @ApiModelProperty(value = "转让服务费上限")
    private Float transferFee;
    @ApiModelProperty(value = "可转让次数")
    private Short transferNum;
    @ApiModelProperty(value = "转让加价率限制")
    private Float transferPrice;
    @ApiModelProperty(value = "分享")
    private Short shareType;
    @ApiModelProperty(value = "可分享人数")
    private Short shareNum;
    @ApiModelProperty(value = "创建时间yyyymmdd24hhmiss")
    private String createTime;
    @ApiModelProperty(value = "最后更新时间yyyymmdd24hhmiss")
    private String updateTime;
    @ApiModelProperty(value = "操作人userId")
    private Long optUserId;
}
