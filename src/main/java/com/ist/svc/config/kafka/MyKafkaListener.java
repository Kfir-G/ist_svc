//package com.ist.svc.config.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.springframework.kafka.annotation.KafkaListener;
//
//import javax.annotation.Resource;
//
///**
// * @Author: sunhaitao
// */
//public class MyKafkaListener {
//    @Resource(name="all_log")
//    private Logger logger;
//    /**
//     * 发送聊天消息时的监听
//     * @param record
//     */
//    @KafkaListener(topics = {"chatMessage"})
//    public void listen(ConsumerRecord<?, ?> record) {
//        logger.info("chatMessage发送聊天消息监听："+record.value().toString());
//        ChatWebsocket chatWebsocket = new ChatWebsocket();
//        chatWebsocket.kafkaReceiveMsg(record.value().toString());
//    }
//
//    /**
//     * 关闭连接时的监听
//     * @param record
//     */
//    @KafkaListener(topics = {"closeWebsocket"})
//    private void closeListener(ConsumerRecord<?, ?> record) {
//        logger.info("closeWebsocket关闭websocket连接监听："+record.value().toString());
//        ChatWebsocket chatWebsocket = new ChatWebsocket();
//        chatWebsocket.kafkaCloseWebsocket(record.value().toString());
//    }
//}
