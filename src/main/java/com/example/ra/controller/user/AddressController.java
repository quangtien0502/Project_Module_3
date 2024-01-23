package com.example.ra.controller.user;

import com.example.ra.CustomException;
import com.example.ra.Mapper;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.IAddressService;
import com.example.ra.Service.IUserService;
import com.example.ra.model.dto.Request.Address.AddressRequest;
import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.User;
import jakarta.validation.Valid;
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

    @Autowired
    private Mapper mapper;

    @Autowired
    private CommonService commonService;
    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody AddressRequest addressRequest) throws CustomException {
        Address address=Address.builder()
                .user(userService.findUserById(commonService.findUserIdInContext().getId()))
                .fullAddress(addressRequest.getFullAddress())
                .phone(addressRequest.getPhone())
                .receiveName(addressRequest.getReceiveName())
                .build();
        addressService.save(address);
        User user=userService.findUserById(commonService.findUserIdInContext().getId());
        return new ResponseEntity<>(mapper.userToUserResponse(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<?> delete(@PathVariable Long addressId){
        addressService.deleteById(addressId);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<?> findById(@PathVariable Long addressId) throws CustomException {
        Address address=addressService.findById(addressId);
        if(!address.getUser().getId().equals(commonService.findUserIdInContext().getId())){
            throw new CustomException("This is not your address");
        }
        return new ResponseEntity<>(address,HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() throws CustomException {
        List<Address> addressList=addressService.getAll();
        return new ResponseEntity<>(addressList,HttpStatus.OK);
    }
}
