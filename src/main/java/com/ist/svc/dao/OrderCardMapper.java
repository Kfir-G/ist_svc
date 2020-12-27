package com.ist.svc.dao;

import com.ist.svc.domain.OrderCard;
import com.ist.svc.domain.OrderCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCardMapper {
    long countByExample(OrderCardExample example);

    int deleteByExample(OrderCardExample example);

    int deleteByPrimaryKey(Long orderid);

    int insert(OrderCard record);

    int insertSelective(OrderCard record);

    List<OrderCard> selectByExample(OrderCardExample example);

    OrderCard selectByPrimaryKey(Long orderid);

    int updateByExampleSelective(@Param("record") OrderCard record, @Param("example") OrderCardExample example);

    int updateByExample(@Param("record") OrderCard record, @Param("example") OrderCardExample example);

    int updateByPrimaryKeySelective(OrderCard record);

    int updateByPrimaryKey(OrderCard record);
}