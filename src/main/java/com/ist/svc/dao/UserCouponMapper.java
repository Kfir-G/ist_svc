package com.ist.svc.dao;

import com.ist.svc.domain.UserCoupon;
import com.ist.svc.domain.UserCouponExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserCouponMapper {
    long countByExample(UserCouponExample example);

    int deleteByExample(UserCouponExample example);

    int insert(UserCoupon record);

    int insertSelective(UserCoupon record);

    List<UserCoupon> selectByExample(UserCouponExample example);

    int updateByExampleSelective(@Param("record") UserCoupon record, @Param("example") UserCouponExample example);

    int updateByExample(@Param("record") UserCoupon record, @Param("example") UserCouponExample example);

    List<UserCoupon> selectByParams(Map<String, Object> params);
}