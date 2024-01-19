package com.example.ra.controller.admin;

import com.example.ra.Service.IProductService;
import com.example.ra.Service.IShoppingCartService;
import com.example.ra.Service.Imp.ShoppingCartServiceImp;
import com.example.ra.model.dto.Request.ShoppingCart.ShoppingCartRequest;
import com.example.ra.model.entity.ShoppingCart;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private IProductService productService;

    @PostMapping("")
    public ResponseEntity<?> createShoppingCart(@Valid @RequestBody ShoppingCartRequest shoppingCartRequest){
        ShoppingCart shoppingCart= ShoppingCart.builder()
                .quantity(shoppingCartRequest.getOrderQuantity())
                .product(productService.findById(shoppingCartRequest.getProductId()))
                .build();
        return new ResponseEntity<>(shoppingCartService.save(shoppingCart), HttpStatus.CREATED);
    }
}
