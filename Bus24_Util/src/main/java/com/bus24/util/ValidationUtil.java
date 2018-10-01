package com.bus24.util;

public class ValidationUtil {
public static boolean isValidEmail(String email){
	if(email!=null){
	String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	return email.matches(EMAIL_REGEX);
	}
	else{
		return false;
	}
}
public static boolean isValidMobile(String mobile){
	if(mobile!=null){
	String MOBILE_REGEX="\\d{10}";
return mobile.matches(MOBILE_REGEX);
	}else{
		return false;
	}
}
public static boolean isValidPassword(String password){
	if(password!=null){
	String PASSWORD_REGEX= "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
			return password.matches(PASSWORD_REGEX);
	}else{
		return false;
	}
	}
}
