package com.example.ra.model.dto.Request.ShoppingCart;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShoppingCartRequest {
    @NotNull(message = "productId is null")
    @NotBlank(message = "productId is blank")
    private Long productId;
    @NotEmpty(message = "quantity is empty")
    @NotBlank(message = "quantity is blank")
    @Pattern(regexp = "\\d+", message = "quantity must be a numeric value")
    private Integer orderQuantity;
}
