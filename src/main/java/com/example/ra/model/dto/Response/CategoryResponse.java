package com.example.ra.model.dto.Response;

import com.example.ra.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryResponse {
    private Long id;
    private String categoryName;
    private Boolean status;

    public CategoryResponse(Category category) {
        this.id=category.getId();
        this.categoryName=category.getCategoryName();
        this.status=category.getStatus();
    }
}
