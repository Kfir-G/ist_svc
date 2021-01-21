package com.ist.svc.dao;

import com.ist.svc.domain.UserAcctCashdown;
import com.ist.svc.domain.UserAcctCashdownExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAcctCashdownMapper {
    long countByExample(UserAcctCashdownExample example);

    int deleteByExample(UserAcctCashdownExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAcctCashdown record);

    int insertSelective(UserAcctCashdown record);

    List<UserAcctCashdown> selectByExample(UserAcctCashdownExample example);

    UserAcctCashdown selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAcctCashdown record, @Param("example") UserAcctCashdownExample example);

    int updateByExample(@Param("record") UserAcctCashdown record, @Param("example") UserAcctCashdownExample example);

    int updateByPrimaryKeySelective(UserAcctCashdown record);

    int updateByPrimaryKey(UserAcctCashdown record);
}