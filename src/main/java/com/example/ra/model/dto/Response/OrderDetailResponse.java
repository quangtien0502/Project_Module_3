package com.example.ra.model.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//Todo: Do mapper for order Response
public class OrderDetailResponse {
    private Long id;
    private String name;
    private String productName;
    private Double unitPrice;
    private Integer orderQuantity;

}
