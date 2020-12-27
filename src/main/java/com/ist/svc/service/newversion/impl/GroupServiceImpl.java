package com.ist.svc.service.newversion.impl;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.*;
import com.ist.svc.controller.model.dto.*;
import com.ist.svc.dao.MsgGroupMapper;
import com.ist.svc.dao.MsgMemberMapper;
import com.ist.svc.domain.MsgGroup;
import com.ist.svc.domain.MsgGroupExample;
import com.ist.svc.domain.MsgMember;
import com.ist.svc.domain.MsgMemberExample;
import com.ist.svc.domain.vo.*;
import com.ist.svc.service.impl.BaseServiceImpl;
import com.ist.svc.service.newversion.GroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: sunhaitao
 */
@Service
public class GroupServiceImpl extends BaseServiceImpl implements GroupService {
    @Autowired
    private MsgGroupMapper msgGroupMapper;
    @Autowired
    private MsgMemberMapper msgMemberMapper;
    @Override
    public CreateGroupResp createGroup(CreateGroupReq req) {
        MsgGroup msgGroup = new MsgGroup();
        msgGroup.setAvatarurl(req.getAvatarUrl());
        msgGroup.setCreatetime(new Date());
        if (req.getJoinGroup()!=null){
            msgGroup.setJoingroup(req.getJoinGroup().shortValue());
        }else{
            msgGroup.setJoingroup((short) 0);
        }
        msgGroup.setGroupName(req.getGroupName());
        msgGroup.setOptuserid(Long.parseLong(req.getOptUserId()));
        msgGroup.setStatus(IstEnum.GroupStatus.NORMAL.getCode());
        msgGroup.setUpdatetime(new Date());
        msgGroupMapper.insertSelective(msgGroup);
        CreateGroupData data = new CreateGroupData();
        data.setGroupId(msgGroup.getGroupid().toString());
        //先注释
//        AddGroupReq addGroupReq = new AddGroupReq();
//        addGroupReq.setGroupId(msgGroup.getGroupid().toString());
//        addGroupReq.setInviteUserId(req.getOptUserId());
//        addGroupReq.setTalkers(req.getOptUserId());
//        addGroupReq.setRole(IstEnum.MemberRole.CREATER.getCode());
//        addGroup(addGroupReq);
        return CreateGroupResp.succ(data);
    }

    @Override
    public AddGroupResp addGroup(AddGroupReq req) {
        AddGroupResp resp = new AddGroupResp();
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
        Integer seqMax = msgMemberMapper.selectMaxSeqByGroupId(Long.parseLong(req.getGroupId()));
        if (seqMax==null){
            seqMax = 1;
        }else{
            seqMax = seqMax + 1;
        }
        AddGroupVo addGroupVo = new AddGroupVo();
        addGroupVo.setGroupId(req.getGroupId());
        List<MemberVo> listMemerVo = new ArrayList<>();
        MsgMember msgMember = new MsgMember();
        msgMember.setCreatetime(new Date());
        msgMember.setGroupid(Long.parseLong(req.getGroupId()));
        msgMember.setInviteuserid(Long.parseLong(req.getInviteUserId()));
        msgMember.setOptuserid(Long.parseLong(req.getInviteUserId()));
        boolean isFail = false;
        for(String talker : req.getTalkers().split(",")){
            if (StringUtils.isNumeric(talker)){
                MemberVo memberVo = new MemberVo();
                long temp = Long.valueOf(talker);
                msgMember.setTalker(temp);
                msgMember.setSeq(seqMax.shortValue());
                seqMax++;
                if (req.getRole()!=null){
                    msgMember.setRole(req.getRole());
                }else{
                    msgMember.setRole(IstEnum.MemberRole.MEMBER.getCode());
                }
                msgMember.setUpdatetime(new Date());
                msgMember.setStatus(IstEnum.GroupStatus.NORMAL.getCode());
                try {
                    memberVo.setTalker(talker);
                    msgMemberMapper.insertSelective(msgMember);
                    memberVo.setSeq(msgMember.getSeq().toString());
                    memberVo.setMemberId(msgMember.getMemberid().toString());
                    listMemerVo.add(memberVo);
                }catch (Exception e){
                    memberVo.setMemberId("0");
                    listMemerVo.add(memberVo);
                    isFail=true;
                    continue;
                }
            }
        }
        addGroupVo.setMembers(listMemerVo);
        resp.setData(addGroupVo);
        if (isFail){
            resp.setCode(ResultConstant.ADD_GROUP_ERR_CODE);
            resp.setMsg(ResultConstant.ADD_GROUP_ERR_MSG);
        }
        return resp;
    }

