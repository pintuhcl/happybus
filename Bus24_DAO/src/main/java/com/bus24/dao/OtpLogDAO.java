package com.bus24.dao;

import java.util.Map;

public interface OtpLogDAO {
public Integer saveOtp(Integer otp,Long userId);

public Map<String, Object> validateOtp(Long userId);
}
