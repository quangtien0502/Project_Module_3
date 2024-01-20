package com.example.ra.model.entity;

import jakarta.persistence.*;
import lombok.*;


//Todo: Don't have this order detail Id ?
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    //Todo: Foreign Key at Order
    private Orders orders;
    //Todo: Foreign Key at Product(Done)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String name;
    private Double unitPrice;
    private Integer orderQuantity;
}
