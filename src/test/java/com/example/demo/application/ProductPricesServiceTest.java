package com.example.demo.application;

import com.example.demo.domain.entity.ProductPrices;
import com.example.demo.infrastructure.repository.ProductPricesRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductPricesServiceTest {

    @MockitoBean
    ProductPricesRepository productPricesRepository;

    @Autowired
    ProductPricesService productPricesService;

    @Test
    void getEmptyPrice(){
        List<ProductPrices> productPricesList =new ArrayList<>();
        Long brand_id = null;
        Long product_id = null;
        LocalDateTime applicationDate = null;
        Mockito.when(productPricesRepository.findProductByPrice(brand_id,product_id,applicationDate)).thenReturn(productPricesList);
        assertEquals(productPricesList,List.of());
    }
}