package com.example.ra.repository;

import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> getAllByUser(User user);
}
