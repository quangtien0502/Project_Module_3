package com.example.ra.Service;

import com.example.ra.CustomException;
import com.example.ra.model.dto.Request.Address.AddressRequest;
import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAddressService {
    List<Address> getAll() throws CustomException;
    Address save(Address address);
    Address findById(Long id) throws CustomException;
    void deleteById(Long id);
}
