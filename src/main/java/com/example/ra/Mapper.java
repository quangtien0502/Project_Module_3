package com.example.ra;

import com.example.ra.model.dto.Response.OrderDetailResponse;
import com.example.ra.model.dto.Response.OrderResponse;
import com.example.ra.model.entity.OrderDetail;
import com.example.ra.model.entity.Orders;
import com.example.ra.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public OrderDetailResponse orderDetailToOrderDetailResponse(OrderDetail orderDetail){
        return new OrderDetailResponse(orderDetail.getId(),orderDetail.getName(),orderDetail.getProduct().getProductName(),orderDetail.getUnitPrice(),orderDetail.getOrderQuantity());
    }

    public OrderResponse orderToOrderResponse(Orders orders){
        List<OrderDetail> orderDetailList=orderDetailRepository.findAllByOrders(orders);
        List<OrderDetailResponse> orderDetailResponseList=orderDetailList.stream().map(this::orderDetailToOrderDetailResponse).toList();
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
                .orderDetailList(orderDetailResponseList)
                .build();
    }

    public List<OrderDetailResponse> orderToOrderDetailResponse(Orders orders){
        return orders.getListOrderDetail().stream().map((item)->OrderDetailResponse.builder().id(item.getId()).orderQuantity(item.getOrderQuantity()).name(item.getName()).productName(item.getProduct().getProductName()).unitPrice(item.getUnitPrice()).build()).toList();
    }

}
