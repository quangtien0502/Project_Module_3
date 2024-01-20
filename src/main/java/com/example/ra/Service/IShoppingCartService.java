package com.example.ra.Service;

import com.example.ra.model.dto.Request.ShoppingCart.ShoppingCartRequest;
import com.example.ra.model.entity.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

public interface IShoppingCartService {
    Page<ShoppingCart> getAll(Pageable pageable);
    ShoppingCart save(ShoppingCart shoppingCart);

    ShoppingCart findById(Integer id);
    void deleteOneProductById(Integer id);

    void deleteAllProductInShoppingCartOfUser();

}
