package com.ist.svc.controller.model.dto;

import com.ist.svc.controller.model.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;

@Getter
@ApiModel(description = "发送短信验证码请求对象")
public class SendValidSmsReq extends BaseReq {
    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号(phoneNum)不能为空")
    private String phoneNum;//手机号
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
