package com.example.sellProduct_service.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ProductResponse{
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Boolean isNegotiable;
    private Integer userId;
    private String imageUrl;


    public ProductResponse(Integer id, String name, Double price, String description, Boolean isNegotiable, Integer userId, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.isNegotiable = isNegotiable;
        this.userId = userId;
        this.imageUrl = imageUrl;
    }

}