package com.example.ra.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Todo: Foreign Key Product Id(done)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    //Todo: Foreign Key User Id(done)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Integer orderQuantity;
}
