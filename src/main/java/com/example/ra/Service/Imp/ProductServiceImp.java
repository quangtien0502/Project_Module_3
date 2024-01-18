package com.example.ra.Service.Imp;

import com.example.ra.Service.IProductService;
import com.example.ra.model.dto.Request.Product.ProductRequest;
import com.example.ra.model.entity.Product;
import com.example.ra.model.entity.User;
import com.example.ra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product save(ProductRequest productRequest) {
        Product product= Product.builder()
                .id(productRequest.getId())
                .productName(productRequest.getProductName())
                .description(productRequest.getDescription())
                .unitPrice(productRequest.getUnitPrice())
                .stockQuantity(productRequest.getStockQuantity())
                .image(productRequest.getImage())
                .build();
        if (productRequest.getId() !=null){
            product.setUpdatedAt(new Date());
        }else {
            product.setCreatedAt(new Date());
        }
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
