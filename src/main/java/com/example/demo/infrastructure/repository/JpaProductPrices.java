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
    public List<ProductPrices> findProductByPrice(Long brand_id, int product_id, LocalDateTime applicationDate) {
            String jpql = "SELECT p FROM ProductPrices p WHERE p.brand_id = :brand_id " +
                    "AND p.product_id = :product_id " +
                    "AND :applicationDate BETWEEN p.start_date AND p.end_date " +
                    "ORDER BY p.priority DESC";

            TypedQuery<ProductPrices> query = entityManager.createQuery(jpql, ProductPrices.class);
            query.setParameter("brand_id", brand_id);
            query.setParameter("product_id", product_id);
            query.setParameter("applicationDate", applicationDate);

            return query.getResultList();
    }
}
