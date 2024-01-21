package com.example.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.awt.print.Book;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String categoryName;
    private String description;
    @Builder.Default
    private Boolean status=true;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> listProducts;
}
