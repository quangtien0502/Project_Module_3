package com.example.ra.controller.admin;

import com.example.ra.Mapper;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.Imp.UserServiceImp;
import com.example.ra.model.dto.Response.UserResponse;
import com.example.ra.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/users")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private CommonService commonService;

    @Autowired
    private Mapper mapper;

    @GetMapping("")
    public ResponseEntity<?> getAllEnaBle(@RequestParam(defaultValue = "5",name = "limit") int limit,
                                          @RequestParam(defaultValue = "0",name = "page") int page,
                                          @RequestParam(defaultValue = "id",name = "sortBy") String sort,
                                          @RequestParam(defaultValue = "asc",name = "order") String order){
        Pageable pageable=commonService.pagination(order,page,limit,sort);
        return new ResponseEntity<>(userServiceImp.getAll(pageable), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> changeUserStatus(@PathVariable Long userId){
        String result=userServiceImp.changeUserStatus(userId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/search/{keyWord}")
    public ResponseEntity<?> findUserByFullName(@PathVariable String keyWord){
        List<User> userList= userServiceImp.findUserByFullName(keyWord);
        List<UserResponse> userResponseList=userList.stream().map((item)->mapper.userToUserResponse(item)).toList();
        return new ResponseEntity<>(userResponseList,HttpStatus.OK);
    }
}
