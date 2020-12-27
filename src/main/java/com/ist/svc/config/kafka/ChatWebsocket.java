//package com.ist.svc.config.kafka;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.ist.svc.common.ResultConstant;
//import com.ist.svc.config.IstEnum;
//import com.ist.svc.controller.model.UserVerifyTokenReq;
//import com.ist.svc.controller.model.UserVerifyTokenResp;
//import com.ist.svc.domain.Msg;
//import com.ist.svc.service.ChatService;
//import com.ist.svc.service.UserTokenService;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * @Author: sunhaitao
// */
//@ServerEndpoint("/imserver/{userId}/{tokenId}")
//@Component
//public class ChatWebsocket implements ApplicationContextAware {
////    private Logger logger = Logger.getLogger(ChatWebsocket.class);
////    @Resource(name="all_log")
//    private Log logger = LogFactory.getLog(ChatWebsocket.class);
//
//    private static ApplicationContext applicationContext;
//
//    private static ChatService chatService;
//
//    private static KafkaTemplate kafkaTemplate;
//
//    private static UserTokenService userTokenService;
//
//    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
//    private static int onlineCount = 0;
//    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
//    private static Map<String, Session> drWebSocketSet = new ConcurrentHashMap<>(); //医生web
//
//
//    /**
//     * 连接建立成功调用的方法
//     *
//     * @param userId     用户标识
//     */
//    @OnOpen
//    public void onOpen(@PathParam("userId") String userId, @PathParam("tokenId") String tokenId,Session session) {
//        logger.info("sessionId:" + session.getId());
//        //校验tokenId
//        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
//        userVerifyTokenReq.setTokenId(tokenId);
//        userVerifyTokenReq.setUserId(userId);
//        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
//        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
//        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
//            try {
//                session.getBasicRemote().sendText("token校验失败");
//                session.close();
//            } catch (IOException e) {
//                logger.error("sendText",e);
//            }
//            return;
//        }
//        if (kafkaTemplate == null) {
//            kafkaTemplate = applicationContext.getBean(KafkaTemplate.class); //获取kafka的Bean实例
//        }
//        if (drWebSocketSet.containsKey(userId)){
//            try {
//                drWebSocketSet.get(userId).close();
//            } catch (IOException e) {
//                logger.error("close session userId: "+userId+", err:",e);
//            }
//            drWebSocketSet.put(userId, session);
//        }else{
//            drWebSocketSet.put(userId, session);
//        }
//        addOnlineCount();
//        logger.info("用户连接:"+userId+",当前在线人数为:" + getOnlineCount());
//        //查看是否有未读消息
////        Map<String,Object> params = new HashMap<>();
////        params.put("talker",userId);
////        params.put("status",-1);
////        List<ChatMsg> chatMsgs = chatService.queryByParams(params);
////        if (chatMsgs!=null && chatMsgs.size()>0){
////            try {
////                session.getBasicRemote().sendText(JSON.toJSONString(chatMsgs));
////            } catch (Exception e) {
////                logger.error("session.getBasicRemote().sendObject.error:",e);
////            }
////            chatService.updateByParams(params);
////        }
//    }
//
//
//    /**
//     * s
//     * 收到客户端消息后调用的方法
//     *
//     * @param message 客户端发送过来的消息
//     * @param session 可选的参数
//     */
//    @OnMessage
//    public void onMessage(String message, Session session) throws Exception {
//        if ("ping".equals(message)) {
//            session.getBasicRemote().sendText("pong"); //心跳
//        } else {
//            JSONObject jsonObject = JSONObject.parseObject(message);
//            Integer type = jsonObject.getInteger("type");
//            if (type==3){
//                //重新登录后msgIdMax传递
//                JSONObject dataJson = jsonObject.getJSONObject("data");
//                String msgIdMax = dataJson.getString("msgIdMax");
//                String createTimeMax = dataJson.getString("createTimeMax");
//                //查看是否有未读消息
//                Map<String,Object> params = new HashMap<>();
//                params.put("talker",jsonObject.getString("receiverId"));
//                params.put("createTime",createTimeMax);
//                params.put("msgId",msgIdMax);
//                List<ChatMsg> chatMsgs = chatService.queryByParams(params);
//                session.getBasicRemote().sendText(JSON.toJSONString(chatMsgs));
//            }else {
//                sendMessage(message, session); //调用Kafka进行消息分发
//            }
//        }
//    }
//
//    /**
//     * 发送消息
//     *
//     * @param message
//     * @param session
//     * @throws IOException
//     */
//    public void sendMessage(String message, Session session) throws Exception {
//        if (StringUtils.isNotBlank(message)) {
//            JSONObject jsonObject = JSONObject.parseObject(message);
////            String senderId = jsonObject.getString("senderId"); //发送者ID
////            Map<String, String> pathParameters = session.getPathParameters();
////            String userId = pathParameters.get("userId"); //从session中获取userId
//
//            String receiverId = jsonObject.getString("receiverId"); //接受者ID
//            if (receiverId==null){
//                logger.warn("message:"+message+",is no receiverId");
//            }else{
//                //将消息入库
//                //TODO 这里可以进行优化。可以首先根据接收方的userId,即receiver_id判断接收方是否在当前服务器，若在，直接获取session发送即可就不需要走Kafka了，节约资源
//
//                if (drWebSocketSet.containsKey(receiverId)){
//                    getMsgFromJson(jsonObject,IstEnum.MsgStatus.NOT_READ.getStatus());
//                    drWebSocketSet.get(receiverId).getBasicRemote().sendText(jsonObject.toJSONString());
//                }else {
//                    getMsgFromJson(jsonObject,IstEnum.MsgStatus.NOT_DELIVERY.getStatus());
//                    kafkaTemplate.send("chatMessage", jsonObject.toJSONString());
//                }
//            }
//
//        }
//    }
//
//    /**
//     * 连接关闭调用的方法
//     */
//    @OnClose
//    public void onClose(Session session) {
//        Map<String, String> pathParameters = session.getPathParameters();
//        String userId = pathParameters.get("userId"); //从session中获取userId
//        if (drWebSocketSet.containsKey(userId)){
//            drWebSocketSet.remove(userId);
//            //从set中删除
//            subOnlineCount();
//            logger.info("用户退出:"+userId+",当前在线人数为:" + getOnlineCount());
//        }
//    }
//
//
//    /**
//     * 关闭连接
//     *
//     * @param map 当前登录客户端的map
//     */
//    private void close(Map<String, Session> map, String username) {
//        if (StringUtils.isNotBlank(username)) {
//            logger.info("关闭websocket链接,关闭客户端username:" + username);
//            if (map.get(username) != null) {
//                map.remove(username);
//            }
//        }
//    }
//
//    /**
//     * kafka发送消息监听事件，有消息分发
//     *
//     * @param message
//     */
//    public void kafkaReceiveMsg(String message) {
//        JSONObject jsonObject = JSONObject.parseObject(message);
//        try {
//            String receiver_id = jsonObject.getString("receiverId"); //接受者ID
//            if (drWebSocketSet.get(receiver_id) != null) {
////                getMsgFromJson(jsonObject,IstEnum.MsgStatus.NOT_READ.getStatus());
//                JSONArray data = jsonObject.getJSONArray("data");
//                for (int i=0;i<data.size();i++){
//                    JSONObject  jsonObjectData = data.getJSONObject(i);
//                    long msgId = jsonObjectData.getLong("timeId");
//                    chatService.updateByMsgId(msgId);
//                }
//                drWebSocketSet.get(receiver_id).getBasicRemote().sendText(jsonObject.toJSONString()); //进行消息发送
//            }
//            else{
//               logger.warn(jsonObject + "不存在");
//            }
//        }catch (Exception e){
//            logger.error("kafkaReceiveMsg.error:",e);
//        }
//    }
//
//    private void getMsgFromJson(JSONObject jsonObject,short status) throws Exception {
//        //新增msg
////        int type = jsonObject.getInteger("type");
//        JSONArray dateTemp = new JSONArray();
//        Date now = new Date();
//        Msg msg = new Msg();
//        JSONArray data = jsonObject.getJSONArray("data");
//        for (int i=0;i<data.size();i++){
//            JSONObject  jsonObjectData = data.getJSONObject(i);
//            msg.setContent(jsonObjectData.getString("content"));
//            msg.setMsgtype(jsonObjectData.getShort("msgType"));
//            msg.setSender(jsonObjectData.getLong("sender"));
//            msg.setSenderame(jsonObjectData.getString("senderName")==null?"":jsonObjectData.getString("senderName"));
//            msg.setWindowid(jsonObjectData.getString("windowId")!=null?Long.valueOf(jsonObjectData.getString("windowId")):0);
//            msg.setCreatetime(now);
//            msg.setUpdatetime(now);
//            msg.setStatus(status);
//            msg.setTimeid(System.currentTimeMillis());
////            chatService.saveSocketMsg(msg);
//            jsonObjectData.put("timeId",msg.getTimeid().toString());
//            dateTemp.add(jsonObjectData);
//            jsonObject.put("data",dateTemp);
//        }
//    }
//    /**
//     * kafka监听关闭websocket连接
//     *
//     * @param closeMessage
//     */
//    public void kafkaCloseWebsocket(String closeMessage) {
//        JSONObject jsonObject = JSONObject.parseObject(closeMessage);
//        String userId = jsonObject.getString("userId");
//        if (drWebSocketSet.containsKey(userId)){
//            drWebSocketSet.remove(userId);
//            //从set中删除
//            subOnlineCount();
//            logger.info("用户退出:"+userId+",当前在线人数为:" + getOnlineCount());
//        }
//    }
//
//
//
//    /**
//     * 发生错误时调用
//     *
//     * @param session
//     * @param error
//     */
//    @OnError
//    public void onError(Session session, Throwable error) {
////        logger.info("webscoket发生错误!关闭websocket链接");
//        //onClose(session);
//        error.printStackTrace();
//        logger.info("webscoket发生错误!" + error.getMessage());
//    }
//
//
//    public static synchronized void addOnlineCount() {
//        ChatWebsocket.onlineCount++;
//    }
//    public static synchronized int getOnlineCount() {
//        return onlineCount;
//    }
//    public static synchronized void subOnlineCount() {
//        ChatWebsocket.onlineCount--;
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//        this.chatService = (ChatService) applicationContext.getBean("chatService");
//        this.userTokenService = (UserTokenService) applicationContext.getBean("userTokenService");
//    }
//}
