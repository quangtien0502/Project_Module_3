package com.example.ra.controller.user;

import com.example.ra.CustomException;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.IProductService;
import com.example.ra.Service.IUserService;
import com.example.ra.Service.IWishListService;
import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.User;
import com.example.ra.model.entity.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user/wish-list")
public class WishListController {
    @Autowired
    private IWishListService wishListService;

    @Autowired
    private IUserService userService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private IProductService productService;

    @PostMapping("")
    public ResponseEntity<?> addProduct(@RequestBody Long productId) throws CustomException {
        User user = userService.findUserById(commonService.findUserIdInContext().getId());
        Product product=productService.findById(productId);
        WishList wishList=wishListService.save(new WishList(null,user,product));
        return new ResponseEntity<>(wishList, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<WishList> wishListList=wishListService.getAll();
        return new ResponseEntity<>(wishListList, HttpStatus.OK);
    }

    @DeleteMapping("/{wishListId}")
    public ResponseEntity<?> deleteById(@PathVariable Integer wishListId){
        wishListService.deleteById(wishListId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }


}
