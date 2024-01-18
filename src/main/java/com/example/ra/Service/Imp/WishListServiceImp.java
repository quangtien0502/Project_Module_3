package com.example.ra.Service.Imp;

import com.example.ra.Service.IWishListService;
import com.example.ra.model.dto.Request.WishList.WishListDetailRequest;
import com.example.ra.model.dto.Request.WishList.WishListRequest;
import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.User;
import com.example.ra.model.entity.WishList;
import com.example.ra.model.entity.WishListDetail;
import com.example.ra.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishListServiceImp implements IWishListService {
    @Autowired
    private WishListRepository wishListRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WishListDetailRepository wishListDetailRepository;


    @Override
    public Page<WishList> getAll(Pageable pageable) {
        return null;
    }


    @Override
    public WishList save(WishListRequest wishListRequest) {
        User userExist = userRepository.findById(wishListRequest.getUserId()).orElseThrow(() -> new RuntimeException("No User exists"));

        List<Product> listProductExist = wishListRequest.getListProductId().stream().map((productId) -> productRepository.findById(productId).orElseThrow(() -> new RuntimeException("No Product Exist like that"))).toList();
        ;
        WishList wishListFinal = WishList.builder()
                .id(wishListRequest.getId())
                .user(userExist)
                .build();
        if (wishListRequest.getId() != null) {
            //Update
            WishList wishlistCurrent = wishListRepository.findById(wishListRequest.getId()).orElseThrow(() -> new RuntimeException("No wish list like this"));
            //Insert Or Update Wish List Detail based on the request
            for (Product product :
                    listProductExist) {
                WishListDetail wishListDetail = wishListDetailRepository.findWishListDetailByWishListAndProduct(wishListFinal, product).orElse(null);
                if(wishListDetail==null) {
                    // Doesn't exist wish list detail so we should insert
                    WishListDetail wishListDetailNew = WishListDetail.builder().wishList(wishlistCurrent).product(product).build();
                    wishListDetailRepository.save(wishListDetailNew);
                }
            }
            wishListFinal.setWishListDetails(wishlistCurrent.getWishListDetails());
            wishListRepository.save(wishListFinal);
        } else {
            //insert
            wishListRepository.save(wishListFinal);
            WishList wishlistCurrent = wishListRepository.findById(wishListFinal.getId()).orElseThrow(() -> new RuntimeException("No wish list like this"));

            //Insert Or Update Wish List Detail based on the request
            for (Product product :
                    listProductExist) {
                WishListDetail wishListDetail = wishListDetailRepository.findWishListDetailByWishListAndProduct(wishListFinal, product).orElse(null);
                if(wishListDetail==null) {
                    // Doesn't exist wish list detail so we should insert
                    WishListDetail wishListDetailNew = WishListDetail.builder().wishList(wishlistCurrent).product(product).build();
                    wishListDetailRepository.save(wishListDetailNew);
                }
            }
            wishListFinal.setWishListDetails(wishlistCurrent.getWishListDetails());
            wishListRepository.save(wishListFinal);
        }

        return wishListRepository.save(wishListFinal);
    }

    @Override
    public WishList findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
