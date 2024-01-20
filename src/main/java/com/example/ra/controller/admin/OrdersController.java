package com.example.ra.controller.admin;

import com.example.ra.CustomException;
import com.example.ra.Mapper;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.Imp.OrderServiceImp;
import com.example.ra.model.dto.Response.OrderDetailResponse;
import com.example.ra.model.dto.Response.OrderResponse;
import com.example.ra.model.entity.OrderDetail;
import com.example.ra.model.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/admin/orders")
public class OrdersController {
    @Autowired
    private OrderServiceImp orderServiceImp;

    @Autowired
    private CommonService commonService;

    @Autowired
    private Mapper mapper;

    @GetMapping("")
    public ResponseEntity<?> getAllOrder(@RequestParam(defaultValue = "5",name = "limit") int limit,
                                         @RequestParam(defaultValue = "0",name = "page") int page,
                                         @RequestParam(defaultValue = "id",name = "sortBy") String sort,
                                         @RequestParam(defaultValue = "asc",name = "order") String order){
        Pageable pageable=commonService.pagination(order,page,limit,sort);
        Page<Orders> ordersList=orderServiceImp.getAll(pageable);

        List<OrderResponse> orderResponseList=ordersList.stream().map((item)->mapper.orderToOrderResponse(item)).toList();
        return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderDetail(@PathVariable Long orderId) throws CustomException {
        Orders orders=orderServiceImp.findById(orderId);
        List<OrderDetailResponse> orderDetailResponseList=mapper.orderToOrderDetailResponse(orders);
        return new ResponseEntity<>(orderDetailResponseList,HttpStatus.OK);
    }
}
