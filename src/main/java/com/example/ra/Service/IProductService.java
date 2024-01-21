package com.example.ra.Service;

import com.example.ra.model.dto.Request.Product.ProductRequest;
import com.example.ra.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> getAll(Pageable pageable);
    Product save(Product productRequest);
    Product findById(Long id);
    void deleteById(Long id);

    List<Product> findByNameOrDescription(String keyword);

    Page<Product> getAllEnable(Pageable pageable);

    List<Product> bestSeller();
}
