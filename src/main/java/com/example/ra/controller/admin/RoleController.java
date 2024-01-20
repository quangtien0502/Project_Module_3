package com.example.ra.controller.admin;

import com.example.ra.Service.Imp.RoleServiceImp;
import com.example.ra.model.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/role")
public class RoleController {
    @Autowired
    private RoleServiceImp roleServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<Role> listRole=roleServiceImp.findAll();
        return new ResponseEntity<>(listRole, HttpStatus.OK);
    }
}
