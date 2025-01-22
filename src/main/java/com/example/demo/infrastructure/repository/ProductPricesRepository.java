package com.example.demo.infrastructure.repository;
import com.example.demo.domain.entity.ProductPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductPricesRepository  {

    List<ProductPrices> findProductByPrice(Long brand_id, Long product_id, LocalDateTime applicationDate);
}
