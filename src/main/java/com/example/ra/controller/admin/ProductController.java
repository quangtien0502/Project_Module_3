package com.example.ra.controller.admin;

import com.example.ra.CustomException;
import com.example.ra.Service.ICategoryService;
import com.example.ra.Service.IProductService;
import com.example.ra.model.dto.Request.Product.ProductRequest;
import com.example.ra.model.entity.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "5",name = "limit") int limit,
                                    @RequestParam(defaultValue = "0",name = "page") int page,
                                    @RequestParam(defaultValue = "id",name = "sortBy") String sort,
                                    @RequestParam(defaultValue = "asc",name = "order") String order){
        Pageable pageable;
        if(order.equals("asc")){
            pageable= PageRequest.of(page,limit, Sort.by(sort).ascending());
        }else {
            pageable= PageRequest.of(page,limit,Sort.by(sort).descending());
        }
        return new ResponseEntity<>(productService.getAll(pageable), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody ProductRequest productRequest) throws CustomException {
        Product product=Product.builder()
                .productName(productRequest.getProductName())
                .category(categoryService.findById(productRequest.getCategoryId()))
                .description(productRequest.getDescription())
                .unitPrice(productRequest.getUnitPrice())
                .stockQuantity(productRequest.getStockQuantity())
                .image(productRequest.getImage())
                .build();
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }


}
