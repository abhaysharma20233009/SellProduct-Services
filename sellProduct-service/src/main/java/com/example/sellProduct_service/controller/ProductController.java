package com.example.sellProduct_service.controller;

import com.example.sellProduct_service.dto.CreateProductRequest;
import com.example.sellProduct_service.dto.ProductResponse;
import com.example.sellProduct_service.service.SellProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final SellProductService productService;

    public ProductController(SellProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(
            @RequestBody CreateProductRequest request) {

        return productService.createProduct(request);
    }

    @GetMapping
    public List<ProductResponse> getAllSellProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ProductResponse getProductByProductId(@PathVariable Long productId) {
        return productService.getSellProductByProductId(productId);
    }

    @GetMapping("/userId/{userId}")
    public List<ProductResponse> getProductByUserId(@PathVariable Long userId) {
        return productService.getSellProductByUserId(userId);
    }

}