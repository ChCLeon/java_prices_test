package com.example.demo.infrastructure.repository;

import com.example.demo.domain.entity.ProductPrices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JpaProductPrices implements ProductPricesRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductPrices> findProductByPrice(Long brand_id, Long product_id, LocalDateTime applicationDate) {
            String jpql = "SELECT p FROM Price p WHERE p.brandId = :brandId " +
                    "AND p.productId = :productId " +
                    "AND :applicationDate BETWEEN p.startDate AND p.endDate " +
                    "ORDER BY p.priority DESC";

            TypedQuery<ProductPrices> query = entityManager.createQuery(jpql, ProductPrices.class);
            query.setParameter("brandId", brand_id);
            query.setParameter("productId", product_id);
            query.setParameter("applicationDate", applicationDate);

            return query.getResultList();
    }
}
