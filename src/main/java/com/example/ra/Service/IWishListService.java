package com.example.ra.Service;

import com.example.ra.CustomException;
import com.example.ra.model.dto.Request.WishList.WishListRequest;
import com.example.ra.model.entity.User;
import com.example.ra.model.entity.WishList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IWishListService {
    List<WishList> getAll();
    WishList save(WishList wishList);
    WishList findById(Integer id) throws CustomException;
    void deleteById(Integer id);

}
