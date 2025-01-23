package com.example.demo.infrastructure;

import com.example.demo.application.ProductPricesService;
import com.example.demo.domain.entity.ProductPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class ProductPricesController {

    private final ProductPricesService productPricesService;

    @Autowired
    public ProductPricesController(ProductPricesService productPricesService) {
        this.productPricesService = productPricesService;
    }

    @GetMapping
    public ResponseEntity<ProductPrices> getPrice(
            @RequestParam Long brandId,
            @RequestParam int productId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        return productPricesService.getPrice(brandId, productId, applicationDate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
