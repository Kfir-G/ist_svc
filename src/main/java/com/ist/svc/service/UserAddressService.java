package com.ist.svc.service;

import com.ist.svc.domain.UserAddress;
import com.ist.svc.domain.UserAddressExample;

import java.util.List;
import java.util.Map;

/**
 * @Author: sunhaitao
 */
public interface UserAddressService {
    int addUserAddress(UserAddress userAddress);
    int updateUserAddress(UserAddress updateUserAddress);
    List<UserAddress> queryByExample(UserAddressExample example);
    List<com.ist.svc.controller.model.UserAddress> queryByParams(Map<String,Object> params);
}
