package com.ist.svc.dao;

import com.ist.svc.domain.InfoOrg;
import com.ist.svc.domain.InfoOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoOrgMapper {
    long countByExample(InfoOrgExample example);

    int deleteByExample(InfoOrgExample example);

    int deleteByPrimaryKey(Integer orgid);

    int insert(InfoOrg record);

    int insertSelective(InfoOrg record);

    List<InfoOrg> selectByExample(InfoOrgExample example);

    InfoOrg selectByPrimaryKey(Integer orgid);

    int updateByExampleSelective(@Param("record") InfoOrg record, @Param("example") InfoOrgExample example);

    int updateByExample(@Param("record") InfoOrg record, @Param("example") InfoOrgExample example);

    int updateByPrimaryKeySelective(InfoOrg record);

    int updateByPrimaryKey(InfoOrg record);
}