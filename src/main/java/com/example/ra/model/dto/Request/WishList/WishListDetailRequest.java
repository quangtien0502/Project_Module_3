package com.example.ra.model.dto.Request.WishList;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class WishListDetailRequest {
    private Integer id;
    @NotNull(message = "userId is null")
    @NotBlank(message = "userId is blank")
    private Integer wishListId;
    @NotNull(message = "productId is null")
    @NotBlank(message = "productId is blank")
    private Long productId;
}
