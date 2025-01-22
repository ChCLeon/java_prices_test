package com.example.demo.infrastructure.repository;
import com.example.demo.domain.entity.ProductPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductPricesRepository  {
    @Query("SELECT p FROM ProductPrice p WHERE p.brand_id = :brand_id " +
            "AND p.product_id = :product_id " +
            "AND :applicationDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC")
    List<ProductPrices> findProductByPrice(Long brand_id, Long product_id, LocalDateTime applicationDate);
}
