package com.ist.svc.controller;

import com.ist.svc.domain.ShopApp;
import com.ist.svc.service.ShopAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.Socket;
import java.net.SocketException;

/**
 * @Author: sunhaitao
 */
@Controller
public class TestController {
    @Autowired
    private ShopAppService shopAppService;

    @RequestMapping(value = "/test")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/upload")
    public String upload(){
        return "upload";
    }

    @RequestMapping(value="/getAppIdSecret")
    public @ResponseBody String getAppIdSecret(@RequestParam("appId") String appId) {
        ShopApp appInfo = shopAppService.queryShopApp(appId);
//        if (null == appInfo){
//            return appId + "不存在";
//        }
        return appInfo.getAppSecret();
    }
    @RequestMapping(value="/ab")
    public @ResponseBody String ab(){
        return "ab";
    }

    public static void main(String[] args) throws SocketException {
        Socket socket = new Socket();
        System.out.println(socket.getSendBufferSize());

        System.out.println(socket.getReceiveBufferSize());

        //重置缓冲区大小

        socket.setSendBufferSize(1024*32);

        socket.setReceiveBufferSize(1024*32);
        System.out.println(socket.getSendBufferSize());

        System.out.println(socket.getReceiveBufferSize());
    }

}
