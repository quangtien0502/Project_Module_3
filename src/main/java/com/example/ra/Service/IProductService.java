package com.example.ra.Service;

import com.example.ra.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> getAll(Pageable pageable);
    Product save(Product product);
    Product findById(Long id);
    void deleteById(Long id);
}
