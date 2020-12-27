package com.ist.svc.dao;

import com.ist.svc.domain.ProdOtherInfo;
import com.ist.svc.domain.ProdOtherInfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProdOtherInfoMapper {
    long countByExample(ProdOtherInfoExample example);

    int deleteByExample(ProdOtherInfoExample example);

    int deleteByPrimaryKey(Integer prodinfoid);

    int insert(ProdOtherInfo record);

    int insertSelective(ProdOtherInfo record);

    List<ProdOtherInfo> selectByExample(ProdOtherInfoExample example);

    ProdOtherInfo selectByPrimaryKey(Integer prodinfoid);

    int updateByExampleSelective(@Param("record") ProdOtherInfo record, @Param("example") ProdOtherInfoExample example);

    int updateByExample(@Param("record") ProdOtherInfo record, @Param("example") ProdOtherInfoExample example);

    int updateByPrimaryKeySelective(ProdOtherInfo record);

    int updateByPrimaryKey(ProdOtherInfo record);

    List<ProdOtherInfo> selectByParams(Map<String, Object> params);
}