    @Override
    public ApiBaseResp getGroupInfobyIds(GetGroupInfoByIdsReq req) {
        MsgGroupExample examp = new MsgGroupExample();
        List<Long> groupIds = new ArrayList<>();
        for (String str : Arrays.asList(req.getGroupIds().split(","))){
            groupIds.add(Long.valueOf(str));
        }
        examp.createCriteria().andGroupidIn(groupIds).andStatusNotEqualTo(IstEnum.GroupStatus.DISMISS.getCode());
        List<MsgGroup> msgGroups = msgGroupMapper.selectByExample(examp);
        List<GetGroupInfoByIdsVo> listVo = new ArrayList<>();
        for (MsgGroup msgGroup: msgGroups){
            GetGroupInfoByIdsVo groupInfoByIdsVo = new GetGroupInfoByIdsVo();
            groupInfoByIdsVo.setAvatarUrl(msgGroup.getAvatarurl());
            groupInfoByIdsVo.setCreateTime(DateUtil.getString(msgGroup.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
            groupInfoByIdsVo.setGroupId(msgGroup.getGroupid().toString());
            groupInfoByIdsVo.setJoinGroup(msgGroup.getJoingroup().intValue());
            groupInfoByIdsVo.setGroupName(msgGroup.getGroupName());
            groupInfoByIdsVo.setOptUserId(msgGroup.getOptuserid().toString());
            groupInfoByIdsVo.setStatus(msgGroup.getStatus().intValue());
            groupInfoByIdsVo.setUpdateTime(DateUtil.getString(msgGroup.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
            listVo.add(groupInfoByIdsVo);
        }
        return ApiBaseResp.succ(listVo);
    }

    @Override
    public ApiBaseResp getGroupMemInfobyIds(GetGroupMemInfobyIdsReq req) {
        List<GetGroupMemInfobyIdsVo> list = new ArrayList<>();
        String groupIds = req.getGroupIds();
        if (StringUtils.isNoneBlank(groupIds)){
            String[] split = groupIds.split(",");
            for (String groupId : split){
                GetGroupMemInfobyIdsVo getGroupMemInfobyIdsVo = new GetGroupMemInfobyIdsVo();
                getGroupMemInfobyIdsVo.setGroupId(groupId);
                MsgMemberExample example = new MsgMemberExample();
                example.createCriteria().andGroupidEqualTo(Long.valueOf(groupId)).andStatusNotEqualTo(IstEnum.GroupStatus.DISMISS.getCode());;
                List<MemberVo> memberVos = new ArrayList<>();
                List<MsgMember> msgMembers = msgMemberMapper.selectByExample(example);
                for (MsgMember msgMember : msgMembers){
                    MemberVo memberVo = new MemberVo();
                    memberVo.setAvatarUrl(msgMember.getGroupavatarurl());
                    memberVo.setCreateTime(DateUtil.getString(msgMember.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                    memberVo.setInviteUserId(msgMember.getInviteuserid().toString());
                    memberVo.setLockTime(DateUtil.getString(msgMember.getLocktime(),DateUtil.PATTERN_DATE_TIME));
                    memberVo.setMemberId(msgMember.getMemberid().toString());
                    memberVo.setOptUserId(msgMember.getOptuserid().toString());
                    memberVo.setGroupNickName(msgMember.getGroupnickname());
                    memberVo.setRole(msgMember.getRole().intValue());
                    memberVo.setSeq(msgMember.getSeq().toString());
                    memberVo.setStatus(msgMember.getStatus().intValue());
                    memberVo.setTalker(msgMember.getTalker().toString());
                    memberVo.setUpdateTime(DateUtil.getString(msgMember.getLocktime(),DateUtil.PATTERN_DATE_TIME));
                    memberVos.add(memberVo);
                }
                getGroupMemInfobyIdsVo.setMembers(memberVos);
                list.add(getGroupMemInfobyIdsVo);
            }
        }else {
            String[] talkers = req.getTalkers().split(",");
            List<MsgGroup> msgGroups = msgGroupMapper.selectMsgMemsByTakers(talkers);
            msgGroups.forEach(item->{
                GetGroupMemInfobyIdsVo getGroupMemInfobyIdsVo = new GetGroupMemInfobyIdsVo();
                getGroupMemInfobyIdsVo.setGroupId(item.getGroupid().toString());
                List<MemberVo> memberVos = new ArrayList<>();
                item.getMsgMembers().forEach(msgMember->{
                    MemberVo memberVo = new MemberVo();
                    memberVo.setAvatarUrl(msgMember.getGroupavatarurl());
                    memberVo.setCreateTime(DateUtil.getString(msgMember.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                    memberVo.setInviteUserId(msgMember.getInviteuserid().toString());
                    memberVo.setLockTime(DateUtil.getString(msgMember.getLocktime(),DateUtil.PATTERN_DATE_TIME));
                    memberVo.setMemberId(msgMember.getMemberid().toString());
                    memberVo.setOptUserId(msgMember.getOptuserid().toString());
                    memberVo.setGroupNickName(msgMember.getGroupnickname());
                    memberVo.setRole(msgMember.getRole().intValue());
                    memberVo.setSeq(msgMember.getSeq().toString());
                    memberVo.setStatus(msgMember.getStatus().intValue());
                    memberVo.setTalker(msgMember.getTalker().toString());
                    memberVo.setUpdateTime(DateUtil.getString(msgMember.getLocktime(),DateUtil.PATTERN_DATE_TIME));
                    memberVos.add(memberVo);
                });
                getGroupMemInfobyIdsVo.setMembers(memberVos);
                list.add(getGroupMemInfobyIdsVo);
            });
        }
        return ApiBaseResp.succ(list);
    }

    @Override
    public ApiBaseResp getGroupMembyId(GetGroupMembyIdReq req) {
        GetGroupMembyIdVo getGroupMembyIdVo = new GetGroupMembyIdVo();
        getGroupMembyIdVo.setGroupId(req.getGroupId());
        MsgMemberExample example = new MsgMemberExample();
        example.createCriteria().andGroupidEqualTo(Long.valueOf(Long.valueOf(req.getGroupId()))).andStatusNotEqualTo(IstEnum.GroupStatus.DISMISS.getCode());;
        List<MsgMember> msgMembers = msgMemberMapper.selectByExample(example);
        List<String> talks = new ArrayList<>();
        for (MsgMember msgMember: msgMembers){
            talks.add(msgMember.getTalker().toString());
        }
        getGroupMembyIdVo.setTalkers(talks);
        return ApiBaseResp.succ(getGroupMembyIdVo);
    }

    @Override
    public BaseResp modifyGroupInfoById(ModifyGroupInfoByIdReq req) {
        MsgGroup msgGroup = new MsgGroup();
        msgGroup.setGroupid(Long.parseLong(req.getGroupId()));
        msgGroup.setUpdatetime(new Date());
        if (req.getJoinGroup()!=null){
            msgGroup.setJoingroup(req.getJoinGroup().shortValue());
        }
        if (StringUtils.isNoneBlank(req.getName())){
            msgGroup.setGroupName(req.getName());
        }
        if (req.getStatus()!=null){
            msgGroup.setStatus(req.getStatus().shortValue());
        }
        msgGroupMapper.updateByPrimaryKeySelective(msgGroup);
        return BaseResp.ok();
    }

    @Override
    public BaseResp modifyGroupMemInfobyId(ModifyGroupMemInfobyIdReq req) {
        MsgMember msgMember = new MsgMember();
        msgMember.setMemberid(Long.parseLong(req.getMemberId()));
        if (StringUtils.isNoneBlank(req.getMemberId())){
            msgMember.setUpdatetime(new Date());
        }
        if (req.getRole()!=null){
            msgMember.setRole(req.getRole().shortValue());
        }
        if (req.getStatus()!=null){
            msgMember.setStatus(req.getStatus().shortValue());
        }
        if (StringUtils.isNoneBlank(req.getGroupNickName())){
            msgMember.setGroupnickname(req.getGroupNickName());
        }
        msgMemberMapper.updateByPrimaryKeySelective(msgMember);
        return BaseResp.ok();
    }

    @Override
    public GetGroupsByUserIdResp getGroupsByUserId(GetGroupsByUserIdReq req) {
        List<MsgGroup> list = msgGroupMapper.selectGroupsByUserId(req.getUserId());
        return null;
    }
}
