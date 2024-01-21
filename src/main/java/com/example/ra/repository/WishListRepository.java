package com.example.ra.repository;

import com.example.ra.model.entity.Category;
import com.example.ra.model.entity.User;
import com.example.ra.model.entity.WishList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList,Integer> {
    List<WishList> getAllByUser(User user);
}
