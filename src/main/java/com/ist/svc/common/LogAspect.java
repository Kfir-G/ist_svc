package com.ist.svc.common;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ist.svc.config.annotation.Logging;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Aspect 
public class LogAspect {
	
//	protected Logger logger;
//	@Autowired
//	LogMapper logMapper;
//
//	public LogAspect() {
//
//    }
//
//	@Around("within(com.tv189.tm.api.service..*) && @annotation(la)")
//    public Object addLog(ProceedingJoinPoint jp, Logging la) throws Throwable{
//		logger.info("Enter LogAspect...");
//		Object retObj = null;
//
//		if(la.opeType() == 1 || la.opeType() == 2){
//			retObj = jp.proceed();
//		}
//
//		//获取目标方法体参数
//		Object[] parames = jp.getArgs();
//
//		//解析目标方法体的参数 得到操作对象
//		String objectId = parseParames(parames);
//		ShiroUser currentUser = MySession.getCurrentLoginUser();
//
//		if(la.opeType() >= 3){
//			retObj = jp.proceed();
//		}
//		//构建日志对象
//		Log record=new Log();
//		if (StringUtils.isNoneEmpty(objectId) && objectId.length()>2048) {
//			objectId = objectId.substring(0,2040) + "...";
//		}
//		record.setOperateObjectId(objectId);
//		if(currentUser != null){
//			record.setOperateUserId(currentUser.getId());
//		}else{
//			record.setOperateUserId(new Long(0));
//		}
//		record.setOperateType(la.opeType());
//		record.setOperateContent(la.desc());
//		record.setModuleType(la.modType().getType());
//
//		String objectName=getOptName(la.modType(),objectId);
//		if (StringUtils.isNoneEmpty(objectName) && objectName.length()>2048) {
//			objectName = objectName.substring(0,2040) + "...";
//		}
//		record.setOperateObjectName(objectName);
//
//
//		logMapper.insert(record);
//		logger.info("Save logging ===>"+record.toString());
//
//		logger.info("Out LogAspect...");
//		return retObj;
//	}
//
//	private String getOptName(Module type,String objectId){
//
//		String[] ids=StringUtils.split(objectId, ",");
//
//		String names="";
//		if (null!=ids){
//			for(String id:ids){
//				Map<String,Object> param=new HashMap<String,Object>();
//				param.put("table", type.getTable());
//				param.put("column", type.getColumn());
//				param.put("id", new BigDecimal(id));
//				String name=null;
//				try{
//					name=logMapper.selectName(param);
//				}catch(Exception ex){
//					logger.error("SelectName error::objectId["+objectId+"]===>",ex);
//					return null;
//				}
//				names+=name+",";
//			}
//		}
//		return StringUtils.substringBeforeLast(names, ",");
//	}
//
//	private String parseParames(Object[] parames) {
//
//		//无参数
//		if(parames.length == 0){
//			return null;
//		}
//		//一个String参数
//		if(parames.length == 1 && parames[0] instanceof String){
//			String id=(String)parames[0];
//			if(id.indexOf(",") > 0){
//				return id;
//			}
//			return StringUtils.isNumeric(id)?id:null;
//		}
//		//一个String数组
//		if(parames.length == 1 && parames[0] instanceof String[]){
//			String[] ids=(String[])parames[0];
//			String str="";
//			for(String id:ids){
//				if(StringUtils.isNumeric(id)){
//					str += id+",";
//				}
//			}
//			return StringUtils.substringBeforeLast(str, ",");
//		}
//
//		//多个String参数,取第一个参数作为日志对象ID
//		if(parames.length > 1){
//			Pattern r = Pattern.compile("^([\\d]+[,]{1}[\\d]+)+$");
//			if(parames[0] instanceof String && r.matcher((String)parames[0]).find()){
//				return (String)parames[0];
//			}
//		}
//		if(parames.length > 1){
//			if(parames[0] instanceof String && StringUtils.isNumeric((String)parames[0])){
//				return (String)parames[0];
//			}
//		}
//
//		if(parames[0] instanceof Long){
//			return String.valueOf(parames[0]);
//		}
//
//		//参数里的对象找ID
//		StringWriter writer = new StringWriter();
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			JsonGenerator generator = new JsonFactory().createGenerator(writer);
//			mapper.writeValue(generator, parames);
//			generator.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		Pattern r = Pattern.compile("\\\"id\\\":(\\d+),");
//		String line=writer.toString();
//		Matcher m = r.matcher(line);
//	    if (m.find()){
//	    	 return m.group(1);
//	    }
//	    return null;
//	 }
//	 public static void main(String[] args){
//		 String content="{[\"id\":123333,\"name\":\"小明\"]}";
//		 Pattern r = Pattern.compile("\\\"id\\\":(\\d+),");
//		 Matcher m = r.matcher(content);
//		 if (m.find()){
//	    	 System.out.println(m.group(2));
//	    }
//	 }
	 
}
