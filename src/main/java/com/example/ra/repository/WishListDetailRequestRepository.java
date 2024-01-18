package com.example.ra.repository;

import com.example.ra.model.dto.Request.WishList.WishListDetailRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishListDetailRequestRepository extends JpaRepository<WishListDetailRequest,Long> {
    Optional<WishListDetailRequest> findWishListDetailRequestByWishListIdAndProductId(Integer wishListId,Long productId);
}
