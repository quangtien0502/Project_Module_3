package com.example.ra.repository;

import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
