package com.ist.svc.controller.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: sunhaitao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRegisterResp extends BaseResp{
    private String userId;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
