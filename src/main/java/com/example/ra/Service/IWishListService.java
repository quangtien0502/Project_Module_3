package com.example.ra.Service;

import com.example.ra.model.dto.Request.WishList.WishListRequest;
import com.example.ra.model.entity.WishList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IWishListService {
    Page<WishList> getAll(Pageable pageable);
    WishList save(WishListRequest wishListRequest);
    WishList findById(Long id);
    void deleteById(Long id);
}
