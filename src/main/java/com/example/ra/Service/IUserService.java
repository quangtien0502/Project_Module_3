package com.example.ra.Service;

import com.example.ra.CustomException;
import com.example.ra.model.dto.Request.User.UpdatePassWord;
import com.example.ra.model.dto.Request.User.UserLogin;
import com.example.ra.model.dto.Request.User.UserRegister;
import com.example.ra.model.dto.Request.User.UserUpdateRequest;
import com.example.ra.model.dto.Response.UserResponse;
import com.example.ra.model.entity.Orders;
import com.example.ra.model.entity.User;
import com.example.ra.model.enums.ProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    UserResponse handleLogin(UserLogin userLogin);

    String handleRegister(UserRegister userRegister);

    User findUserById(Long userId) throws CustomException;

    User updateUser(User user);

    String updatePassword(UpdatePassWord updatePassWord);

    Page<User> getAll(Pageable pageable);

    List<User> findUserByFullName(String keyword);

    List<Orders> orderedHistory(ProductStatus productStatus);

    String changeUserStatus(Long userId) throws CustomException;
}
