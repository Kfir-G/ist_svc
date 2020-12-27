package com.ist.svc.dao;

import com.ist.svc.domain.MsgMember;
import com.ist.svc.domain.MsgMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgMemberMapper {
    long countByExample(MsgMemberExample example);

    int deleteByExample(MsgMemberExample example);

    int deleteByPrimaryKey(Long memberid);

    int insert(MsgMember record);

    int insertSelective(MsgMember record);

    List<MsgMember> selectByExample(MsgMemberExample example);

    MsgMember selectByPrimaryKey(Long memberid);

    int updateByExampleSelective(@Param("record") MsgMember record, @Param("example") MsgMemberExample example);

    int updateByExample(@Param("record") MsgMember record, @Param("example") MsgMemberExample example);

    int updateByPrimaryKeySelective(MsgMember record);

    int updateByPrimaryKey(MsgMember record);

    Integer selectMaxSeqByGroupId(long parseLong);
}