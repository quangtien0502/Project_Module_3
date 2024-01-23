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
    @NotNull(message = "full address is null")
    @NotBlank(message = "full address is blank")
    private String fullAddress;
    private String phone;
    private String receiveName;
}
