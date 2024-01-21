package com.example.ra.model.dto.Response;

import com.example.ra.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderResponse {
    private Long id;
    private String serialNumber;
    private String userFullName;
    private Double totalPrice;
    private OrderStatus status;
    private String note;
    private String receiveName;
    private String receiveAddress;
    private String receivePhone;
    private Date createdAt;
    private Date receivedAt;
    private List<OrderDetailResponse> orderDetailList;

}
