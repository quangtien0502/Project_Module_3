package com.example.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Todo: foreign Key: User Id(done)
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    //Todo: foreign Key: Product Id(done)
    @OneToMany(mappedBy = "wishList")
    @JsonIgnore
    private List<WishListDetail> wishListDetails;
}
