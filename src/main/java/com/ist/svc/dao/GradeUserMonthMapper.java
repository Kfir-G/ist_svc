package com.ist.svc.dao;

import com.ist.svc.domain.GradeUserMonth;
import com.ist.svc.domain.GradeUserMonthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeUserMonthMapper {
    long countByExample(GradeUserMonthExample example);

    int deleteByExample(GradeUserMonthExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GradeUserMonth record);

    int insertSelective(GradeUserMonth record);

    List<GradeUserMonth> selectByExample(GradeUserMonthExample example);

    GradeUserMonth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GradeUserMonth record, @Param("example") GradeUserMonthExample example);

    int updateByExample(@Param("record") GradeUserMonth record, @Param("example") GradeUserMonthExample example);

    int updateByPrimaryKeySelective(GradeUserMonth record);

    int updateByPrimaryKey(GradeUserMonth record);
}