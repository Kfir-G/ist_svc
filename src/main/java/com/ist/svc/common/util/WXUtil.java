package com.ist.svc.common.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.ist.svc.config.IstConfig;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WXUtil {
	@Autowired
	private IstConfig istConfig;

	/**
	 * 获取微信小程序 session_key 和 openid
	 *
	 * @param code 调用微信登陆返回的Code
	 * @return
	 */
	public JSONObject getSessionKeyOropenid(String code) {
	    //微信端登录code值
	    String requestUrl = istConfig.getWeixinSnsUrl();  //请求地址 https://api.weixin.qq.com/sns/jscode2session
	    Map<String, String> requestUrlParam = new HashMap<String, String>();
	    requestUrlParam.put("appid", istConfig.getWeixinSnsAppId());  //开发者设置中的appId
	    requestUrlParam.put("secret", istConfig.getWeixinSnsAppSecret()); //开发者设置中的appSecret
	    requestUrlParam.put("js_code", code); //小程序调用wx.login返回的code
	    requestUrlParam.put("grant_type", istConfig.getWeixinSnsGrantType());    //默认参数 authorization_code
	 
	    //发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识
	    JSONObject jsonObject = JSON.parseObject(sendPost(requestUrl, requestUrlParam));
	    return jsonObject;
	}
	 
	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url 发送请求的 URL
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, Map<String, ?> paramMap) {
	    PrintWriter out = null;
	    BufferedReader in = null;
	    String result = "";
	 
	    String param = "";
	    Iterator<String> it = paramMap.keySet().iterator();
	 
	    while (it.hasNext()) {
	        String key = it.next();
	        param += key + "=" + paramMap.get(key) + "&";
	    }
	 
	    try {
	        URL realUrl = new URL(url);
	        // 打开和URL之间的连接
	        URLConnection conn = realUrl.openConnection();
	        // 设置通用的请求属性
	        conn.setRequestProperty("accept", "*/*");
	        conn.setRequestProperty("connection", "Keep-Alive");
	        conn.setRequestProperty("Accept-Charset", "utf-8");
	        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	        // 发送POST请求必须设置如下两行
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        // 获取URLConnection对象对应的输出流
	        out = new PrintWriter(conn.getOutputStream());
	        // 发送请求参数
	        out.print(param);
	        // flush输出流的缓冲
	        out.flush();
	        // 定义BufferedReader输入流来读取URL的响应
	        in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        String line;
	        while ((line = in.readLine()) != null) {
	            result += line;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    //使用finally块来关闭输出流、输入流
	    finally {
	        try {
	            if (out != null) {
	                out.close();
	            }
	            if (in != null) {
	                in.close();
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	    return result;
	}
	 
	 /**
	     * 解密用户敏感数据获取用户信息
	     *
	     * @param sessionKey    数据进行加密签名的密钥
	     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
	     * @param iv            加密算法的初始向量
	     * @return
	     * */
	 public static JSONObject getUserInfo(String encryptedData, String sessionKey, String iv){
	        // 被加密的数据
	        byte[] dataByte = Base64.decode(encryptedData);
	        // 加密秘钥
	        byte[] keyByte = Base64.decode(sessionKey);
	        // 偏移量
	        byte[] ivByte = Base64.decode(iv);
	 
	        try {
	            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
	            int base = 16;
	            if (keyByte.length % base != 0) {
	                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
	                byte[] temp = new byte[groups * base];
	                Arrays.fill(temp, (byte) 0);
	                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
	                keyByte = temp;
	            }
	            // 初始化
	            Security.addProvider(new BouncyCastleProvider());
	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
	            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
	            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
	            parameters.init(new IvParameterSpec(ivByte));
	            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
	            byte[] resultByte = cipher.doFinal(dataByte);
	            if (null != resultByte && resultByte.length > 0) {
	                String result = new String(resultByte, "UTF-8");
	                return JSONObject.parseObject(result);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
	    public static void main(String[] args){
	    	WXUtil wXutil = new WXUtil();
	    	JSONObject o = wXutil.getSessionKeyOropenid("021IGYZ01ZSwcZ15owY01cA0011IGYZT");
	    	//{"openid":"opBfi5P_rvNdWqvDYpkUvozJMS-c","session_key":"Tjf3dj7epX7u3uXFSTtmkA=="}
	    	System.out.println(o);
//	    	System.out.println(o.getString("errcode"));
//	    	System.out.println(o.getString("session_key"));
//	    	System.out.println(o.getString("openid"));

	    	
//	    	System.out.println(getUserInfo("E2VImrEfhP1R1E+s+UtD4/VOzWGO3XxCwhsOoyJ8oh0x3MxRmm53PNB4RnSeiNV8Jk9Z9pN4AmQcwAiI2wKuLO2v6iqkBiexiir+zFIhOHByvS0D0AmB8u/JJuXxFMlYwlJTL9wTlcZxjOH9kavOyQ1FnX2yfj4Rxxm6t6JR2cztLXIxS1TZHJDbMCTk03hanKVThK6nMJpuHw2o7bWj1Yi0/VLYQLcZHS8ag5uG48F7OngnIpPmQ5u7IZNGXHnsSpmhglx8/v5ZCEJTtVdSBXCaY5JSjFV+EGQX3dXrhfDV6UjKSsXzIIxMbs/84JgOpJDQzVJcSwiMyHV0+Skeo4VfK/C1wiLqqbb69JE/pHU44Ri10byWmRMSTlPAFYg5CC8iBMW4sCl8x8BdbTrvF4o2d8yDdNyNfjYvuZen0ZG9XZ7HAZkGOp3hrW/GooSPtBMALXddhuFCz0z1U3h0ytXzd41XsHbKgR8MxN6P6j5TtF1hh5hPj/FI8CMJPahS",o.getString("session_key"),"7ddyDPvkIczYZz9C8tqo4w=="));
	    	
	    }
	
	
}
