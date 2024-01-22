package com.example.ra.Service.Imp;

import com.example.ra.CustomException;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.IAddressService;
import com.example.ra.Service.IUserService;
import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.User;
import com.example.ra.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CommonService commonService;

    @Autowired
    private IUserService userService;
    @Override
    public List<Address> getAll() throws CustomException {
        User user=userService.findUserById(commonService.findUserIdInContext().getId());
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
