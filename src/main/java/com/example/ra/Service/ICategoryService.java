package com.example.ra.Service;

import com.example.ra.model.dto.Request.Category.CategoryRequest;
import com.example.ra.model.entity.Category;
import com.example.ra.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> getAll(Pageable pageable);
    Category save(CategoryRequest categoryRequest);
    Category findById(Long id);
    void deleteById(Long id);

    Page<Category> getAllEnable(Pageable pageable);
}
