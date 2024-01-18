package com.example.ra.repository;

import com.example.ra.model.entity.Category;
import com.example.ra.model.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList,Integer> {
}
