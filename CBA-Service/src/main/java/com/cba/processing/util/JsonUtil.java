package com.cba.processing.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static Logger logger=Logger.getLogger(JsonUtil.class);
	private static ObjectMapper objectMapper;
	static{
   objectMapper=new ObjectMapper();		
	}
public static String convertJavaToJson(Object obj){

	String jsonStr="";
	try {
		jsonStr=objectMapper.writeValueAsString(obj);
	} catch (JsonProcessingException e) {
logger.error("Exception Occured while converting obj to json "+e);	
	}
	
	return jsonStr;
}
public static <T> T 
convertJsonToJava(String str,Class<T> cls){
	T response=null;
  try {
	response=objectMapper.readValue(str,cls);
} catch (JsonParseException e) {
	logger.error("Exception Occured while converting json to obj "+e);	
	
} catch (JsonMappingException e) {
	logger.error("Exception Occured while converting json to obj "+e);	

} catch (IOException e) {
	logger.error("Exception Occured while converting json to obj "+e);	

}	
	return response;
}
}






