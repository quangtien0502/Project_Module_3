package com.example.ra;

import com.example.ra.model.dto.Response.OrderResponse;
import com.example.ra.model.entity.Orders;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public OrderResponse orderToOrderResponse(Orders orders){
        return OrderResponse.builder()
                .serialNumber(orders.getSerialNumber())
                .id(orders.getId())
                .status(orders.getStatus())
                .createdAt(orders.getCreatedAt())
                .note(orders.getNote())
                .receiveAddress(orders.getReceiveAddress())
                .receivedAt(orders.getReceivedAt())
                .receiveName(orders.getReceiveName())
                .receivePhone(orders.getReceivePhone())
                .totalPrice(orders.getTotalPrice())
                .userFullName(orders.getUser().getFullName())
                .build();
    }
}
