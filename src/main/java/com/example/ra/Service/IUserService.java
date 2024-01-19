package com.example.ra.Service;

import com.example.ra.model.dto.Request.User.UpdatePassWord;
import com.example.ra.model.dto.Request.User.UserLogin;
import com.example.ra.model.dto.Request.User.UserRegister;
import com.example.ra.model.dto.Request.User.UserUpdateRequest;
import com.example.ra.model.dto.Response.UserResponse;
import com.example.ra.model.entity.User;

public interface IUserService {
    UserResponse handleLogin(UserLogin userLogin);

    String handleRegister(UserRegister userRegister);

    UserResponse updateUser(UserUpdateRequest userUpdateRequest);

    String updatePassword(UpdatePassWord updatePassWord);
}
