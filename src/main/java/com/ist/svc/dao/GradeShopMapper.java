package com.ist.svc.dao;

import com.ist.svc.domain.GradeShop;
import com.ist.svc.domain.GradeShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeShopMapper {
    long countByExample(GradeShopExample example);

    int deleteByExample(GradeShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GradeShop record);

    int insertSelective(GradeShop record);

    List<GradeShop> selectByExample(GradeShopExample example);

    GradeShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GradeShop record, @Param("example") GradeShopExample example);

    int updateByExample(@Param("record") GradeShop record, @Param("example") GradeShopExample example);

    int updateByPrimaryKeySelective(GradeShop record);

    int updateByPrimaryKey(GradeShop record);
}