package com.ist.svc.dao;

import com.ist.svc.domain.ShopCouponProd;
import com.ist.svc.domain.ShopCouponProdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCouponProdMapper {
    long countByExample(ShopCouponProdExample example);

    int deleteByExample(ShopCouponProdExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopCouponProd record);

    int insertSelective(ShopCouponProd record);

    List<ShopCouponProd> selectByExample(ShopCouponProdExample example);

    ShopCouponProd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopCouponProd record, @Param("example") ShopCouponProdExample example);

    int updateByExample(@Param("record") ShopCouponProd record, @Param("example") ShopCouponProdExample example);

    int updateByPrimaryKeySelective(ShopCouponProd record);

    int updateByPrimaryKey(ShopCouponProd record);
}