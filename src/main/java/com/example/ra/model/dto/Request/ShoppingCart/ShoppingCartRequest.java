package com.example.ra.model.dto.Request.ShoppingCart;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShoppingCartRequest {
    @NotEmpty(message = "Id is empty")
    @NotBlank(message = "Id is blank")
    @Pattern(regexp = "\\d+", message = "ID must be a numeric value")
    private Integer id;
    @NotNull(message = "userId is null")
    @NotBlank(message = "userId is blank")
    private Long userId;
    @NotNull(message = "productId is null")
    @NotBlank(message = "productId is blank")
    private Long productId;
    @NotNull(message = "quantity is null")
    @NotBlank(message = "quantity is blank")
    private Integer orderQuantity;
}
