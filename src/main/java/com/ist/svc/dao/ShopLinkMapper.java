package com.ist.svc.dao;

import com.ist.svc.domain.ShopLink;
import com.ist.svc.domain.ShopLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopLinkMapper {
    long countByExample(ShopLinkExample example);

    int deleteByExample(ShopLinkExample example);

    int deleteByPrimaryKey(Integer shopid);

    int insert(ShopLink record);

    int insertSelective(ShopLink record);

    List<ShopLink> selectByExample(ShopLinkExample example);

    ShopLink selectByPrimaryKey(Integer shopid);

    int updateByExampleSelective(@Param("record") ShopLink record, @Param("example") ShopLinkExample example);

    int updateByExample(@Param("record") ShopLink record, @Param("example") ShopLinkExample example);

    int updateByPrimaryKeySelective(ShopLink record);

    int updateByPrimaryKey(ShopLink record);
}