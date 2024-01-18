package com.example.ra.model.dto.Request.Product;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductRequest {
    @NotEmpty(message = "Id is empty")
    @NotBlank(message = "Id is blank")
    @Pattern(regexp = "\\d+", message = "ID must be a numeric value")
    private Long id;
    private String productName;
    private String description;
    private Double unitPrice;
    private Integer stockQuantity;
    private String image;
    private Date createdAt;
    private Date updatedAt;


}
