package com.bus24.util;

import java.util.Random;

public class TokenUtil {
	private static final String CHAR_LIST =
	        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#@$";
	    private static final int RANDOM_STRING_LENGTH = 16;
	     
	  
	    public static String generateToken(){
	         
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	        	Random randomGenerator = new Random();
		       int randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		       char ch = CHAR_LIST.charAt(randomInt);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }
	    
	  
}
