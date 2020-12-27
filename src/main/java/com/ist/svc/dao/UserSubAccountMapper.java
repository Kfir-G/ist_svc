package com.ist.svc.dao;

import com.ist.svc.domain.UserSubAccount;
import com.ist.svc.domain.UserSubAccountExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserSubAccountMapper {
    long countByExample(UserSubAccountExample example);

    int deleteByExample(UserSubAccountExample example);

    int deleteByPrimaryKey(Long subaccountid);

    int insert(UserSubAccount record);

    int insertSelective(UserSubAccount record);

    List<UserSubAccount> selectByExample(UserSubAccountExample example);

    UserSubAccount selectByPrimaryKey(Long subaccountid);

    int updateByExampleSelective(@Param("record") UserSubAccount record, @Param("example") UserSubAccountExample example);

    int updateByExample(@Param("record") UserSubAccount record, @Param("example") UserSubAccountExample example);

    int updateByPrimaryKeySelective(UserSubAccount record);

    int updateByPrimaryKey(UserSubAccount record);

    UserSubAccount querySubAcct(Map<String, Object> params);
}