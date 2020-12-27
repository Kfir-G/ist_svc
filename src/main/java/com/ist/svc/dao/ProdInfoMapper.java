package com.ist.svc.dao;

import com.ist.svc.domain.ProdInfo;
import com.ist.svc.domain.ProdInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdInfoMapper {
    long countByExample(ProdInfoExample example);

    int deleteByExample(ProdInfoExample example);

    int deleteByPrimaryKey(Integer prodinfoid);

    int insert(ProdInfo record);

    int insertSelective(ProdInfo record);

    List<ProdInfo> selectByExample(ProdInfoExample example);

    ProdInfo selectByPrimaryKey(Integer prodinfoid);

    int updateByExampleSelective(@Param("record") ProdInfo record, @Param("example") ProdInfoExample example);

    int updateByExample(@Param("record") ProdInfo record, @Param("example") ProdInfoExample example);

    int updateByPrimaryKeySelective(ProdInfo record);

    int updateByPrimaryKey(ProdInfo record);
}