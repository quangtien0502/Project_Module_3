package com.example.ra.controller.user;

import com.example.ra.CustomException;
import com.example.ra.Mapper;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.IOrderService;
import com.example.ra.Service.IUserService;
import com.example.ra.model.dto.Response.OrderResponse;
import com.example.ra.model.entity.Orders;
import com.example.ra.model.entity.User;
import com.example.ra.model.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user/history")
public class HistoryController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserService userService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private Mapper mapper;

    @GetMapping("")
    public ResponseEntity<?> orderHistory() throws CustomException {
        User user=userService.findUserById(commonService.findUserIdInContext().getId());
        List<Orders> ordersList=orderService.findByUser(user);
        List<OrderResponse> orderResponseList=ordersList.stream().map((item)->mapper.orderToOrderResponse(item)).toList();
        return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
    }

   @GetMapping("/{serialNumber}")
   public ResponseEntity<?> getBySerial(@PathVariable String serialNumber){
       Orders orders= orderService.findBySerialNumber(serialNumber);
       return new ResponseEntity<>(mapper.orderToOrderResponse(orders),HttpStatus.OK);
   }

    @GetMapping("/status/{orderStatus}")
    public ResponseEntity<?> getByStatus(@PathVariable String orderStatus) throws CustomException {
        OrderStatus status=commonService.convertToOrderStatus(orderStatus);
        List<Orders> ordersList=orderService.findByProductStatus(status);
        List<OrderResponse> orderResponseList=ordersList.stream().map((item)->mapper.orderToOrderResponse(item)).toList();
        return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) throws CustomException {
        Orders orders=orderService.findById(orderId);
        orders=orderService.cancelOrder(orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


}
