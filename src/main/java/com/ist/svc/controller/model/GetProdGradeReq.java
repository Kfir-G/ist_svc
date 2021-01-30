package com.ist.svc.controller.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: sunhaitao
 */
@Data
public class GetProdGradeReq {
//    @NotBlank(message = "prodInfoId不能为空")
    private String prodInfoId;
    private String userId;
    private String orderId;
    private String gradeId;
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;
    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;
    private Integer grade;
    private String startTime;
    private String endTime;
//    @NotNull(message = "isHaveImg不为空")
    private Integer isHaveImg;//是否带图片
//    @NotNull(message = "isHaveVideo不为空")
    private Integer isHaveVideo;
//    @NotNull(message = "isHaveAppendDescr不为空")
    private Integer isHaveAppendDescr;
}
