package com.ist.svc.dao;

import com.ist.svc.domain.UserAccountBook;
import com.ist.svc.domain.UserAccountBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAccountBookMapper {
    long countByExample(UserAccountBookExample example);

    int deleteByExample(UserAccountBookExample example);

    int deleteByPrimaryKey(Long transid);

    int insert(UserAccountBook record);

    int insertSelective(UserAccountBook record);

    List<UserAccountBook> selectByExample(UserAccountBookExample example);

    UserAccountBook selectByPrimaryKey(Long transid);

    int updateByExampleSelective(@Param("record") UserAccountBook record, @Param("example") UserAccountBookExample example);

    int updateByExample(@Param("record") UserAccountBook record, @Param("example") UserAccountBookExample example);

    int updateByPrimaryKeySelective(UserAccountBook record);

    int updateByPrimaryKey(UserAccountBook record);
}