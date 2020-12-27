package com.ist.svc.dao;

import com.ist.svc.domain.ProdAdlist;
import com.ist.svc.domain.ProdAdlistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdAdlistMapper {
    long countByExample(ProdAdlistExample example);

    int deleteByExample(ProdAdlistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProdAdlist record);

    int insertSelective(ProdAdlist record);

    List<ProdAdlist> selectByExample(ProdAdlistExample example);

    ProdAdlist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProdAdlist record, @Param("example") ProdAdlistExample example);

    int updateByExample(@Param("record") ProdAdlist record, @Param("example") ProdAdlistExample example);

    int updateByPrimaryKeySelective(ProdAdlist record);

    int updateByPrimaryKey(ProdAdlist record);
}