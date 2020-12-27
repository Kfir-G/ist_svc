package com.ist.svc.domain.vo;

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
public class GetGroupMemInfobyIdsVo {
    @ApiModelProperty(value = "groupId")
    private String groupId;
    private List<MemberVo> members;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
