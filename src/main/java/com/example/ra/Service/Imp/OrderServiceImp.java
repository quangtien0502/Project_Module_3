package com.example.ra.Service.Imp;

import com.example.ra.Service.IOrderService;
import com.example.ra.model.entity.Orders;
import com.example.ra.model.enums.ProductStatus;
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
        return null;
    }

    @Override
    public Orders findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Orders> findByProductStatus(ProductStatus status) {
        return orderRepository.findByStatus(status);
    }
}
