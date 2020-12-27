package com.ist.svc.dao;

import com.ist.svc.domain.UserPasswd;
import com.ist.svc.domain.UserPasswdExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserPasswdMapper {
    long countByExample(UserPasswdExample example);

    int deleteByExample(UserPasswdExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserPasswd record);

    int insertSelective(UserPasswd record);

    List<UserPasswd> selectByExample(UserPasswdExample example);

    UserPasswd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserPasswd record, @Param("example") UserPasswdExample example);

    int updateByExample(@Param("record") UserPasswd record, @Param("example") UserPasswdExample example);

    int updateByPrimaryKeySelective(UserPasswd record);

    int updateByPrimaryKey(UserPasswd record);

    UserPasswd selectByParams(Map<String,Object> params);

    List<UserPasswd> selectsByParams(Map<String, Object> params);
}