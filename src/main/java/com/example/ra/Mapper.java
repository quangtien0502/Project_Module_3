package com.example.ra;

import com.example.ra.model.dto.Response.OrderDetailResponse;
import com.example.ra.model.dto.Response.OrderResponse;
import com.example.ra.model.entity.OrderDetail;
import com.example.ra.model.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<OrderDetailResponse> orderToOrderDetailResponse(Orders orders){
        return orders.getListOrderDetail().stream().map((item)->OrderDetailResponse.builder().id(item.getId()).orderQuantity(item.getOrderQuantity()).name(item.getName()).productName(item.getProduct().getProductName()).unitPrice(item.getUnitPrice()).build()).toList();
    }

}
