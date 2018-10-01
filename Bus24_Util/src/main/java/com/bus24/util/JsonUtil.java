/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.util;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.net.SyslogOutputStream;
/**
 * This Util class is used to convert java to json and json to java
 * @author sathish
 * @since 1.0
 */
public class JsonUtil {
private static ObjectMapper mapper;
private static Logger logger=Logger.getLogger(JsonUtil.class);
static{
	mapper=new ObjectMapper();
}
/**
 * This method is used to convert java into json by using jackson API 2.x
 * @param obj
 * @return jsonStr
 */
public static String convertJavaToJson(Object obj){
	String jsonStr="";
	try {
		if(obj!=null){
		jsonStr=mapper.writeValueAsString(obj);
		}
		} catch (JsonProcessingException e) {
logger.error("Exception Occured while converting the java obj into json : "+e.getMessage());	
	}
   return jsonStr;
}
/**
 * This method is used to convert Json into Java by using jackson API 2.x
 * @param jsonStr
 * @param  cls
 * @return T
 */
public static <T> T convertJsonToJava(String jsonStr,Class<T> cls){
	T response=null;
     try {
    	 if(jsonStr!=null && jsonStr.trim().length()>0){
		response=mapper.readValue(jsonStr,cls);
    	 }
	} catch (JsonParseException e) {
		logger.error("Exception Occured while converting the json obj into java : "+e.getMessage());	
	
	} catch (JsonMappingException e) {
		logger.error("Exception Occured while converting the json obj into java: "+e.getMessage());	

	} catch (IOException e) {
		logger.error("Exception Occured while converting the json obj into java : "+e.getMessage());	

	}	
	return response;
}

}




