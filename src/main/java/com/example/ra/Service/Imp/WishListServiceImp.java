package com.example.ra.Service.Imp;

import com.example.ra.CustomException;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.IWishListService;
import com.example.ra.model.entity.User;
import com.example.ra.model.entity.WishList;
import com.example.ra.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServiceImp implements IWishListService {
    @Autowired
    private WishListRepository wishListRepository;
    @Autowired
    private CommonService commonService;
    @Override
    public List<WishList> getAll() {
        User user=commonService.findUserIdInContext();
        return wishListRepository.getAllByUser(user);
    }

    //Todo: Haven't finish the save
    @Override
    public WishList save(WishList wishListRequest) {
        return wishListRepository.save(wishListRequest);
    }

    @Override
    public WishList findById(Integer id) throws CustomException {
        return wishListRepository.findById(id).orElseThrow(()->new CustomException("No WishList Found for this Id"));
    }

    @Override
    public void deleteById(Integer id) {
        wishListRepository.deleteById(id);
    }
}
