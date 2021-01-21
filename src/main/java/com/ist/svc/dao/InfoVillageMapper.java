package com.ist.svc.dao;

import com.ist.svc.domain.InfoVillage;
import com.ist.svc.domain.InfoVillageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoVillageMapper {
    long countByExample(InfoVillageExample example);

    int deleteByExample(InfoVillageExample example);

    int deleteByPrimaryKey(Long villageid);

    int insert(InfoVillage record);

    int insertSelective(InfoVillage record);

    List<InfoVillage> selectByExample(InfoVillageExample example);

    InfoVillage selectByPrimaryKey(Long villageid);

    int updateByExampleSelective(@Param("record") InfoVillage record, @Param("example") InfoVillageExample example);

    int updateByExample(@Param("record") InfoVillage record, @Param("example") InfoVillageExample example);

    int updateByPrimaryKeySelective(InfoVillage record);

    int updateByPrimaryKey(InfoVillage record);
}