package com.example.ra.repository;

import com.example.ra.model.entity.Orders;
import com.example.ra.model.entity.User;
import com.example.ra.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByStatus(OrderStatus status );
    List<Orders> findAllByStatusIs(OrderStatus orderStatus);

    Orders findOrdersBySerialNumber(String serial);

    List<Orders> findAllByUser(User user);
}
