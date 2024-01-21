package com.example.ra.Service;

import com.example.ra.model.entity.OrderDetail;
import com.example.ra.model.entity.Orders;

import java.util.List;

public interface IOrderDetailService {
    public List<OrderDetail> findByOrder(Orders orders);
}
