package com.example.ra.controller.user;

import com.example.ra.CustomException;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.IProductService;
import com.example.ra.Service.IShoppingCartService;
import com.example.ra.Service.Imp.ShoppingCartServiceImp;
import com.example.ra.model.dto.Request.ShoppingCart.ShoppingCartRequest;
import com.example.ra.model.entity.ShoppingCart;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private IProductService productService;

    @Autowired
    private CommonService commonService;



    @GetMapping("")
    public ResponseEntity<?> getAllEnaBle(@RequestParam(defaultValue = "5",name = "limit") int limit,
                                          @RequestParam(defaultValue = "0",name = "page") int page,
                                          @RequestParam(defaultValue = "id",name = "sortBy") String sort,
                                          @RequestParam(defaultValue = "asc",name = "order") String order
                                          ){
        Pageable pageable=commonService.pagination(order,page,limit,sort);
        return new ResponseEntity<>(shoppingCartService.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createShoppingCart(@Valid @RequestBody ShoppingCartRequest shoppingCartRequest) throws CustomException {
        ShoppingCart shoppingCart= ShoppingCart.builder()
                .quantity(shoppingCartRequest.getOrderQuantity())
                .product(productService.findById(shoppingCartRequest.getProductId()))
                .build();
        return new ResponseEntity<>(shoppingCartService.save(shoppingCart), HttpStatus.CREATED);
    }
}
