package com.bus24.dao;

public interface UserAuthenticationDAO {
public Integer saveToken(String token,Long userId);

public Integer isAuthenticated(Long userId, String token, int status);
}
