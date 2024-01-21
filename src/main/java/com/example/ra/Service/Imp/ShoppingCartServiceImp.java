package com.example.ra.Service.Imp;
import com.example.ra.CustomException;
import com.example.ra.Service.CommonService;
import com.example.ra.Service.IShoppingCartService;
import com.example.ra.Service.IUserService;
import com.example.ra.model.entity.*;
import com.example.ra.model.enums.OrderStatus;
import com.example.ra.repository.OrderDetailRepository;
import com.example.ra.repository.OrderRepository;
import com.example.ra.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImp implements IShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private CommonService commonService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderServiceImp orderServiceImp;

    @Override
    public List<ShoppingCart> getAll() throws CustomException {
        User user =userService.findUserById(commonService.findUserIdInContext().getId());
        return shoppingCartRepository.findByUser(user);
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) throws CustomException {
        User userExist = userService.findUserById(commonService.findUserIdInContext().getId());
        Product product = shoppingCart.getProduct();
        ShoppingCart shoppingCartFinal=new ShoppingCart(shoppingCart.getId(),userExist,product,shoppingCart.getQuantity());
        if(shoppingCart.getId()==null && shoppingCartRepository.existsByUserAndProduct(userExist,product)){
            //this is inserted
            throw new CustomException("This user already has this product in shopping cart");
        }
        return shoppingCartRepository.save(shoppingCartFinal);
    }

    @Override
    public ShoppingCart findById(Integer id) {
        return shoppingCartRepository.findById(id).orElseThrow(() -> new RuntimeException("No Shopping Cart found"));
    }


    @Override
    public void deleteOneProductById(Integer shoppingCartId) {
        shoppingCartRepository.deleteById(shoppingCartId);
    }

    @Override
    public void deleteAllProductInShoppingCartOfUser() throws CustomException {
        User user=userService.findUserById(commonService.findUserIdInContext().getId());
        shoppingCartRepository.deleteAllByUser(user);
    }

    @Override
    public Orders checkout(Address address) throws CustomException {
        User user=userService.findUserById(commonService.findUserIdInContext().getId());
        //Todo: Create this list order detail => What to pass in the orders of orderDetailList: calculate order quantity,what's unit price and name?
        List<ShoppingCart> shoppingCartList=shoppingCartRepository.findByUser(user);
        double totalPrice=0.00;
        for (ShoppingCart shoppingCart : shoppingCartList) {
            totalPrice = totalPrice + shoppingCart.getQuantity() * shoppingCart.getProduct().getUnitPrice();
        }
        Orders orders=Orders.builder()
                .createdAt(new Date())
                .receiveAddress(address.getFullAddress())
                .receivePhone(address.getPhone())
                .receiveName(user.getFullName())
                .status(OrderStatus.CONFIRM)
                .totalPrice(totalPrice)
                .user(user)
                .build();
        Orders ordersNew=orderRepository.save(orders);
        List<OrderDetail> orderDetailList=shoppingCartList.stream().map((item)->OrderDetail.builder()
                .orders(ordersNew)
                .orderQuantity(item.getQuantity())
                .unitPrice(item.getProduct().getUnitPrice())
                .name(item.getProduct().getProductName())
                .product(item.getProduct())
                .build()).toList();
        List<OrderDetail> orderDetailListNew=orderDetailList.stream().map((item)->orderDetailRepository.save(item)).toList();

        return orderServiceImp.findById(ordersNew.getId());
    }
}
