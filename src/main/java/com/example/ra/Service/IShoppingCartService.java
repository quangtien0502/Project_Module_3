package com.example.ra.Service;

import com.example.ra.model.dto.Request.ShoppingCart.ShoppingCartRequest;
import com.example.ra.model.entity.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IShoppingCartService {
    Page<ShoppingCart> getAll(Pageable pageable);
    ShoppingCart save(ShoppingCartRequest shoppingCartRequest);

    ShoppingCart findById(Long id);
    void deleteById(Long id);
}
