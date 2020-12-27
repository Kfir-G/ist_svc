//package com.ist.svc.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//
///**
// * 开启WebSocket支持
// * @Author: sunhaitao
// */
//@Configuration
//public class WebSocketConfig {
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
//
////    @Override
////    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
////        registry.addHandler(handler(), "/webSocket");
////        registry.addHandler(handler(), "/webSocket/socketJs").withSockJS();
////    }
//}
