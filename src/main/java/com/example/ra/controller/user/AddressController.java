package com.example.ra.controller.user;

import com.example.ra.CustomException;
import com.example.ra.Service.IAddressService;
import com.example.ra.Service.IUserService;
import com.example.ra.model.dto.Request.Address.AddressRequest;
import com.example.ra.model.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;
    @Autowired
    private IUserService userService;
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody AddressRequest addressRequest) throws CustomException {
        Address address=Address.builder()
                .user(userService.findUserById(addressRequest.getUserId()))
                .fullAddress(addressRequest.getFullAddress())
                .phone(addressRequest.getPhone())
                .receiveName(addressRequest.getReceiveName())
                .build();
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<?> delete(@PathVariable Long addressId){
        addressService.deleteById(addressId);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<?> findById(@PathVariable Long addressId) throws CustomException {
        Address address=addressService.findById(addressId);
        return new ResponseEntity<>(address,HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() throws CustomException {
        List<Address> addressList=addressService.getAll();
        return new ResponseEntity<>(addressList,HttpStatus.OK);
    }
}
