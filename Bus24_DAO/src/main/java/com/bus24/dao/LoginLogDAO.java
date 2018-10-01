package com.bus24.dao;

import com.bus24.beans.LoginLog;

public interface LoginLogDAO {

	Integer saveLoginLogDetails(LoginLog loginLog, Long userId);

}
