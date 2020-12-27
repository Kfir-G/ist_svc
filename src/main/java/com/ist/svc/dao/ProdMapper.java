package com.ist.svc.dao;

import com.ist.svc.domain.Prod;
import com.ist.svc.domain.ProdExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProdMapper {
    long countByExample(ProdExample example);

    int deleteByExample(ProdExample example);

    int deleteByPrimaryKey(Integer prodid);

    int insert(Prod record);

    int insertSelective(Prod record);

    List<Prod> selectByExample(ProdExample example);

    Prod selectByPrimaryKey(Integer prodid);

    int updateByExampleSelective(@Param("record") Prod record, @Param("example") ProdExample example);

    int updateByExample(@Param("record") Prod record, @Param("example") ProdExample example);

    int updateByPrimaryKeySelective(Prod record);

    int updateByPrimaryKey(Prod record);

    List<Prod> selectByParams(Map<String, Object> params);
}