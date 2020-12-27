package com.ist.svc.dao;

import com.ist.svc.domain.InfoCity;
import com.ist.svc.domain.InfoCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoCityMapper {
    long countByExample(InfoCityExample example);

    int deleteByExample(InfoCityExample example);

    int deleteByPrimaryKey(Short cityid);

    int insert(InfoCity record);

    int insertSelective(InfoCity record);

    List<InfoCity> selectByExample(InfoCityExample example);

    InfoCity selectByPrimaryKey(Short cityid);

    int updateByExampleSelective(@Param("record") InfoCity record, @Param("example") InfoCityExample example);

    int updateByExample(@Param("record") InfoCity record, @Param("example") InfoCityExample example);

    int updateByPrimaryKeySelective(InfoCity record);

    int updateByPrimaryKey(InfoCity record);
}