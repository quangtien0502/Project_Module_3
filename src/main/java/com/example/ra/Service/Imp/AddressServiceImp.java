package com.example.ra.Service.Imp;

import com.example.ra.Service.IAddressService;
import com.example.ra.model.dto.Request.Address.AddressRequest;
import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.User;
import com.example.ra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImp implements IAddressService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Page<Address> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Address save(AddressRequest addressRequest) {
        User userExist=userRepository.findById(addressRequest.getUserId()).orElseThrow(()->new RuntimeException("Run Time doesn't Exist"));
        return Address.builder()
                .id(addressRequest.getId())
                .fullAddress(addressRequest.getFullAddress())
                .phone(addressRequest.getPhone())
                .receiveName(addressRequest.getReceiveName())
                .user(userExist)
                .build();
    }

    @Override
    public Address findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
