package com.example.ra.Service;

import com.example.ra.CustomException;
import com.example.ra.model.entity.User;
import com.example.ra.model.enums.OrderStatus;
import com.example.ra.security.user_principle.UserPrinciple;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service

public class CommonService {


    public User findUserIdInContext(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserPrinciple userPrinciple= (UserPrinciple) authentication.getPrincipal();
        return userPrinciple.getUser();
    }

    public Pageable pagination(String order,Integer page,Integer limit,String sort){
        Pageable pageable;
        if(order.equals("asc")){
            pageable= PageRequest.of(page,limit, Sort.by(sort).ascending());
        }else {
            pageable= PageRequest.of(page,limit,Sort.by(sort).descending());
        }
        return pageable;
    }

    public OrderStatus convertToOrderStatus(String status) throws CustomException {
        OrderStatus orderStatusConvert=OrderStatus.valueOf(status);
        if(orderStatusConvert==OrderStatus.CANCEL||orderStatusConvert==OrderStatus.CONFIRM||orderStatusConvert==OrderStatus.DELIVERY||orderStatusConvert==OrderStatus.DENIED || orderStatusConvert==OrderStatus.SUCCESS || orderStatusConvert==OrderStatus.WAITING){
            return orderStatusConvert;
        }else {
            throw new CustomException("No Order Status found for given status");
        }
    }



}
