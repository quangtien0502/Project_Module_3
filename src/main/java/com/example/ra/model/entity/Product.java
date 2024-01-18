package com.example.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String sku;
    private String productName;
    private String description;
    private Double unitPrice;
    private Integer stockQuantity;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderDetail> listOrderDetail;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private Set<ShoppingCart> shoppingCarts = new HashSet<>();


    //Todo: Change to Many To Many
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<WishList> listWishList;
}
