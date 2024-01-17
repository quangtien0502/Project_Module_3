package com.example.ra.repository;

import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
