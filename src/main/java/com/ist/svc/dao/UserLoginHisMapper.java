package com.ist.svc.dao;

import com.ist.svc.domain.UserLoginHis;
import com.ist.svc.domain.UserLoginHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLoginHisMapper {
    long countByExample(UserLoginHisExample example);

    int deleteByExample(UserLoginHisExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserLoginHis record);

    int insertSelective(UserLoginHis record);

    List<UserLoginHis> selectByExample(UserLoginHisExample example);

    UserLoginHis selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserLoginHis record, @Param("example") UserLoginHisExample example);

    int updateByExample(@Param("record") UserLoginHis record, @Param("example") UserLoginHisExample example);

    int updateByPrimaryKeySelective(UserLoginHis record);

    int updateByPrimaryKey(UserLoginHis record);

    String selectClientIDByUserId(String userId);
}