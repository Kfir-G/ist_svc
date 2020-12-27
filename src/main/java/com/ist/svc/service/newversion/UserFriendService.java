package com.ist.svc.service.newversion;

import com.ist.svc.controller.model.BaseResp;
import com.ist.svc.controller.model.dto.JoinUserFriendNotifyReq;
import com.ist.svc.controller.model.dto.ModifyUserFriendReq;
import com.ist.svc.controller.model.dto.QueryUserFriendByUserIdReq;
import com.ist.svc.controller.model.dto.QueryUserFriendByUserIdResp;

/**
 * @Author: sunhaitao
 */
public interface UserFriendService {
    QueryUserFriendByUserIdResp queryUserFriendByUserId(QueryUserFriendByUserIdReq req);

    BaseResp joinUserFriendNotify(JoinUserFriendNotifyReq req);

    BaseResp modifyUserFriend(ModifyUserFriendReq req);
}
