package com.ist.svc.service;

import com.ist.svc.config.kafka.ChatMsg;
import com.ist.svc.controller.model.*;
import com.ist.svc.domain.Msg;

import java.util.List;
import java.util.Map;

/**
 * @Author: sunhaitao
 */
public interface ChatService {
    //发送消息
    void sendMsg(SendMsgReq sendMsgReq, SendMsgResp sendMsgResp) throws Exception;
    //查询窗口
    void queryWindowMsg(QueryWindowMsgReq req, QueryBaseResp resp) throws Exception;
    //创建聊天窗口
    void createWindow(CreateWindowReq req, CreateWindowResp resp) throws Exception;
    //根据窗口id查询窗口消息
    void queryMsgByWindowIds(QueryMsgByWindowIdsReq req, QueryBaseResp resp) throws Exception;
    //更新消息状态
    void updateMsgStatus(UpdateMsgStatusReq req, BaseResp resp) throws Exception;

    void saveSocketMsg(Msg msg) throws Exception;

    void queryWindows(QueryWindowsReq req, QueryBaseResp resp)throws Exception;

    List<ChatMsg> queryByParams(Map<String,Object> params);

    int updateByParams(Map<String,Object> params);

    void updateByMsgId(long msgId);
}
