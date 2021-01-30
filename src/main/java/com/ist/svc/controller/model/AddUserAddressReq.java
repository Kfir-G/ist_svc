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
public class AddUserAddressReq extends BaseReq{
    @NotBlank(message = "用户(userId)不能为空")
    private String userId;
    @NotBlank(message = "登陆令牌(tokenId)不能为空")
    private String tokenId;
    private String loginName;
    @NotNull(message = "操作类型(optType)不能为空")
    private Integer optType;
    private String oldAddressId;
    @NotBlank(message = "姓名(name)不能为空")
    private String name;
    @NotBlank(message = "手机号(phone)不能为空")
    private String phone;
    @NotBlank(message = "区域id(areaId)不能为空")
    private String areaId;
    @NotBlank(message = "详情地址(address)不能为空")
    private String address;
    @NotNull(message = "是否是默认地址(isDefault)不能为空")
    private Integer isDefault;
    private Long orgId;
    private Integer type;
    private String v1;
    private String v2;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
