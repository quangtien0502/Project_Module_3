package com.example.ra.Service.Imp;

import com.example.ra.CustomException;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.IAddressService;
import com.example.ra.model.dto.Request.Address.AddressRequest;
import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.User;
import com.example.ra.repository.AddressRepository;
import com.example.ra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CommonService commonService;
    @Override
    public List<Address> getAll() {
        User user=commonService.findUserIdInContext();
        return addressRepository.getAllByUser(user);
    }

    @Override
    public Address save(Address addressRequest) {
        return new Address(addressRequest.getId(),addressRequest.getUser(),addressRequest.getFullAddress(), addressRequest.getPhone(), addressRequest.getReceiveName());
    }

    @Override
    public Address findById(Long id) throws CustomException {
        return addressRepository.findById(id).orElseThrow(()->new CustomException("No Address Found"));
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
