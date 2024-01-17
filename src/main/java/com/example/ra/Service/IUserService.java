package com.example.ra.Service;

import com.example.ra.model.dto.Request.User.UserLogin;
import com.example.ra.model.dto.Request.User.UserRegister;
import com.example.ra.model.dto.Response.UserResponse;

public interface IUserService {

    UserResponse handleLogin(UserLogin userLogin);

    String handleRegister(UserRegister userRegister);
}
