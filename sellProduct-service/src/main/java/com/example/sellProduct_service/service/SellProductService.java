package com.example.sellProduct_service.service;

import com.example.sellProduct_service.dto.CreateProductRequest;
import com.example.sellProduct_service.dto.ProductResponse;
import com.example.sellProduct_service.entity.SellProduct;
import com.example.sellProduct_service.repository.SellProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellProductService {

    private final SellProductRepository sellProductRepository;

    public SellProductService(SellProductRepository sellProductRepository) {
        this.sellProductRepository = sellProductRepository;
    }

    public ProductResponse createProduct(CreateProductRequest request) {

        SellProduct sellProduct = new SellProduct();

        sellProduct.setName(request.getName());
        sellProduct.setPrice(request.getPrice());
        sellProduct.setDescription(request.getDescription());
        sellProduct.setIsNegotiable(request.getIsNegotiable());
        sellProduct.setUserId(request.getUserId());
        sellProduct.setImageUrl(request.getImageUrl());

        SellProduct savedProduct = sellProductRepository.save(sellProduct);

        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice(),
                savedProduct.getDescription(),
                savedProduct.getIsNegotiable(),
                savedProduct.getUserId(),
                savedProduct.getImageUrl()
        );
    }
    public List<ProductResponse> getAllProducts() {
        return sellProductRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getDescription(),
                        product.getIsNegotiable(),
                        product.getUserId(),
                        product.getImageUrl()
                ))
                .toList();
    }
    public ProductResponse getSellProductByProductId(Long id) {

        SellProduct sellProduct = sellProductRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + id)
                );

        return new ProductResponse(
                sellProduct.getId(),
                sellProduct.getName(),
                sellProduct.getPrice(),
                sellProduct.getDescription(),
                sellProduct.getIsNegotiable(),
                sellProduct.getUserId(),
                sellProduct.getImageUrl()
        );
    }
    public List<ProductResponse> getSellProductByUserId(Long id) {
        try {
            return sellProductRepository.findAllByUserId(id)
                    .stream()
                    .map(product -> new ProductResponse(
                            product.getId(),
                            product.getName(),
                            product.getPrice(),
                            product.getDescription(),
                            product.getIsNegotiable(),
                            product.getUserId(),
                            product.getImageUrl()
                    ))
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}