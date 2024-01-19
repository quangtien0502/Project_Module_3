package com.example.ra.Service;

import com.example.ra.model.entity.Orders;
import com.example.ra.model.enums.ProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    Page<Orders> getAll(Pageable pageable);
    Orders save(Orders orders);
    Orders findById(Long id);
    void deleteById(Long id);

    List<Orders> findByProductStatus(ProductStatus status);
}
