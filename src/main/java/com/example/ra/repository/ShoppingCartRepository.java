package com.example.ra.repository;

import com.example.ra.model.entity.Category;
import com.example.ra.model.entity.ShoppingCart;
import com.example.ra.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
    ShoppingCart findByUser(User user);
}
