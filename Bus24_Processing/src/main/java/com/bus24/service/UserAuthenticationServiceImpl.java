package com.bus24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus24.dao.UserAuthenticationDAO;
import com.bus24.exceptions.UserNotAuthenticatedException;

@Service
public class UserAuthenticationServiceImpl
implements UserAuthenticationService{
	@Autowired
private UserAuthenticationDAO userAuthenticationDAO;
	@Override
	public boolean isAuthenticated(Long userId, String token) {
	  Integer count=userAuthenticationDAO.isAuthenticated(userId,token,1);
		if(count!=null && count>0){
		return true;	
		}else{
throw new UserNotAuthenticatedException("You Are Not Authenticated!Please Login.");			
		}
	}
}
