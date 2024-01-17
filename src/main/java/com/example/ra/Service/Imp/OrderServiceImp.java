package com.example.ra.Service.Imp;

import com.example.ra.Service.IOrderService;
import com.example.ra.model.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements IOrderService {
    @Override
    public Page<Orders> getAll(Pageable pageable) {
        return null;
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
}
