package com.example.ra.Service;

import com.example.ra.model.dto.Request.UserLogin;
import com.example.ra.model.dto.Request.UserRegister;
import com.example.ra.model.dto.Response.JwtResponse;
import com.example.ra.model.dto.Response.UserResponse;

public interface IUserService {

    UserResponse handleLogin(UserLogin userLogin);

    String handleRegister(UserRegister userRegister);
}
