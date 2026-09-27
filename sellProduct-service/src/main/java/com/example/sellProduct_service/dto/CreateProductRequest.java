package com.example.sellProduct_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {

    @NotBlank(message = "Product name cannot be empty")
    private String name;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "20.0", message = "Price must be at least 20 Rs.")
    private Double price;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    private Boolean isNegotiable = false;

    @NotNull(message = "User ID is required")
    private Integer userId;

    private String imageUrl = "";
}