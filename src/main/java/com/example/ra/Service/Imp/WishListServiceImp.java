package com.example.ra.Service.Imp;

import com.example.ra.Service.IWishListService;
import com.example.ra.model.entity.WishList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WishListServiceImp implements IWishListService {
    @Override
    public Page<WishList> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public WishList save(WishList wishList) {
        return null;
    }

    @Override
    public WishList findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
