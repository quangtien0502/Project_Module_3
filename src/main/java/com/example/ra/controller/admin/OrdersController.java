package com.example.ra.controller.admin;

import com.example.ra.CustomException;
import com.example.ra.Mapper;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.IOrderService;
import com.example.ra.model.dto.Response.OrderDetailResponse;
import com.example.ra.model.dto.Response.OrderResponse;
import com.example.ra.model.entity.Orders;
import com.example.ra.model.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/admin/orders")
public class OrdersController {
    @Autowired
    private IOrderService orderService;

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
        Page<Orders> ordersList=orderService.getAll(pageable);

        List<OrderResponse> orderResponseList=ordersList.stream().map((item)->mapper.orderToOrderResponse(item)).toList();
        return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderDetail(@PathVariable Long orderId) throws CustomException {
        Orders orders=orderService.findById(orderId);
        List<OrderDetailResponse> orderDetailResponseList=mapper.orderToOrderDetailResponse(orders);
        return new ResponseEntity<>(orderDetailResponseList,HttpStatus.OK);

    }

    @GetMapping("/status/{orderStatus}")
    public ResponseEntity<?> getOrderByStatus(@PathVariable String orderStatus) throws CustomException {
        OrderStatus status=commonService.convertToOrderStatus(orderStatus);
        List<Orders> ordersList = orderService.findByProductStatus(status);
        List<OrderResponse> orderResponseList=ordersList.stream().map((item)->mapper.orderToOrderResponse(item)).toList();
        return new ResponseEntity<>(orderResponseList,HttpStatus.OK);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<?> changeOrderStatus(@PathVariable Long orderId,@RequestBody String orderStatus) throws CustomException {
        OrderStatus orderStatusConvert=commonService.convertToOrderStatus(orderStatus);
        Orders orders=orderService.updateStatus(orderId,orderStatusConvert);
        OrderResponse orderResponse=mapper.orderToOrderResponse(orders);
        return new ResponseEntity<>(orderResponse,HttpStatus.OK);
    }


}
