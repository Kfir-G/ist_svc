package com.ist.svc.service.impl;

import com.github.pagehelper.PageHelper;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.config.IstEnum;
import com.ist.svc.config.kafka.ChatMsg;
import com.ist.svc.config.kafka.MsgData;
import com.ist.svc.controller.model.*;
import com.ist.svc.dao.CommonMapper;
import com.ist.svc.dao.MsgMapper;
import com.ist.svc.dao.MsgWindowMapper;
import com.ist.svc.domain.Msg;
import com.ist.svc.domain.MsgWindow;
import com.ist.svc.domain.MsgWindowExample;
import com.ist.svc.service.ChatService;
import com.ist.svc.service.UserTokenService;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author: sunhaitao
 */
@Service(value = "chatService")
public class ChatServiceImpl extends BaseServiceImpl implements ChatService {
    @Autowired
    private UserTokenService userTokenService;
    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private MsgWindowMapper msgWindowMapper;
    @Autowired
    private MsgMapper msgMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void sendMsg(SendMsgReq req, SendMsgResp resp) {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.SEND_MSG_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.SEND_MSG_TOKENID_ERROR_MSG);
            return;
        }

//        MsgWindow msgWindow = new MsgWindow();
        Date now = new Date();
//        if (StringUtils.isBlank(req.getWindowId())) {
//            //创建窗口记录
//            if (req.getWindowType()==null || req.getWindowType()==0){
//                resp.setCode(ResultConstant.SEND_MSG_WINDOWTYPE_NULL_ERROR_CODE);
//                resp.setMsg(ResultConstant.SEND_MSG_WINDOWTYPE_NULL_ERROR_MSG);
//                return;
//            }
//            Long windowId = commonMapper.querySeqNextVal(IstEnum.SeqName.WINDOW_ID.getSeqValue());
//            msgWindow.setWindowid(windowId);
//            resp.setWindowId(windowId.toString());
//            msgWindow.setShopid(Integer.parseInt(req.getShopId()));
//            msgWindow.setTalker(Long.valueOf(req.getTalker()));
//            msgWindow.setType(req.getWindowType().shortValue());
//            msgWindow.setCreatetime(now);
//            msgWindowMapper.insertSelective(msgWindow);
//        }

        //新增msg
        Msg msg = new Msg();
        msg.setContent(req.getContent());
        msg.setMsgtype(req.getMsgType().shortValue());
        msg.setSender(Long.valueOf(req.getSender()));
        msg.setSenderame(req.getSenderName()==null?"":req.getSenderName());
        msg.setWindowid(req.getWindowId()!=null?Long.valueOf(req.getWindowId()):0);
        msg.setStatus(IstEnum.MsgStatus.NOT_READ.getStatus());
        msg.setCreatetime(now);
        msg.setUpdatetime(now);
        msgMapper.insert(msg);

        //设置成功返回
        resp.setCode(ResultConstant.SEND_MSG_SUCC_CODE);
        resp.setMsg(ResultConstant.SEND_MSG_SUCC_MSG);
