package com.ist.svc.controller.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: sunhaitao
 */
@Data
public class GradeOrder {
    @NotBlank(message = "prodInfoId不能为空")
    private String prodInfoId;
    @NotBlank(message = "orderId不能为空")
    private String orderId;
    @NotBlank(message = "detailId不能为空")
    private String detailId;
    @NotBlank(message = "shopId不能为空")
    private String shopId;
    @NotBlank(message = "prodId不能为空")
    private String prodId;
    @NotNull(message = "anonym不能为空")
    private Integer anonym;
    @NotBlank(message = "nikeName不能为空")
    private String nikeName;
    @NotBlank(message = "name不能为空")
    private String name;
    @NotBlank(message = "startTime不能为空")
    private String startTime;
    @NotNull(message = "grade不能为空")
    private Integer grade;  //1好评 0中评 -1差评，  默认1
    @NotNull(message = "status不能为空")
    private Integer status;  //状态0 生效但不显示 1正常 2修改后  -1删除（修改评价备份） 默认1
    @NotNull(message = "type不能为空")
    private Integer type;  //1主动评价
    @NotNull(message = "zanNum不能为空")
    private Integer zanNum;  //点赞总量
    @NotBlank(message = "spec不能为空")
    private String spec;
    @NotBlank(message = "descr不能为空")
    private String descr;
    private List<String> imgs;
    private String video;
    private Integer descrGrade;
    private Integer deliveryGrade;
    private Integer serviceGrade;
}
