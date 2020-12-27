package com.ist.svc.service.newversion;

import com.ist.svc.controller.model.*;
import com.ist.svc.controller.model.dto.*;

/**
 * @Author: sunhaitao
 */
public interface GroupService {
    CreateGroupResp createGroup(CreateGroupReq req);
    AddGroupResp addGroup(AddGroupReq req);

    ApiBaseResp getGroupInfobyIds(GetGroupInfoByIdsReq req);

    ApiBaseResp getGroupMemInfobyIds(GetGroupMemInfobyIdsReq req);

    ApiBaseResp getGroupMembyId(GetGroupMembyIdReq req);

    BaseResp modifyGroupInfoById(ModifyGroupInfoByIdReq req);

    BaseResp modifyGroupMemInfobyId(ModifyGroupMemInfobyIdReq req);

    GetGroupsByUserIdResp getGroupsByUserId(GetGroupsByUserIdReq req);
}
