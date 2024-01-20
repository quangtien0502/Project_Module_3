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
import java.util.UUID;

@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product save(Product productRequest) {
        if (productRequest.getId() !=null){
            productRequest.setUpdatedAt(new Date());
        }else {
            productRequest.setSku(UUID.randomUUID().toString());
            productRequest.setCreatedAt(new Date());
        }
        return productRepository.save(productRequest);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));
    }

    @Override
    public void deleteById(Long id) {
        Product product=findById(id);
        product.setStatus(!product.getStatus());
        save(product);
    }
}
