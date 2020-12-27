package com.ist.svc.dao;

import com.ist.svc.domain.BagCheck;
import com.ist.svc.domain.BagCheckExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BagCheckMapper {
    long countByExample(BagCheckExample example);

    int deleteByExample(BagCheckExample example);

    int deleteByPrimaryKey(BigDecimal bagNo);

    int insert(BagCheck record);

    int insertSelective(BagCheck record);

    List<BagCheck> selectByExample(BagCheckExample example);

    BagCheck selectByPrimaryKey(BigDecimal bagNo);

    int updateByExampleSelective(@Param("record") BagCheck record, @Param("example") BagCheckExample example);

    int updateByExample(@Param("record") BagCheck record, @Param("example") BagCheckExample example);

    int updateByPrimaryKeySelective(BagCheck record);

    int updateByPrimaryKey(BagCheck record);
}