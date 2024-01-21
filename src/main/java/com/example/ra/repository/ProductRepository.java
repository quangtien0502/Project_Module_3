package com.example.ra.repository;

import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByProductNameContainingOrDescriptionContaining(String categoryName,String description);

    Page<Product> findAllByStatus(Boolean status, Pageable pageable);
}
