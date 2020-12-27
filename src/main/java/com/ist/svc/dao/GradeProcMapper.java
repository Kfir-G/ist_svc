package com.ist.svc.dao;

import com.ist.svc.domain.GradeProc;
import com.ist.svc.domain.GradeProcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeProcMapper {
    long countByExample(GradeProcExample example);

    int deleteByExample(GradeProcExample example);

    int deleteByPrimaryKey(Long gradeid);

    int insert(GradeProc record);

    int insertSelective(GradeProc record);

    List<GradeProc> selectByExample(GradeProcExample example);

    GradeProc selectByPrimaryKey(Long gradeid);

    int updateByExampleSelective(@Param("record") GradeProc record, @Param("example") GradeProcExample example);

    int updateByExample(@Param("record") GradeProc record, @Param("example") GradeProcExample example);

    int updateByPrimaryKeySelective(GradeProc record);

    int updateByPrimaryKey(GradeProc record);
}