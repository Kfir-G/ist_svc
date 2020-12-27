package com.ist.svc.dao;

import com.ist.svc.domain.ProdLimit;
import com.ist.svc.domain.ProdLimitExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProdLimitMapper {
    long countByExample(ProdLimitExample example);

    int deleteByExample(ProdLimitExample example);

    int deleteByPrimaryKey(Integer prodlimitid);

    int insert(ProdLimit record);

    int insertSelective(ProdLimit record);

    List<ProdLimit> selectByExample(ProdLimitExample example);

    ProdLimit selectByPrimaryKey(Integer prodlimitid);

    int updateByExampleSelective(@Param("record") ProdLimit record, @Param("example") ProdLimitExample example);

    int updateByExample(@Param("record") ProdLimit record, @Param("example") ProdLimitExample example);

    int updateByPrimaryKeySelective(ProdLimit record);

    int updateByPrimaryKey(ProdLimit record);

    List<ProdLimit> selectProdLimits(Map<String, Object> params);
}