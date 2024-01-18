package com.example.ra.repository;

import com.example.ra.model.entity.ShoppingCartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartDetailRepository extends JpaRepository<ShoppingCartDetail,Long> {
    void deleteShoppingCartDetailByShoppingCartAndProduct(Integer shoppingCardId,Long productId);

}
