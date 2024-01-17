package com.example.ra.Service;

import com.example.ra.model.entity.WishList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IWishListService {
    Page<WishList> getAll(Pageable pageable);
    WishList save(WishList wishList);
    WishList findById(Long id);
    void deleteById(Long id);
}
