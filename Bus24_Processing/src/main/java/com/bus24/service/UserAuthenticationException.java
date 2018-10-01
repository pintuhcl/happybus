package com.bus24.service;

public class UserAuthenticationException extends RuntimeException {
public UserAuthenticationException(){
}
public UserAuthenticationException(String msg){
	super(msg);
}
public UserAuthenticationException(Exception e){
	super(e);
}
}
