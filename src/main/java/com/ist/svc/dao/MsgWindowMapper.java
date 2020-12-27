package com.ist.svc.dao;

import com.ist.svc.domain.MsgWindow;
import com.ist.svc.domain.MsgWindowExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MsgWindowMapper {
    long countByExample(MsgWindowExample example);

    int deleteByExample(MsgWindowExample example);

    int deleteByPrimaryKey(Long windowid);

    int insert(MsgWindow record);

    int insertSelective(MsgWindow record);

    List<MsgWindow> selectByExample(MsgWindowExample example);

    MsgWindow selectByPrimaryKey(Long windowid);

    int updateByExampleSelective(@Param("record") MsgWindow record, @Param("example") MsgWindowExample example);

    int updateByExample(@Param("record") MsgWindow record, @Param("example") MsgWindowExample example);

    int updateByPrimaryKeySelective(MsgWindow record);

    int updateByPrimaryKey(MsgWindow record);

    List<MsgWindow> selectsByParams(Map<String,Object> params);

    int updateByParams(Map<String, Object> params);
}