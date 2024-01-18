package com.example.ra.repository;

import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.WishList;
import com.example.ra.model.entity.WishListDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishListDetailRepository extends JpaRepository<WishListDetail,Long> {
    Optional<WishListDetail> findWishListDetailByWishListAndProduct(Integer wishListId, Long productId);
}
