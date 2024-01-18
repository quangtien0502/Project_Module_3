package com.example.ra.Service.Imp;

import com.example.ra.Service.IWishListService;
import com.example.ra.model.dto.Request.WishList.WishListRequest;
import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.User;
import com.example.ra.model.entity.WishList;
import com.example.ra.repository.ProductRepository;
import com.example.ra.repository.UserRepository;
import com.example.ra.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Override
    public WishList save(WishListRequest wishListRequest) {
        User userExist = userRepository.findById(wishListRequest.getUserId()).orElseThrow(() -> new RuntimeException("No User exists"));
        Product productExist = productRepository.findById(wishListRequest.getProductId()).orElseThrow(() -> new RuntimeException("No Product Exist"));
        return wishListRepository.save(WishList.builder()
                .user(userExist)
                        .product(productExist)
                        .id(wishListRequest.getId())
                .build());
    }

    @Override
    public WishList findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
