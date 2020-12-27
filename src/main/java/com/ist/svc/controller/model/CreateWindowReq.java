package com.ist.svc.controller.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
public class CreateWindowReq extends BaseReq{
    @NotBlank(message = "userId不能为空")
    private String userId;
    @NotBlank(message = "tokenId不能为空")
    private String tokenId;
    private String loginName;
    @NotBlank(message = "shopId不能为空")
    private String shopId;
    @NotBlank(message = "shopName不能为空")
    private String shopName;
    @NotBlank(message = "shopAvatarUrl不能为空")
    private String shopAvatarUrl;
    @NotBlank(message = "talker不能为空")
    private String talker;
    @NotBlank(message = "nickName不能为空")
    private String nickName;
    @NotBlank(message = "avatarUrl不能为空")
    private String avatarUrl;
    @NotNull(message = "windowType不能为空")
    private Integer windowType;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