//        resp.setMsgId(msg.getMsgid().toString());

    }

    @Override
    public void queryWindowMsg(QueryWindowMsgReq req, QueryBaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.QUERY_WINDOW_MSG_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_WINDOW_MSG_TOKENID_ERROR_MSG);
            return;
        }
        if (StringUtils.isBlank(req.getShopId()) && StringUtils.isBlank(req.getTalker())){
            resp.setCode(ResultConstant.QUERY_WINDOW_MSG_PARAME_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_WINDOW_MSG_PARAME_ERROR_MSG);
            return;
        }
        Map<String,Object> params = new HashMap<>();
        if (StringUtils.isNotBlank(req.getShopId())){
            params.put("shopId",req.getShopId());
        }
        if (StringUtils.isNoneBlank(req.getCreateTime())){
            params.put("createTime",req.getCreateTime());
        }
        if (StringUtils.isNoneBlank(req.getTalker())){
            params.put("talker",req.getTalker());
        }
        if (StringUtils.isNoneBlank(req.getMsgId())){
            params.put("msgId",req.getMsgId());
        }
        List<MsgWindow> msgWindows = msgWindowMapper.selectsByParams(params);
        List<WindowInfo> data = new ArrayList<>();
        if (msgWindows!=null && msgWindows.size()>0){
            for (MsgWindow msgWindow : msgWindows){
                WindowInfo wi = new WindowInfo();
                List<WindowMsgData> list = new ArrayList<>();
                wi.setAvatarUrl(msgWindow.getAvatarurl()!=null?msgWindow.getAvatarurl():"");
                wi.setNickName(msgWindow.getNickname()!=null?msgWindow.getNickname():"");
                wi.setShopAvatarUrl(msgWindow.getShopavatarurl()!=null?msgWindow.getShopavatarurl():"");
                wi.setShopId(msgWindow.getShopid()!=null?msgWindow.getShopid().toString():"");
                wi.setShopName(msgWindow.getShopname()!=null?msgWindow.getShopname():"");
                wi.setTalker(msgWindow.getTalker()!=null?msgWindow.getTalker().toString():"");
                wi.setType(msgWindow.getType().intValue());
                wi.setWindowId(msgWindow.getWindowid().toString());
                wi.setCreateTime(DateUtil.getString(msgWindow.getCreatetime(),DateUtil.PATTERN_DATE_TIME)); //
                if (msgWindow!=null && msgWindow.getMsgs().size()>0){
                    for (Msg msg: msgWindow.getMsgs()){
                        WindowMsgData windowMsg = new WindowMsgData();
                        windowMsg.setContent(msg.getContent());
                        windowMsg.setCreateTime(DateUtil.getString(msg.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
//                        windowMsg.setMsgId(msg.getMsgid().toString());
                        windowMsg.setMsgType(msg.getMsgtype().intValue());
                        windowMsg.setSender(msg.getSender().toString());
                        windowMsg.setSenderName(msg.getSenderame());
                        windowMsg.setStatus(msg.getStatus().intValue());
                        windowMsg.setUpdateTime(DateUtil.getString(msg.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
                        windowMsg.setWindowId(msg.getWindowid().toString());
                        list.add(windowMsg);
                    }
                    wi.setMsgs(list);
                }
                data.add(wi);
            }
        }
        resp.setCode(ResultConstant.QUERY_WINDOW_MSG_SUCC_CODE);
        resp.setMsg(ResultConstant.QUERY_WINDOW_MSG_SUCC_MSG);
        resp.setData(data);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void createWindow(CreateWindowReq req, CreateWindowResp resp) throws Exception {
        resp.setCode(ResultConstant.CREATE_WINDOW_SUCC_CODE);
        resp.setMsg(ResultConstant.CREATE_WINDOW_SUCC_MSG);
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.CREATE_WINDOW_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.CREATE_WINDOW_TOKENID_ERROR_MSG);
            return;
        }
        //通过talker和shopId 应该唯一存在
        MsgWindowExample example = new MsgWindowExample();
        MsgWindowExample.Criteria criteria = example.createCriteria();
        criteria.andTalkerEqualTo(Long.valueOf(req.getTalker()));
        criteria.andShopidEqualTo(Integer.valueOf(req.getShopId()));
        List<MsgWindow> msgWindows = msgWindowMapper.selectByExample(example);
        if (msgWindows!=null && msgWindows.size()>0){
            resp.setWindowId(msgWindows.get(0).getWindowid().toString());
            return;
        }
        MsgWindow msgWindow = new MsgWindow();
        Date now = new Date();
        Long windowId = commonMapper.querySeqNextVal(IstEnum.SeqName.WINDOW_ID.getSeqValue());
        msgWindow.setWindowid(windowId);
        msgWindow.setShopid(Integer.parseInt(req.getShopId()));
        msgWindow.setTalker(Long.valueOf(req.getTalker()));
        msgWindow.setType(req.getWindowType().shortValue());
        msgWindow.setAvatarurl(req.getAvatarUrl()!=null?req.getAvatarUrl():"");
        msgWindow.setShopname(req.getShopName()!=null?req.getShopName():"");
        msgWindow.setNickname(req.getNickName()!=null?req.getNickName():"");
        msgWindow.setShopavatarurl(req.getShopAvatarUrl()!=null?req.getShopAvatarUrl():"");

        msgWindow.setCreatetime(now);
        msgWindowMapper.insertSelective(msgWindow);
        //设置成功返回
        resp.setWindowId(windowId.toString());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void queryMsgByWindowIds(QueryMsgByWindowIdsReq req, QueryBaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.QUERY_MSG_BYWINDOWIDS_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_MSG_BYWINDOWIDS_TOKENID_ERROR_MSG);
            return;
        }
        Map<String,Object> params = new HashMap<>();
        if (StringUtils.isNoneBlank(req.getMsgId())){
            params.put("msgId",req.getMsgId());
        }
        if (StringUtils.isNoneBlank(req.getCreateTime())){
            params.put("createTime",req.getCreateTime());
        }

        String[] windowIdsArr = req.getWindowIds().split(",");
        if (windowIdsArr!=null && windowIdsArr.length>100){
            resp.setCode(ResultConstant.QUERY_MSG_BYWINDOWIDS_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_MSG_BYWINDOWIDS_ERROR_MSG);
            return;
        }
        List<Integer> integerList = new ArrayList<>();
        for (String temp : windowIdsArr){
            integerList.add(Integer.parseInt(temp));
        }
        params.put("windowIds",integerList);
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Msg> msgs = msgMapper.selectMsgByParams(params);
        List<WindowMsgData> list = new ArrayList<>();
        List<Long> msgids = new ArrayList<>();
        if (msgs!=null && msgs.size()>0){
            for (Msg msg : msgs){
//                msgids.add(msg.getMsgid());
                WindowMsgData windowMsg = new WindowMsgData();
                windowMsg.setContent(msg.getContent());
                windowMsg.setCreateTime(DateUtil.getString(msg.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
//                windowMsg.setMsgId(msg.getMsgid().toString());
                windowMsg.setMsgType(msg.getMsgtype().intValue());
                windowMsg.setSender(msg.getSender().toString());
                windowMsg.setSenderName(msg.getSenderame());
                windowMsg.setStatus(msg.getStatus().intValue());
                windowMsg.setUpdateTime(DateUtil.getString(msg.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
                windowMsg.setWindowId(msg.getWindowid().toString());
                list.add(windowMsg);
            }
        }
        //根据查询出来的msgId进行更新已读
        if (msgids.size()>0){
            Map<String,Object> paramsUpdate = new HashMap<>();
            paramsUpdate.put("msgIds",msgids);
            paramsUpdate.put("status",IstEnum.MsgStatus.READ.getStatus());
            paramsUpdate.put("updateTime",new Date());
            paramsUpdate.put("userId",req.getUserId());
            msgMapper.updateByParams(paramsUpdate);
        }

        resp.setCode(ResultConstant.QUERY_MSG_BYWINDOWIDS_SUCC_CODE);
        resp.setMsg(ResultConstant.QUERY_MSG_BYWINDOWIDS_SUCC_MSG);
        resp.setData(list);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateMsgStatus(UpdateMsgStatusReq req, BaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.UPDATE_MSG_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.UPDATE_MSG_TOKENID_ERROR_MSG);
            return;
        }
        String[] msgIdsArr = req.getMsgIds().split(",");
        if (msgIdsArr!=null && msgIdsArr.length>100){
            resp.setCode(ResultConstant.UPDATE_MSG_BYWINDOWIDS_ERROR_CODE);
            resp.setMsg(ResultConstant.UPDATE_MSG_BYWINDOWIDS_ERROR_MSG);
            return;
        }

        Map<String,Object> params = new HashMap<>();
        params.put("msgIds",Arrays.asList(req.getMsgIds().split(",")));
        params.put("status",req.getStatus());
        params.put("updateTime",new Date());
        msgMapper.updateByParams(params);
        resp.setCode(ResultConstant.UPDATE_MSG_SUCC_CODE);
        resp.setMsg(ResultConstant.UPDATE_MSG_SUCC_MSG);
    }

    @Override
    public void saveSocketMsg(Msg msg) {
        msgMapper.insert(msg);
    }

    @Override
    public void queryWindows(QueryWindowsReq req, QueryBaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.QUERY_WINDOWS_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_WINDOWS_TOKENID_ERROR_MSG);
            return;
        }

        MsgWindowExample example = new MsgWindowExample();
        Long[] convert = (Long[]) ConvertUtils.convert(req.getWindowIds().split(","),Long.class);
        MsgWindowExample.Criteria criteria = example.createCriteria();
        criteria.andWindowidIn(Arrays.asList(convert));
        List<MsgWindow> msgWindows = msgWindowMapper.selectByExample(example);
        List<QueryWindowsData> data = new ArrayList<>();
        for (MsgWindow window : msgWindows){
            QueryWindowsData windowsData = new QueryWindowsData();
            windowsData.setAvatarUrl(window.getAvatarurl());
            windowsData.setCreateTime(DateUtil.getString(window.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
            windowsData.setNickName(window.getNickname());
            windowsData.setShopId(window.getShopid());
            windowsData.setShopAvatarUrl(window.getShopavatarurl());
            windowsData.setShopName(window.getShopname());
            windowsData.setTalker(window.getTalker().toString());
            windowsData.setType(window.getType().intValue());
            windowsData.setWindowId(window.getWindowid().toString());
            data.add(windowsData);
        }
        resp.setData(data);
        resp.setCode(ResultConstant.QUERY_WINDOWS_SUCC_CODE);
        resp.setMsg(ResultConstant.QUERY_WINDOWS_SUCC_MSG);
    }

    @Override
    public List<ChatMsg> queryByParams(Map<String, Object> params) {
        List<ChatMsg> chatMsgs = new ArrayList<>();
        List<MsgWindow> msgWindows = msgWindowMapper.selectsByParams(params);
        if (msgWindows!=null && msgWindows.size()>0){
            for (MsgWindow msgWindow : msgWindows){
                ChatMsg chatMsg = new ChatMsg();
                chatMsg.setType(1);
                chatMsg.setReceiverId(msgWindow.getTalker().toString());
                if (msgWindow.getMsgs()!=null && msgWindow.getMsgs().size()>0){
                    List<MsgData> msgDataList = new ArrayList<>();
                    for (Msg msg : msgWindow.getMsgs()){
                        MsgData msgData = new MsgData();
                        msgData.setContent(msg.getContent());
                        msgData.setCreateTime(DateUtil.getString(msg.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                        msgData.setTimeId(msg.getTimeid().toString());
                        msgData.setMsgType(msg.getMsgtype().intValue());
                        msgData.setSender(msg.getSender().toString());
                        msgData.setSenderName(msgData.getSenderName());
                        msgData.setStatus(msg.getStatus().intValue());
                        msgDataList.add(msgData);
                    }
                    chatMsg.setData(msgDataList);
                }
                chatMsgs.add(chatMsg);
            }
        }
        return chatMsgs;
    }

    @Override
    public int updateByParams(Map<String, Object> params) {
        return msgWindowMapper.updateByParams(params);
    }

    @Override
    public void updateByMsgId(long timeId) {
        Msg updateMsg = new Msg();
        updateMsg.setStatus((short) 0);
        updateMsg.setTimeid(timeId);
        msgMapper.updateByPrimaryKeySelective(updateMsg);
    }
}
