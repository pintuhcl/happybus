package com.bus24.web.service;

import com.bus24.beans.Response;
import com.bus24.beans.User;

public interface UserService {
public String registerPassenger(User user);

public String validateOtp(String jsonOtp);

public String resendOtp(String jsonUser);

public Response loginUser(User user);

public String forgotPassword(String forgotinput);

public String updateLogoutStatus(Long userId);

public String checkUserAccount(User user);

public User myProfile(String userName);

public String updateProfile(User user);

public String changePassword(String userName, String currentPassword, String newPassword, String confirmPassword);

}
