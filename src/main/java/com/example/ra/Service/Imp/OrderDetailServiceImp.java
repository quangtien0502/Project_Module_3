package com.example.ra.Service.Imp;

import com.example.ra.Service.IOrderDetailService;
import com.example.ra.model.entity.OrderDetail;
import com.example.ra.model.entity.Orders;
import com.example.ra.repository.OrderDetailRepository;
import com.example.ra.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImp implements IOrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetail> findByOrder(Orders orders) {
       return orderDetailRepository.findAllByOrders(orders);
    }
}
