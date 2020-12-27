package com.ist.svc.dao;

import com.ist.svc.domain.ProdSummary;
import com.ist.svc.domain.ProdSummaryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProdSummaryMapper {
    long countByExample(ProdSummaryExample example);

    int deleteByExample(ProdSummaryExample example);

    int deleteByPrimaryKey(Integer prodid);

    int insert(ProdSummary record);

    int insertSelective(ProdSummary record);

    List<ProdSummary> selectByExample(ProdSummaryExample example);

    ProdSummary selectByPrimaryKey(Integer prodid);

    int updateByExampleSelective(@Param("record") ProdSummary record, @Param("example") ProdSummaryExample example);

    int updateByExample(@Param("record") ProdSummary record, @Param("example") ProdSummaryExample example);

    int updateByPrimaryKeySelective(ProdSummary record);

    int updateByPrimaryKey(ProdSummary record);

    List<ProdSummary> selectByParams(Map<String, Object> params);
}