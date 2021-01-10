package com.ist.svc.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpClientUtil {
	private static final Log logger = LogFactory.getLog(HttpClientUtil.class);

	public static String charset = "UTF-8";
	public static final String SunX509 = "SunX509";
	public static final String JKS = "JKS";
	public static final String PKCS12 = "PKCS12";
	public static final String TLS = "TLS";
	
	public static String doGet(String url) throws UnsupportedEncodingException {
		return doGet(url,null);
	}
	
	public static String doGet(String url, Map<String, String> params) throws UnsupportedEncodingException {
		if(params != null) {
			int i = 1;
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					if( i == 1){
						url +="?"+s+"="+params.get(s);
					}else{
						url +="&"+s+"="+params.get(s);
					}
					i++;
				}
			}
		}
		HttpMethod method = new GetMethod(url);
		return send(method);
	}
	
	public static String doGet(String url, Map<String, String> params, String contentCharset) throws UnsupportedEncodingException {
		if(params != null) {
			int i = 1;
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					if( i == 1){
						url +="?"+s+"="+params.get(s);
					}else{
						url +="&"+s+"="+params.get(s);
					}
					i++;
				}
			}
		}
		HttpMethod method = new GetMethod(url);
		return send(method);
	}
	
	public static String doPost(String url) throws UnsupportedEncodingException {
		return doPost(url,null);
	}
	
	public static String doPost(String url, Map<String, String> params) throws UnsupportedEncodingException {
		PostMethod method = new PostMethod(url);
		if(params != null) {
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					method.addParameter(s, value);
				}
			}
		}
		return send(method);
	}
	
	public static String doPost(String url, Map<String, String> params, String contentCharset) throws UnsupportedEncodingException {
		PostMethod method = new PostMethod(url);
		if(params != null) {
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					method.addParameter(s, value);
				}
			}
		}
		return send(method);
	}
	
	public static String doPost(String url, Map<String, String> params, int timeOut) {
		PostMethod method = new PostMethod(url);
		if(params != null) {
			for (String s : params.keySet()) {
				String value = params.get(s);
				if (s!=null && value!=null) {
					method.addParameter(s, value);
				}
			}
		}
		return send(method,timeOut);
	}
	
	private static String send(HttpMethod method,int timeOut) {
		String rs = "";
        try{
            HttpClient client = new HttpClient();   
            client.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);
            client.getHttpConnectionManager().getParams().setSoTimeout(timeOut);
            client.executeMethod(method);
            rs = method.getResponseBodyAsString();
        }catch(Exception e){
        	logger.error("HttpClientUtil.send exception:", e);
        }finally{
            if(method != null){
                method.releaseConnection();
            }
        }
        return rs;
	}
	
	public static String doXmlPost(String urlStr, String xmlStr) {
		byte[] xmlData = xmlStr.getBytes();
		BufferedReader br = null;
		HttpURLConnection urlCon = null;
		try {
			// 获得URL链接
			URL url = new URL(urlStr);
			urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setDoOutput(true);
			urlCon.setDoInput(true);
			urlCon.setUseCaches(false);
			urlCon.setRequestMethod("POST");  
			urlCon.setRequestProperty("Accept-Charset", charset);
			urlCon.setRequestProperty("Content-Type", "text/xml");
			urlCon.setRequestProperty("Content-length",String.valueOf(xmlData.length));
			DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream()); 
			printout.write(xmlData);
			printout.flush();
			printout.close();
			 //读取响应  
            br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String lines;  
            StringBuffer sb = new StringBuffer("");  
            while ((lines = br.readLine()) != null) {  
                lines = new String(lines.getBytes(), charset);
                sb.append(lines + "\r\n");
            }
            return sb.toString();
		} catch (Exception e) {
			logger.error("HttpClientUtil.doXmlPost exception:", e);
		}
		finally
		{
			try{
				br.close();
			}
			catch(Exception e){}
		}
		return null;
	}
	
	private static String send(HttpMethod method) {
		String rs = "";
        try{
            HttpClient client = new HttpClient();   
            client.executeMethod(method);
            rs = method.getResponseBodyAsString();
        }catch(Exception e){
        	logger.error("HttpClientUtil.send exception:", e);
        }finally{
            if(method != null){
                method.releaseConnection();
            }
        }
        return rs;
	}

	
	public static String jsonPost(String url, Map<String, String> params){
		
		try{
			//创建连接  
	        URL addUrl = new URL(url);  
	        HttpURLConnection connection = (HttpURLConnection) addUrl  
	                .openConnection();  
	        connection.setDoOutput(true);  
	        connection.setDoInput(true);  
	        connection.setRequestMethod("POST");  
	        connection.setUseCaches(false);  
	        connection.setInstanceFollowRedirects(true);  
	        connection.setRequestProperty("Content-Type",  
	                "application/x-www-form-urlencoded");  

	        connection.connect();
	        
	        //POST请求  
            DataOutputStream out = new DataOutputStream(  
                    connection.getOutputStream());  
            JSONObject obj = new JSONObject();
            
            for (String key : params.keySet()) {
				String val = params.get(key);
				if (key!=null && val!=null) {
					obj.put(key, val);
				}
			}
            
            out.writeBytes(obj.toString());  
            out.flush();  
            out.close();
            
            //读取响应  
            BufferedReader reader = new BufferedReader(new InputStreamReader(  
                    connection.getInputStream()));  
            String lines;  
            StringBuffer sb = new StringBuffer("");  
            while ((lines = reader.readLine()) != null) {  
                lines = new String(lines.getBytes(), "utf-8");  
                sb.append(lines);  
            }
            
            reader.close();  
            // 断开连接  
            connection.disconnect(); 
            return sb.toString();
            
		}catch(Exception ex){
			logger.error("jsonPost error["+url+"_"+params.toString()+"]===>",ex);
		}
		
		return null;
		
	}
	
	public static String doHttpPost(String url,String param){
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			StringEntity se = new StringEntity(param, "UTF-8");
			httpPost.setEntity(se);
			HttpResponse httpResponse = HttpClients.createDefault().execute(httpPost);
			String responseStr = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			return responseStr;
		} catch (Exception e) {
			logger.error("jsonPost error["+url+"_"+param+"]===>",e);
		} 
        return "";
	}
	public static String doPostJson(String url, Map<String, String> params){
		
		try{
			//创建连接  
	        URL addUrl = new URL(url);  
	        HttpURLConnection connection = (HttpURLConnection) addUrl  
	                .openConnection();  
	        connection.setDoOutput(true);  
	        connection.setDoInput(true);  
	        connection.setRequestMethod("POST");  
	        connection.setUseCaches(false);  
	        connection.setInstanceFollowRedirects(true);  
	        connection.setRequestProperty("Content-Type",  
	                "application/json");  

	        connection.connect();
	        
	        //POST请求  
            DataOutputStream out = new DataOutputStream(  
                    connection.getOutputStream());  
            JSONObject obj = new JSONObject();
            
            for (String key : params.keySet()) {
				String val = params.get(key);
				if (key!=null && val!=null) {
					obj.put(key, val);
				}
			}
            
            out.writeBytes(obj.toString());  
            out.flush();  
            out.close();
            
            //读取响应  
            BufferedReader reader = new BufferedReader(new InputStreamReader(  
                    connection.getInputStream()));  
            String lines;  
            StringBuffer sb = new StringBuffer("");  
            while ((lines = reader.readLine()) != null) {  
                lines = new String(lines.getBytes(), "utf-8");  
                sb.append(lines);  
            }
            
            reader.close();  
            // 断开连接  
            connection.disconnect(); 
            return sb.toString();
            
		}catch(Exception ex){
			logger.error("jsonPost error["+url+"_"+params.toString()+"]===>",ex);
		}
		
		return null;
		
	}
	/**
	 * get HttpURLConnection
	 * @param strUrl url地址
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	public static HttpURLConnection getHttpURLConnection(String strUrl)
			throws IOException {
		URL url = new URL(strUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url
				.openConnection();
		return httpURLConnection;
	}
	
	/**
	 * get HttpsURLConnection
	 * @param strUrl url地址
	 * @return HttpsURLConnection
	 * @throws IOException
	 */
	public static HttpsURLConnection getHttpsURLConnection(String strUrl)
			throws IOException {
		URL url = new URL(strUrl);
		HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url
				.openConnection();
		return httpsURLConnection;
	}
	
	/**
	 * 获取不带查询串的url
	 * @param strUrl
	 * @return String
	 */
	public static String getURL(String strUrl) {

		if(null != strUrl) {
			int indexOf = strUrl.indexOf("?");
			if(-1 != indexOf) {
				return strUrl.substring(0, indexOf);
			} 
			
			return strUrl;
		}
		
		return strUrl;
		
	}
	
	/**
	 * 获取查询串
	 * @param strUrl
	 * @return String
	 */
	public static String getQueryString(String strUrl) {
		
		if(null != strUrl) {
			int indexOf = strUrl.indexOf("?");
			if(-1 != indexOf) {
				return strUrl.substring(indexOf+1, strUrl.length());
			} 
			
			return "";
		}
		
		return strUrl;
	}
	
	/**
	 * 查询字符串转换成Map<br/>
	 * name1=key1&name2=key2&...
	 * @param queryString
	 * @return
	 */
	public static Map<String, String> queryString2Map(String queryString) {
		if(null == queryString || "".equals(queryString)) {
			return null;
		}
		
		Map<String, String> m = new HashMap<String, String>();
		String[] strArray = queryString.split("&");
		for(int index = 0; index < strArray.length; index++) {
			String pair = strArray[index];
			HttpClientUtil.putMapByPair(pair, m);
		}
		
		return m;
		
	}
	
	/**
	 * 把键值添加至Map<br/>
	 * pair:name=value
	 * @param pair name=value
	 * @param m
	 */
	public static void putMapByPair(String pair, Map<String, String> m) {
		
		if(null == pair || "".equals(pair)) {
			return;
		}
		
		int indexOf = pair.indexOf("=");
		if(-1 != indexOf) {
			String k = pair.substring(0, indexOf);
			String v = pair.substring(indexOf+1, pair.length());
			if(null != k && !"".equals(k)) {
				m.put(k, v);
			}
		} else {
			m.put(pair, "");
		}
	}
	
	/**
	 * BufferedReader转换成String<br/>
	 * 注意:流关闭需要自行处理
	 * @param reader
	 * @return String
	 * @throws IOException
	 */
	public static String bufferedReader2String(BufferedReader reader) throws IOException {
		StringBuffer buf = new StringBuffer();
		String line = null;
		while( (line = reader.readLine()) != null) {
			buf.append(line);
			buf.append("\r\n");
		}
				
		return buf.toString();
	}
	
	/**
	 * 处理输出<br/>
	 * 注意:流关闭需要自行处理
	 * @param out
	 * @param data
	 * @param len
	 * @throws IOException
	 */
	public static void doOutput(OutputStream out, byte[] data, int len)
			throws IOException {
		int dataLen = data.length;
		int off = 0;
		while (off < data.length) {
			if (len >= dataLen) {
				out.write(data, off, dataLen);
				off += dataLen;
			} else {
				out.write(data, off, len);
				off += len;
				dataLen -= len;
			}

			// 刷新缓冲区
			out.flush();
		}

	}
	
	/**
	 * 获取SSLContext
	 * @param trustFile 
	 * @param trustPasswd
	 * @param keyFile
	 * @param keyPasswd
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyStoreException 
	 * @throws IOException 
	 * @throws CertificateException 
	 * @throws UnrecoverableKeyException 
	 * @throws KeyManagementException 
	 */
	public static SSLContext getSSLContext(
			FileInputStream trustFileInputStream, String trustPasswd,
			FileInputStream keyFileInputStream, String keyPasswd)
			throws NoSuchAlgorithmException, KeyStoreException,
			CertificateException, IOException, UnrecoverableKeyException,
			KeyManagementException {

		// ca
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(HttpClientUtil.SunX509);
		KeyStore trustKeyStore = KeyStore.getInstance(HttpClientUtil.JKS);
		trustKeyStore.load(trustFileInputStream, HttpClientUtil
				.str2CharArray(trustPasswd));
		tmf.init(trustKeyStore);

		final char[] kp = HttpClientUtil.str2CharArray(keyPasswd);
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(HttpClientUtil.SunX509);
		KeyStore ks = KeyStore.getInstance(HttpClientUtil.PKCS12);
		ks.load(keyFileInputStream, kp);
		kmf.init(ks, kp);

		SecureRandom rand = new SecureRandom();
		SSLContext ctx = SSLContext.getInstance(HttpClientUtil.TLS);
		ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), rand);

		return ctx;
	}
	
	/**
	 * 获取CA证书信息
	 * @param cafile CA证书文件
	 * @return Certificate
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static Certificate getCertificate(File cafile)
			throws CertificateException, IOException {
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream(cafile);
		Certificate cert = cf.generateCertificate(in);
		in.close();
		return cert;
	}
	
	/**
	 * 字符串转换成char数组
	 * @param str
	 * @return char[]
	 */
	public static char[] str2CharArray(String str) {
		if(null == str) return null;
		
		return str.toCharArray();
	}
	
	/**
	 * 存储ca证书成JKS格式
	 * @param cert
	 * @param alias
	 * @param password
	 * @param out
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static void storeCACert(Certificate cert, String alias,
			String password, OutputStream out) throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, IOException {
		KeyStore ks = KeyStore.getInstance("JKS");

		ks.load(null, null);

		ks.setCertificateEntry(alias, cert);

		// store keystore
		ks.store(out, HttpClientUtil.str2CharArray(password));

	}
	
	public static InputStream String2Inputstream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}
	
	/**
	 * InputStream转换成Byte
	 * 注意:流关闭需要自行处理
	 * @param in
	 * @return byte
	 * @throws Exception
	 */
	public static byte[] InputStreamTOByte(InputStream in) throws IOException{  
		
		int BUFFER_SIZE = 4096;  
		ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
        byte[] data = new byte[BUFFER_SIZE];  
        int count = -1;  
        
        while((count = in.read(data,0,BUFFER_SIZE)) != -1)  
            outStream.write(data, 0, count);  
          
        data = null;  
        byte[] outByte = outStream.toByteArray();
        outStream.close();
        
        return outByte;  
    } 
	
	/**
	 * InputStream转换成String
	 * 注意:流关闭需要自行处理
	 * @param in
	 * @param encoding 编码
	 * @return String
	 * @throws Exception
	 */
	public static String InputStreamTOString(InputStream in,String encoding) throws IOException{
        return new String(InputStreamTOByte(in),encoding);
    }
	
	public static String httpRequest(String url, String data, String method, String contenttype) {
        PrintWriter out = null;
        BufferedReader br = null;
        String result = "";
        try {
            URL rqPath = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) rqPath.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", contenttype);
            conn.setRequestMethod(method);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);

            // conn.connect();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.write(data);// 发送
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
	
	public static void main(String args[]){
		String url="http://127.0.0.1/bms_pay/outnet/funsionNotify.action";
		Map<String, String> params=new HashMap<String, String>();
		params.put("mobile", "13816925801");
		// 合作方订单号
		params.put("orderno", "20150408002");
		// 视讯订单号
		params.put("logno", "143396001");
		// 操作类型 1:订购  3:退订
		params.put("state", "1");
		// 运营商类型:1:移动  2:电信  3:联通
		params.put("optype", "1");
		
		params.put("result", "DELIVRD");
		params.put("sendtime", "20150408130000");
		params.put("identityid", "");
		params.put("pid", "59450");
		params.put("msg", "85");
		params.put("amount", "1500");		
		
//		String url="http://127.0.0.1/bms_paymentservice/service/BmsTradeBankOrderUnsub.do?";
//		Map<String, String> params=new HashMap<String, String>();
//		params.put("txnid", "201411170100010857"); // 视讯订单号
//		params.put("parenttxnid", "00000129799900001");  // SDK平台订单唯一标识
//		params.put("balancedate", "20141117"); // 交易日期
//		params.put("banktype", BmsPayConstant.BANK_TYPE_OUTNET_CM);
//		params.put("payway", BmsPayConstant.PAY_WAY_OUTNET_PAY);
//		params.put("ip", "127.0.0.1");
//		params.put("plat", "PC");
//		params.put("area", "00");
		
//		String url="http://127.0.0.1/bms_pay/tenpay/weixinNotify.action";
//		Map<String, String> params=new HashMap<String, String>();
//		params.put("transport_fee", "0");
//		params.put("trade_state", "0");
//		params.put("trade_mode", "1");
//		params.put("sign_type", "MD5");
//		params.put("input_charset", "UTF-8");
//		params.put("fee_type", "1");
//		params.put("out_trade_no", "201411250100010916");
//		params.put("transaction_id", "1222088901201411256087838437");
//		params.put("discount", "0");
//		params.put("sign", "D16E6DFCEE1E37C6769212E96F87D1BC");
//		params.put("total_fee", "1");
//		params.put("time_end", "20141125112516");
//		params.put("partner", "1222088901");
//		params.put("notify_id", "RXsEnuCXdx1dnfbxGUXgwE1SW-uoGp0wmqiym_F5ooaDgc4nmiZcU_2IfNBOlWZwdeLAvVfICh_21tPJLUmrYSu1iLIcXhI8");
//		params.put("bank_type", "2011");
//		params.put("product_fee", "1");
		
		String resp=null;
		try {
//			url=HttpClientUtil.generationPaymentUrl(url,params);
			resp = HttpClientUtil.doPost(url, params);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resp);
	}

	
}
