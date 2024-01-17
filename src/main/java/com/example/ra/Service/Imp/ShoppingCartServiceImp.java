package com.example.ra.Service.Imp;

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

import java.util.Optional;

@Service
public class ShoppingCartServiceImp implements IShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<ShoppingCart> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ShoppingCart save(ShoppingCartRequest shoppingCartRequest) {
        ShoppingCart shoppingCart=new ShoppingCart();
        User userExist=userRepository.findById(shoppingCartRequest.getUserId()).orElseThrow(()->new RuntimeException("User doesn't exist"));
        Product productExist=productRepository.findById(shoppingCartRequest.getProductId()).orElseThrow(()->new RuntimeException("Product doesn't exist"));
        shoppingCart.setUser(userExist);
        shoppingCart.setProduct(productExist);
        if(shoppingCartRequest.getId() !=null){
            shoppingCart.setId(shoppingCartRequest.getId());
        }
        shoppingCart.setOrderQuantity(shoppingCartRequest.getOrderQuantity());
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
