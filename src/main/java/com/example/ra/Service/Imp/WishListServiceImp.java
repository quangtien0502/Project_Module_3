package com.example.ra.Service.Imp;

import com.example.ra.Service.IWishListService;
import com.example.ra.model.dto.Request.WishList.WishListRequest;
import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.User;
import com.example.ra.model.entity.WishList;
import com.example.ra.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServiceImp implements IWishListService {
    @Autowired
    private WishListRepository wishListRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;



    @Override
    public Page<WishList> getAll(Pageable pageable) {
        return null;
    }


    //Todo: Haven't finish the save
    @Override
    public WishList save(WishListRequest wishListRequest) {
        return new WishList();
    }

    @Override
    public WishList findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
