package com.example.ra.Service.Imp;

import com.example.ra.CustomException;
import com.example.ra.Service.IOrderService;
import com.example.ra.model.entity.Orders;
import com.example.ra.model.enums.OrderStatus;
import com.example.ra.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Page<Orders> getAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Orders save(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public Orders findById(Long id) throws CustomException {
        return orderRepository.findById(id).orElseThrow(()->new CustomException("No orders found By this ID"));
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Orders> findByProductStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public Orders updateStatus(Long orderId, OrderStatus status) throws CustomException {
        Orders orders=findById(orderId);
        orders.setStatus(status);
        return save(orders);
    }

    @Override
    public Orders findBySerialNumber(String serialNumber) {
        return orderRepository.findOrdersBySerialNumber(serialNumber);
    }

    @Override
    public Orders cancelOrder(Orders orders) {
        if(orders.getStatus().equals(OrderStatus.WAITING)){
            orders.setStatus(OrderStatus.CANCEL);
        }
        return save(orders);
    }


}
