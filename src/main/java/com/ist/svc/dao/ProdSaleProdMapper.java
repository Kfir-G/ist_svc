package com.ist.svc.dao;

import com.ist.svc.domain.ProdSaleProd;
import com.ist.svc.domain.ProdSaleProdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdSaleProdMapper {
    long countByExample(ProdSaleProdExample example);

    int deleteByExample(ProdSaleProdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProdSaleProd record);

    int insertSelective(ProdSaleProd record);

    List<ProdSaleProd> selectByExample(ProdSaleProdExample example);

    ProdSaleProd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProdSaleProd record, @Param("example") ProdSaleProdExample example);

    int updateByExample(@Param("record") ProdSaleProd record, @Param("example") ProdSaleProdExample example);

    int updateByPrimaryKeySelective(ProdSaleProd record);

    int updateByPrimaryKey(ProdSaleProd record);
}