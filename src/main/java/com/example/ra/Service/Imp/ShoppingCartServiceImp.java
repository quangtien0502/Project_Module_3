package com.example.ra.Service.Imp;

import com.example.ra.Service.CommonService;
import com.example.ra.Service.IShoppingCartService;
import com.example.ra.model.dto.Request.ShoppingCart.ShoppingCartRequest;
import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.ShoppingCart;
import com.example.ra.model.entity.User;
import com.example.ra.repository.ProductRepository;
import com.example.ra.repository.ShoppingCartRepository;
import com.example.ra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShoppingCartServiceImp implements IShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommonService commonService;


    @Override
    public Page<ShoppingCart> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        User userExist = commonService.findUserIdInContext();
        Product product = shoppingCart.getProduct();
        ShoppingCart shoppingCartFinal=ShoppingCart.builder()
                .user(userExist)
                .product(product)
                .id(shoppingCart.getId())
                .quantity(shoppingCart.getQuantity())
                .build();
        return shoppingCartRepository.save(shoppingCartFinal);
    }

    @Override
    public ShoppingCart findById(Integer id) {
        return shoppingCartRepository.findById(id).orElseThrow(() -> new RuntimeException("No Shopping Cart found"));
    }


    @Override
    public void deleteOneProductById(Integer shoppingCartId) {
        shoppingCartRepository.deleteById(shoppingCartId);
    }

    @Override
    public void deleteAllProductInShoppingCartOfUser() {
        User user=commonService.findUserIdInContext();
        shoppingCartRepository.deleteAllByUser(user);
    }
}
