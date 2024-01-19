package com.example.ra.Service;

import com.example.ra.model.dto.Request.User.UpdatePassWord;
import com.example.ra.model.dto.Request.User.UserLogin;
import com.example.ra.model.dto.Request.User.UserRegister;
import com.example.ra.model.dto.Request.User.UserUpdateRequest;
import com.example.ra.model.dto.Response.UserResponse;
import com.example.ra.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    UserResponse handleLogin(UserLogin userLogin);

    String handleRegister(UserRegister userRegister);

    User findUserById(Long userId);

    UserResponse updateUser(User user);

    String updatePassword(UpdatePassWord updatePassWord);

    Page<User> getAll(Pageable pageable);

    List<User> findUserByFullName(String keyword);



    String changeUserStatus(Long userId);
}
