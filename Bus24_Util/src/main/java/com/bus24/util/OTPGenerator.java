package com.bus24.util;

public class OTPGenerator {
public static int generateOtp(){
	 //generate a 4 digit integer 1000 <10000
    int randomPIN = (int)(Math.random()*9000)+1000;
return randomPIN;
}

}
