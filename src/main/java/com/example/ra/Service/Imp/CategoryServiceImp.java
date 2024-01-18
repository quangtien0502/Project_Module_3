package com.example.ra.Service.Imp;

import com.example.ra.Service.ICategoryService;
import com.example.ra.model.dto.Request.Category.CategoryRequest;
import com.example.ra.model.entity.Category;
import com.example.ra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Page<Category> getAllEnable(Pageable pageable) {
        return categoryRepository.findCategoriesByStatus(true,pageable);
    }

    @Override
    public Category save(CategoryRequest categoryRequest) {
        Category category=Category.builder()
                .id(categoryRequest.getId())
                .categoryName(categoryRequest.getCategoryName())
                .description(categoryRequest.getDescription())
                .status(categoryRequest.getStatus())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category Not Found"));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }


}
