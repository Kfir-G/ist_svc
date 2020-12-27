package com.ist.svc.dao;

import com.ist.svc.domain.InfoArea;
import com.ist.svc.domain.InfoAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoAreaMapper {
    long countByExample(InfoAreaExample example);

    int deleteByExample(InfoAreaExample example);

    int deleteByPrimaryKey(Short areaid);

    int insert(InfoArea record);

    int insertSelective(InfoArea record);

    List<InfoArea> selectByExample(InfoAreaExample example);

    InfoArea selectByPrimaryKey(Short areaid);

    int updateByExampleSelective(@Param("record") InfoArea record, @Param("example") InfoAreaExample example);

    int updateByExample(@Param("record") InfoArea record, @Param("example") InfoAreaExample example);

    int updateByPrimaryKeySelective(InfoArea record);

    int updateByPrimaryKey(InfoArea record);
}