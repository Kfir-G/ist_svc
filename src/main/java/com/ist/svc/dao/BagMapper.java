package com.ist.svc.dao;

import com.ist.svc.domain.Bag;
import com.ist.svc.domain.BagExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BagMapper {
    long countByExample(BagExample example);

    int deleteByExample(BagExample example);

    int deleteByPrimaryKey(BigDecimal bagNo);

    int insert(Bag record);

    int insertSelective(Bag record);

    List<Bag> selectByExample(BagExample example);

    Bag selectByPrimaryKey(BigDecimal bagNo);

    int updateByExampleSelective(@Param("record") Bag record, @Param("example") BagExample example);

    int updateByExample(@Param("record") Bag record, @Param("example") BagExample example);

    int updateByPrimaryKeySelective(Bag record);

    int updateByPrimaryKey(Bag record);
}