package com.ist.svc.service.newversion.impl;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.BaseResp;
import com.ist.svc.controller.model.dto.JoinUserFriendNotifyReq;
import com.ist.svc.controller.model.dto.ModifyUserFriendReq;
import com.ist.svc.controller.model.dto.QueryUserFriendByUserIdReq;
import com.ist.svc.controller.model.dto.QueryUserFriendByUserIdResp;
import com.ist.svc.dao.UserFriendMapper;
import com.ist.svc.domain.UserFriend;
import com.ist.svc.domain.UserFriendExample;
import com.ist.svc.domain.vo.UserFriendVo;
import com.ist.svc.service.impl.BaseServiceImpl;
import com.ist.svc.service.newversion.UserFriendService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: sunhaitao
 */
@Service
public class UserFriendServiceImpl extends BaseServiceImpl implements UserFriendService {
    @Autowired
    private UserFriendMapper userFriendMapper;
    @Override
    public QueryUserFriendByUserIdResp queryUserFriendByUserId(QueryUserFriendByUserIdReq req) {
        UserFriendExample example = new UserFriendExample();
        example.createCriteria().andUseridEqualTo(Long.valueOf(req.getUserId()));
        List<UserFriend> userFriends = userFriendMapper.selectByExample(example);
        List<UserFriendVo> userFriendVos = new ArrayList<>();
        for (UserFriend userFriend : userFriends){
            UserFriendVo userFriendVo = new UserFriendVo();
            if (userFriend.getFuserid()!=null){
                userFriendVo.setFriendGroupId(userFriend.getFuserid());
            }
            userFriendVo.setFUserId(userFriend.getFuserid().toString());
            userFriendVo.setGroupType(userFriend.getGrouptype().intValue());
            userFriendVo.setId(userFriend.getId());
            userFriendVo.setMarkName(userFriend.getMarkname());
            userFriendVo.setStatus(userFriend.getStatus().intValue());
            userFriendVo.setUserId(userFriend.getUserid().toString());
            userFriendVos.add(userFriendVo);
        }
        QueryUserFriendByUserIdResp resp = new QueryUserFriendByUserIdResp();
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
        resp.setData(userFriendVos);
        return resp;
    }

    @Override
    public BaseResp joinUserFriendNotify(JoinUserFriendNotifyReq req) {
        BaseResp baseResp = new BaseResp();
        Date now = new Date();
        UserFriend userFriend = new UserFriend();
        userFriend.setCreatetime(now);
        userFriend.setFriendgroupid(0L);
        userFriend.setFuserid(Long.valueOf(req.getFuserId()));
        if (null == req.getGroupType()){
            userFriend.setGrouptype(IstEnum.GroupType.OTHER.getCode());
        }else {
            userFriend.setGrouptype(req.getGroupType().shortValue());
        }
//        userFriend.setMarkname(req.getMarkName());
        userFriend.setUpdatetime(now);
        userFriend.setUserid(Long.valueOf(req.getUserId()));
        if (req.getStatus()!=null){
            userFriend.setStatus(req.getStatus().shortValue());
        }
        userFriendMapper.insertOrUpdate(userFriend);
        userFriend.setFuserid(Long.valueOf(req.getUserId()));
        userFriend.setUserid(Long.valueOf(req.getFuserId()));
        userFriendMapper.insertOrUpdate(userFriend);
        baseResp.setCode(ResultConstant.SUCCESS_CODE);
        baseResp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
        return baseResp;
    }

    @Override
    public BaseResp modifyUserFriend(ModifyUserFriendReq req) {
//        if (StringUtils.isBlank(req.getMarkName()) && null==req.getGroupType()){
//            return BaseResp.result(ResultConstant.PARAM_ERROR_CODE,ResultConstant.PARAM_ERROR_MSG + "[markName|groupType]");
//        }
        userFriendMapper.updateByUserIdAndFUserId(Long.valueOf(req.getUserId()),Long.valueOf(req.getFuserId()),req.getMarkName(),req.getGroupType(),req.getStatus());
        return BaseResp.ok();
    }
}
