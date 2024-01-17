package com.example.ra.Service.Imp;

import com.example.ra.Service.IAddressService;
import com.example.ra.model.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImp implements IAddressService {
    @Override
    public Page<Address> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public Address findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
