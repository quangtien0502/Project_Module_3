package com.example.ra.repository;

import com.example.ra.model.entity.Category;
import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.ShoppingCart;
import com.example.ra.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
    List<ShoppingCart> findByUser(User user);

    Boolean existsByUserAndProduct(User user, Product product);

    ShoppingCart findByUserAndProduct(User user,Product product);

    void deleteAllByUser(User user);
}
