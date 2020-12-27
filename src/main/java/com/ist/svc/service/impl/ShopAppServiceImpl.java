package com.ist.svc.service.impl;

import com.ist.svc.dao.ShopAppMapper;
import com.ist.svc.domain.ShopApp;
import com.ist.svc.domain.ShopAppExample;
import com.ist.svc.service.ShopAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Service(value = "shopAppService")
public class ShopAppServiceImpl extends BaseServiceImpl implements ShopAppService{
    @Autowired
    private ShopAppMapper shopAppMapper;

    @Override
    public ShopApp queryShopApp(String appId) {
        ShopAppExample example = new ShopAppExample();
        ShopAppExample.Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appId);
        List<ShopApp> shopApps = shopAppMapper.selectByExample(example);
        if (shopApps!=null && shopApps.size()>0){
            return shopApps.get(0);
        }
        return null;
    }
}
