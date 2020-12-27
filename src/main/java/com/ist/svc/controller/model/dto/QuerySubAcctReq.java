package com.ist.svc.controller.model.dto;

import com.ist.svc.controller.model.BaseReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class QuerySubAcctReq extends BaseReq {
    @NotBlank(message = "用户(userId)不能为空")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    private String tokenId;
    private String loginName;
    @NotNull(message = "账户类型(acctType)不能为空")
    private Integer acctType;
    @NotBlank(message = "用户Id或商户Id为空(ownUserId)")
    private String ownUserId;
    @ApiModelProperty(value = "用户类型(userType)")
    private Integer userType;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
