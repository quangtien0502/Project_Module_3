package com.example.ra.model.dto.Request.Category;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CategoryRequest {
    @NotEmpty(message = "Id is empty")
    @NotBlank(message = "Id is blank")
    @Pattern(regexp = "\\d+", message = "ID must be a numeric value")
    private Long id;
    @Column(nullable = false,unique = true)
    private String categoryName;
    private String description;
    private Boolean status;
}
