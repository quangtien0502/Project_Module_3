package com.example.ra.controller.user;

import com.example.ra.CustomException;
import com.example.ra.Mapper;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.IAddressService;
import com.example.ra.Service.IUserService;
import com.example.ra.model.dto.Request.User.UserUpdateRequest;
import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/user/users")
public class UserControllerForUser {
    @Autowired
    private IUserService userService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private Mapper mapper;

    @GetMapping("")
    public ResponseEntity<?> getInformation() throws CustomException {
        User user=userService.findUserById(commonService.findUserIdInContext().getId());
        return new ResponseEntity<>(mapper.userToUserResponse(user), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateInformation(@RequestBody UserUpdateRequest userUpdateRequest) throws CustomException {
        User user=userService.findUserById(commonService.findUserIdInContext().getId());
        user.setFullName(userUpdateRequest.getFullName());
        user.setEmail(userUpdateRequest.getEmail());
        user.setUserName(userUpdateRequest.getUserName());
        user.setPhone(userUpdateRequest.getPhone());
        User userNew=userService.updateUser(user);
        String addressName=userUpdateRequest.getAddress();
        Address address=new Address(null,userNew,addressName,userUpdateRequest.getPhone(),userUpdateRequest.getFullName());
        addressService.save(address);
        return new ResponseEntity<>(mapper.userToUserResponse(userNew),HttpStatus.OK);
    }


}
