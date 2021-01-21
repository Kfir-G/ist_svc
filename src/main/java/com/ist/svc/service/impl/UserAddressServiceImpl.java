package com.ist.svc.service.impl;

import com.ist.svc.config.IstEnum;
import com.ist.svc.dao.UserAddressMapper;
import com.ist.svc.domain.UserAddress;
import com.ist.svc.domain.UserAddressExample;
import com.ist.svc.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: sunhaitao
 */
@Service(value = "userAddressService")
public class UserAddressServiceImpl extends BaseServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int addUserAddress(UserAddress userAddress) {
        if (userAddress.getIsdefault()== IstEnum.QueryUserAddressIsDefault.IS_DEFAULT.getType().intValue()){
            UserAddressExample example = new UserAddressExample();
            UserAddressExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo(IstEnum.UserAddressStatus.NORMAL.getStatus());
            criteria.andUseridEqualTo(userAddress.getUserid());
            criteria.andIsdefaultEqualTo(userAddress.getIsdefault());
            List<UserAddress> userAddresses = this.queryByExample(example);
            for(UserAddress address: userAddresses){
                UserAddress updateUserAddess = new UserAddress();
                updateUserAddess.setAddressid(address.getAddressid());
                updateUserAddess.setIsdefault(IstEnum.QueryUserAddressIsDefault.NOT_DEFAULT.getType());
                this.updateUserAddress(updateUserAddess);
            }
        }
        return userAddressMapper.insertSelective(userAddress);
    }

    @Override
    public int updateUserAddress(UserAddress updateUserAddress) {
        return userAddressMapper.updateByPrimaryKeySelective(updateUserAddress);
    }

    @Override
    public List<UserAddress> queryByExample(UserAddressExample example) {
        return userAddressMapper.selectByExample(example);
    }

    @Override
    public List<com.ist.svc.controller.model.UserAddress> queryByParams(Map<String, Object> params) {
        List<com.ist.svc.controller.model.UserAddress> list = new ArrayList<>();
        List<UserAddress> userAddresses = userAddressMapper.queryByParams(params);
        for (UserAddress userAddress :userAddresses){
            com.ist.svc.controller.model.UserAddress uAddress = new com.ist.svc.controller.model.UserAddress();
            uAddress.setAddress(userAddress.getAddress());
            uAddress.setAreaId(userAddress.getAreaid());
            uAddress.setIsDefault(userAddress.getIsdefault().intValue());
            uAddress.setName(userAddress.getName());
            uAddress.setAddressId(userAddress.getAddressid().toString());
            uAddress.setPhone(userAddress.getPhone());
            uAddress.setProvince(userAddress.getProvince());
            uAddress.setCity(userAddress.getCity());
            uAddress.setArea(userAddress.getArea());
            uAddress.setPicker(userAddress.getPicker());
            uAddress.setUserId(userAddress.getUserid().toString());
            list.add(uAddress);
        }
        return list;
    }
}
