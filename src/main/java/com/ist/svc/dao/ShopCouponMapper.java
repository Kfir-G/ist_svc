package com.ist.svc.dao;

import com.ist.svc.domain.ShopCoupon;
import com.ist.svc.domain.ShopCouponExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ShopCouponMapper {
    long countByExample(ShopCouponExample example);

    int deleteByExample(ShopCouponExample example);

    int deleteByPrimaryKey(Integer couponid);

    int insert(ShopCoupon record);

    int insertSelective(ShopCoupon record);

    List<ShopCoupon> selectByExample(ShopCouponExample example);

    ShopCoupon selectByPrimaryKey(Integer couponid);

    int updateByExampleSelective(@Param("record") ShopCoupon record, @Param("example") ShopCouponExample example);

    int updateByExample(@Param("record") ShopCoupon record, @Param("example") ShopCouponExample example);

    int updateByPrimaryKeySelective(ShopCoupon record);

    int updateByPrimaryKey(ShopCoupon record);

    List<ShopCoupon> selectByParams(Map<String,Object> params);
}