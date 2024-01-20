package com.example.ra.model.entity;

import com.example.ra.model.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long serialNumber;
    //Todo: Foreign Key: User Id(done)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //Todo: Ask teacher whether this is acceptable ? Decimal (10,2) but this doesn't show the precision => Nearly Done
    private Double totalPrice;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    private String note;
    private String receiveName;
    private String receiveAddress;
    private String receivePhone;
    private Date createdAt;
    private Date receivedAt;

    @OneToMany(mappedBy = "orders")
    @JsonIgnore
    private List<OrderDetail> listOrderDetail;


}
