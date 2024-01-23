package com.example.ra.controller.user;

import com.example.ra.CustomException;
import com.example.ra.Mapper;
import com.example.ra.Service.*;
import com.example.ra.model.dto.Request.ShoppingCart.ShoppingCartRequest;
import com.example.ra.model.dto.Response.OrderResponse;
import com.example.ra.model.entity.Address;
import com.example.ra.model.entity.Orders;
import com.example.ra.model.entity.ShoppingCart;
import com.example.ra.model.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/shopping-cart")
public class ShoppingCartController {
    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private IProductService productService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private IUserService userService;




    @GetMapping("")
    public ResponseEntity<?> getAllEnaBle() throws CustomException {
        return new ResponseEntity<>(shoppingCartService.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addProductAndQuantity(@Valid @RequestBody ShoppingCartRequest shoppingCartRequest) throws CustomException {
        User user=userService.findUserById(commonService.findUserIdInContext().getId());
        ShoppingCart shoppingCart= ShoppingCart.builder()
                .user(user)
                .quantity(shoppingCartRequest.getOrderQuantity())
                .product(productService.findById(shoppingCartRequest.getProductId()))
                .build();
        return new ResponseEntity<>(shoppingCartService.save(shoppingCart), HttpStatus.CREATED);
    }

    @PutMapping("/{shoppingCartId}")
    public ResponseEntity<?> changeQuantity(@RequestBody Integer quantity,@PathVariable Integer shoppingCartId) throws CustomException {
        ShoppingCart shoppingCart=shoppingCartService.findById(shoppingCartId);
        shoppingCart.setQuantity(quantity);
        return new ResponseEntity<>(shoppingCartService.save(shoppingCart),HttpStatus.OK);
    }

    @DeleteMapping("/{shoppingCartId}")
    public ResponseEntity<?> delete(@PathVariable Integer shoppingCartId){
        shoppingCartService.deleteOneProductById(shoppingCartId);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllShoppingCart() throws CustomException {
        shoppingCartService.deleteAllProductInShoppingCartOfUser();
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody Long addressId) throws CustomException {
        Address address=addressService.findById(addressId);
        Orders orders=shoppingCartService.checkout(address);
        OrderResponse orderResponse=mapper.orderToOrderResponse(orders);
        return new ResponseEntity<>(orderResponse,HttpStatus.OK);
    }
}
