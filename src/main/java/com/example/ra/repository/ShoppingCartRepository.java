package com.example.ra.repository;

import com.example.ra.model.entity.Category;
import com.example.ra.model.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
}
