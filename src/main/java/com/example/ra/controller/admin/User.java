package com.example.ra.controller.admin;

import com.example.ra.Service.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin/users")
public class User {
    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllEnaBle(@RequestParam(defaultValue = "5",name = "limit") int limit,
                                          @RequestParam(defaultValue = "0",name = "page") int page,
                                          @RequestParam(defaultValue = "id",name = "sortBy") String sort,
                                          @RequestParam(defaultValue = "asc",name = "order") String order){
        Pageable pageable;
        if(order.equals("asc")){
            pageable= PageRequest.of(page,limit, Sort.by(sort).ascending());
        }else {
            pageable= PageRequest.of(page,limit,Sort.by(sort).descending());
        }
        return new ResponseEntity<>(userServiceImp.getAll(pageable), HttpStatus.OK);
    }
}
