package com.example.ra.model.dto.Request.Address;

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
public class AddressRequest {
    @NotEmpty(message = "Id is empty")
    @NotBlank(message = "Id is blank")
    @Pattern(regexp = "\\d+", message = "ID must be a numeric value")
    private Long id;
    @NotNull(message = "userId is null")
    @NotBlank(message = "userId is blank")
    private Long userId;
    @NotNull(message = "full address is null")
    @NotBlank(message = "full address is blank")
    private String fullAddress;
    private String phone;
    private String receiveName;
}
