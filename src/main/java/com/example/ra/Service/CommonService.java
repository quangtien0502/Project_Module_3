package com.example.ra.Service;

import com.example.ra.model.entity.User;
import com.example.ra.repository.UserRepository;
import com.example.ra.security.jwt.JwtProvider;
import com.example.ra.security.user_principle.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service

public class CommonService {
    @Autowired
    private UserRepository userRepository;


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



}
