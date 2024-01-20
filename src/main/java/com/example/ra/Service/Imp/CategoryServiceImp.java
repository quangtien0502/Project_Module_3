package com.example.ra.Service.Imp;

import com.example.ra.CustomException;
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
    public Boolean checkDuplicateName(String name) {
        return categoryRepository.existsCategoryByCategoryName(name);
    }

    @Override
    public Category save(Category categoryRequest) throws CustomException {
        if(categoryRequest.getId()==null && checkDuplicateName(categoryRequest.getCategoryName())){
            throw new CustomException("Category Name already Exist");
        }
        return categoryRepository.save(categoryRequest);
    }

    @Override
    public Category findById(Long id) throws CustomException {
        return categoryRepository.findById(id).orElseThrow(()->new CustomException("Category Not Found"));
    }

    @Override
    public void deleteById(Long id) throws CustomException {
        Category category=findById(id);
        category.setStatus(!category.getStatus());
        save(category);
    }


}
