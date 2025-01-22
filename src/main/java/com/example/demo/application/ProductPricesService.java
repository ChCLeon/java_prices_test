package com.example.demo.application;

import com.example.demo.domain.entity.ProductPrices;
import com.example.demo.infrastructure.repository.ProductPricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductPricesService {
    private final ProductPricesRepository productPricesRepository;

    @Autowired
    public ProductPricesService(ProductPricesRepository productPricesRepository) {
        this.productPricesRepository = productPricesRepository;
    }

    public Optional<ProductPrices> getPrice(Long brand_id, Long product_id, LocalDateTime applicationDate) {
        return productPricesRepository.findProductByPrice(brand_id, product_id, applicationDate)
                .stream()
                .findFirst();
    }
}
