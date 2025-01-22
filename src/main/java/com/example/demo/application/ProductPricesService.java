package com.example.demo.application;

import com.example.demo.infrastructure.repository.ProductPricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPricesService {
    private final ProductPricesRepository productPricesRepository;

    @Autowired
    public ProductPricesService(ProductPricesRepository productPricesRepository) {
        this.productPricesRepository = productPricesRepository;
    }

    
}
