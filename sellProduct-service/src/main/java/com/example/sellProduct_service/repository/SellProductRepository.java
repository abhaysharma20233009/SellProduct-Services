package com.example.sellProduct_service.repository;


import com.example.sellProduct_service.entity.SellProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellProductRepository
        extends JpaRepository<SellProduct, Long> {
    List<SellProduct> findAllByUserId(Long userId);
}