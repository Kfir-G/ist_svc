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
public class SendMsgReq extends BaseReq{
    @NotBlank(message = "userId不能为空")
    private String userId;
    @NotBlank(message = "tokenId不能为空")
    private String tokenId;
    private String loginName;
    @NotBlank(message = "shopId不能为空")
    private String shopId;
    @NotBlank(message = "talker不能为空")
    private String talker;
    @NotBlank(message = "windowId不能为空")
    private String windowId;
    @NotBlank(message = "sender不能为空")
    private String sender;
    @NotBlank(message = "senderName不能为空")
    private String senderName;
    @NotNull(message = "msgType不能为空")
    private Integer msgType;
    private Integer windowType;
    @NotBlank(message = "context不能为空")
    private String content;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
