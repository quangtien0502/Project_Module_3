package com.example.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Todo: Foreign Key Shopping Cart Detail
    @OneToMany(mappedBy = "shoppingCart")
    @JsonIgnore
    private List<ShoppingCartDetail> shoppingCartDetails;
    //Todo: Foreign Key User Id(done)
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
