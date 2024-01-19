package com.example.ra.controller.admin;

import com.example.ra.CustomException;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.ICategoryService;
import com.example.ra.model.dto.Request.Category.CategoryRequest;
import com.example.ra.model.entity.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private CommonService commonService;
    @GetMapping("")
    public ResponseEntity<?> getAllEnaBle(@RequestParam(defaultValue = "5",name = "limit") int limit,
                                    @RequestParam(defaultValue = "0",name = "page") int page,
                                    @RequestParam(defaultValue = "id",name = "sortBy") String sort,
                                    @RequestParam(defaultValue = "asc",name = "order") String order){
        Pageable pageable=commonService.pagination(order,page,limit,sort);
        return new ResponseEntity<>(categoryService.getAllEnable(pageable), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody CategoryRequest categoryRequest) throws CustomException {
        Category category=Category.builder()
                .categoryName(categoryRequest.getCategoryName())
                .description(categoryRequest.getDescription())
                .status(categoryRequest.getStatus())
                .build();
        return new ResponseEntity<>(categoryService.save(category),HttpStatus.CREATED);
    }
}
