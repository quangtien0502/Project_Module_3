package com.example.ra.repository;

import com.example.ra.model.entity.OrderDetail;
import com.example.ra.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    List<OrderDetail> findAllByOrders(Orders orders);
}
