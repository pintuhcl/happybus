package com.bus24.exceptions;

public class UserNotAuthenticatedException extends RuntimeException {
public UserNotAuthenticatedException(){
	super();
}
public UserNotAuthenticatedException(String msg){
	super(msg);
}
}
