package com.bus24.util;

import java.util.Random;

public class PasswordGenerator {
public static String generatePassword(){
	 String CHAR_LIST =
	        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#@$";
	     int RANDOM_STRING_LENGTH = 6;
	     
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
