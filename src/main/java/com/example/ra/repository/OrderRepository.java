package com.example.ra.repository;

import com.example.ra.model.entity.Category;
import com.example.ra.model.entity.Orders;
import com.example.ra.model.enums.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByStatus(ProductStatus status );
}
