package com.ist.svc.dao;

import com.ist.svc.domain.UserAlert;
import com.ist.svc.domain.UserAlertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAlertMapper {
    long countByExample(UserAlertExample example);

    int deleteByExample(UserAlertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAlert record);

    int insertSelective(UserAlert record);

    List<UserAlert> selectByExample(UserAlertExample example);

    UserAlert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAlert record, @Param("example") UserAlertExample example);

    int updateByExample(@Param("record") UserAlert record, @Param("example") UserAlertExample example);

    int updateByPrimaryKeySelective(UserAlert record);

    int updateByPrimaryKey(UserAlert record);
}