package com.ist.svc.dao;

import com.ist.svc.domain.InfoProdType;
import com.ist.svc.domain.InfoProdTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoProdTypeMapper {
    long countByExample(InfoProdTypeExample example);

    int deleteByExample(InfoProdTypeExample example);

    int deleteByPrimaryKey(Short prodtype);

    int insert(InfoProdType record);

    int insertSelective(InfoProdType record);

    List<InfoProdType> selectByExample(InfoProdTypeExample example);

    InfoProdType selectByPrimaryKey(Short prodtype);

    int updateByExampleSelective(@Param("record") InfoProdType record, @Param("example") InfoProdTypeExample example);

    int updateByExample(@Param("record") InfoProdType record, @Param("example") InfoProdTypeExample example);

    int updateByPrimaryKeySelective(InfoProdType record);

    int updateByPrimaryKey(InfoProdType record);
}