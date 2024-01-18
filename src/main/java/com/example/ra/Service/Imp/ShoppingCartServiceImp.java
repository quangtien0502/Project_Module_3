package com.example.ra.Service.Imp;

import com.example.ra.Service.IShoppingCartService;
import com.example.ra.model.dto.Request.ShoppingCart.ShoppingCartRequest;
import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.ShoppingCart;
import com.example.ra.model.entity.ShoppingCartDetail;
import com.example.ra.model.entity.User;
import com.example.ra.repository.ProductRepository;
import com.example.ra.repository.ShoppingCartDetailRepository;
import com.example.ra.repository.ShoppingCartRepository;
import com.example.ra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
    private ShoppingCartDetailRepository shoppingCartDetailRepository;



    @Override
    public Page<ShoppingCart> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ShoppingCart save(ShoppingCartRequest shoppingCartRequest) {

        User userExist = userRepository.findById(shoppingCartRequest.getUserId()).orElseThrow(() -> new RuntimeException("User doesn't exist"));
        Set<Product> listProduct=new HashSet<>();
        for (Long productId :
                shoppingCartRequest.getProductId()) {
            Product productExist=productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product Not Found"));
            listProduct.add(productExist);
        }
        return shoppingCartRepository.save(ShoppingCart.builder()
                .user(userExist)
                .id(shoppingCartRequest.getId())
                .build());
    }

    @Override
    public ShoppingCart findById(Integer id) {
        return shoppingCartRepository.findById(id).orElseThrow(()->new RuntimeException("No Shopping Cart found"));
    }

    @Override
    public void deleteById(Integer id) {}

    @Override
    public void deleteProductInShoppingCart(Long userId, Long productId) {
        ShoppingCart shoppingCart=shoppingCartRepository.findByUser(userId);
        List<ShoppingCartDetail> shoppingCartDetailList=shoppingCart.getShoppingCartDetails();
        for (ShoppingCartDetail shoppingCartDetail:
                shoppingCartDetailList) {
            shoppingCartDetailRepository.deleteShoppingCartDetailByShoppingCartAndProduct(shoppingCartDetail.getShoppingCart().getId(),shoppingCartDetail.getProduct().getId());
        }
    }


}
