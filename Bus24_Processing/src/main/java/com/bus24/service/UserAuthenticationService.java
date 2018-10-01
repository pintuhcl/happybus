package com.bus24.service;

public interface UserAuthenticationService  {
public boolean isAuthenticated(Long userId,String token);
}
