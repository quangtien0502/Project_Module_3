package com.example.ra.Service;

import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAddressService {
    Page<Address> getAll(Pageable pageable);
    Address save(Address address);
    Address findById(Long id);
    void deleteById(Long id);
}