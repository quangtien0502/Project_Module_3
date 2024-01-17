package com.example.ra.repository;

import com.example.ra.model.entity.Category;
import com.example.ra.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
