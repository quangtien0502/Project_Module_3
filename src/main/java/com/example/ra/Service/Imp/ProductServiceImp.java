package com.example.ra.Service.Imp;

import com.example.ra.Service.IOrderDetailService;
import com.example.ra.Service.IOrderService;
import com.example.ra.Service.IProductService;
import com.example.ra.model.entity.OrderDetail;
import com.example.ra.model.entity.Orders;
import com.example.ra.model.entity.Product;
import com.example.ra.model.enums.OrderStatus;
import com.example.ra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;
    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }



    @Override
    public Product save(Product productRequest) {
        if (productRequest.getId() !=null){
            productRequest.setUpdatedAt(new Date());
        }else {
            productRequest.setSku(UUID.randomUUID().toString());
            productRequest.setCreatedAt(new Date());
        }
        return productRepository.save(productRequest);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));
    }

    @Override
    public void deleteById(Long id) {
        Product product=findById(id);
        product.setStatus(!product.getStatus());
        save(product);
    }

    @Override
    public List<Product> findByNameOrDescription(String keyword) {
        return productRepository.findAllByProductNameContainingOrDescriptionContaining(keyword,keyword);
    }

    @Override
    public Page<Product> getAllEnable(Pageable pageable) {
        return productRepository.findAllByStatus(true,pageable);
    }

    @Override
    public List<Product> bestSeller() {
        List<Orders> ordersList=orderService.findByProductStatus(OrderStatus.CONFIRM);
        List<OrderDetail> orderDetailList=new ArrayList<>();
        for (Orders orders :
                ordersList) {
            List<OrderDetail> orderDetailListSample=orderDetailService.findByOrder(orders);
            if(!orderDetailListSample.isEmpty()){
                orderDetailListSample.stream().map(orderDetailList::add);
            }
        }
        if(!orderDetailList.isEmpty()){
            Map<Product, Integer> productOrderQuantities = new HashMap<>();
            for (OrderDetail orderDetail :
                    orderDetailList) {
                Product product = orderDetail.getProduct();
                Integer orderQuantity = orderDetail.getOrderQuantity();
                productOrderQuantities.merge(product, orderQuantity, Integer::sum);
            }
            Integer maxOrderQuantity = Collections.max(productOrderQuantities.values());
            List<Product> productList=new ArrayList<>();
            for (Map.Entry<Product, Integer> entry : productOrderQuantities.entrySet()) {
                if (entry.getValue().equals(maxOrderQuantity)) {
                    productList.add(entry.getKey());
                }
            }
            return productList;
        }else {
            return new ArrayList<>();
        }

    }
}
