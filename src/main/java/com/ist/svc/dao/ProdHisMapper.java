package com.ist.svc.dao;

import com.ist.svc.domain.ProdHis;
import com.ist.svc.domain.ProdHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdHisMapper {
    long countByExample(ProdHisExample example);

    int deleteByExample(ProdHisExample example);

    int deleteByPrimaryKey(Integer hisid);

    int insert(ProdHis record);

    int insertSelective(ProdHis record);

    List<ProdHis> selectByExample(ProdHisExample example);

    ProdHis selectByPrimaryKey(Integer hisid);

    int updateByExampleSelective(@Param("record") ProdHis record, @Param("example") ProdHisExample example);

    int updateByExample(@Param("record") ProdHis record, @Param("example") ProdHisExample example);

    int updateByPrimaryKeySelective(ProdHis record);

    int updateByPrimaryKey(ProdHis record);
}