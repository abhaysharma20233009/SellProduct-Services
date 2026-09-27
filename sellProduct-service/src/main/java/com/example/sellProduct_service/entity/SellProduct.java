package com.example.sellProduct_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class SellProduct{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
        private Integer id;
    @Column(nullable = false)
        private String name;
    @Column(nullable = false)
        private double price;
    @Column(nullable = false)
        private String description;

        private Boolean isNegotiable;
        private String imageUrl;
    @Column(nullable = false)
        private Integer userId;


}
