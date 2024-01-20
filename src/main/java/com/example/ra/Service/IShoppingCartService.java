package com.example.ra.Service;

import com.example.ra.CustomException;
import com.example.ra.model.dto.Request.ShoppingCart.ShoppingCartRequest;
import com.example.ra.model.dto.Response.OrderResponse;
import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.Orders;
import com.example.ra.model.entity.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IShoppingCartService {
    List<ShoppingCart> getAll() throws CustomException;
    ShoppingCart save(ShoppingCart shoppingCart) throws CustomException;

    ShoppingCart findById(Integer id);
    void deleteOneProductById(Integer id);

    void deleteAllProductInShoppingCartOfUser() throws CustomException;

    Orders checkout(Address address) throws CustomException;

}
