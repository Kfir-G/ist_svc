package com.ist.svc.dao;

import java.util.List;

import com.ist.svc.domain.MsgGroup;
import com.ist.svc.domain.MsgGroupExample;
import org.apache.ibatis.annotations.Param;

public interface MsgGroupMapper {
    long countByExample(MsgGroupExample example);

    int deleteByExample(MsgGroupExample example);

    int deleteByPrimaryKey(Long groupid);

    int insert(MsgGroup record);

    int insertSelective(MsgGroup record);

    List<MsgGroup> selectByExample(MsgGroupExample example);

    MsgGroup selectByPrimaryKey(Long groupid);

    int updateByExampleSelective(@Param("record") MsgGroup record, @Param("example") MsgGroupExample example);

    int updateByExample(@Param("record") MsgGroup record, @Param("example") MsgGroupExample example);

    int updateByPrimaryKeySelective(MsgGroup record);

    int updateByPrimaryKey(MsgGroup record);

    List<MsgGroup> selectGroupsByUserId(String userId);

    List<MsgGroup> selectMsgMemsByTakers(@Param("talkers")String[] talkers);
}