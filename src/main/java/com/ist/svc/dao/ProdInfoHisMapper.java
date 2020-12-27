package com.ist.svc.dao;

import com.ist.svc.domain.ProdInfoHis;
import com.ist.svc.domain.ProdInfoHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdInfoHisMapper {
    long countByExample(ProdInfoHisExample example);

    int deleteByExample(ProdInfoHisExample example);

    int deleteByPrimaryKey(Integer hisid);

    int insert(ProdInfoHis record);

    int insertSelective(ProdInfoHis record);

    List<ProdInfoHis> selectByExample(ProdInfoHisExample example);

    ProdInfoHis selectByPrimaryKey(Integer hisid);

    int updateByExampleSelective(@Param("record") ProdInfoHis record, @Param("example") ProdInfoHisExample example);

    int updateByExample(@Param("record") ProdInfoHis record, @Param("example") ProdInfoHisExample example);

    int updateByPrimaryKeySelective(ProdInfoHis record);

    int updateByPrimaryKey(ProdInfoHis record);
}