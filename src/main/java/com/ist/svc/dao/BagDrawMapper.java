package com.ist.svc.dao;

import com.ist.svc.domain.BagDraw;
import com.ist.svc.domain.BagDrawExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BagDrawMapper {
    long countByExample(BagDrawExample example);

    int deleteByExample(BagDrawExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BagDraw record);

    int insertSelective(BagDraw record);

    List<BagDraw> selectByExample(BagDrawExample example);

    BagDraw selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BagDraw record, @Param("example") BagDrawExample example);

    int updateByExample(@Param("record") BagDraw record, @Param("example") BagDrawExample example);

    int updateByPrimaryKeySelective(BagDraw record);

    int updateByPrimaryKey(BagDraw record);

    Float selectSumDrawMoney(BigDecimal bagNo);

    int batchInsert(List<BagDraw> bagDrawsRedis);
}