package com.ist.svc.controller.model.dto;

import com.ist.svc.controller.model.BaseResp;
import com.ist.svc.domain.vo.GroupInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@ApiModel(description = "查询用户群组响应")
public class GetGroupsByUserIdResp extends BaseResp {
    @ApiModelProperty(value = "返回详情")
    private List<GroupInfoVo> data;
}
