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

    @Test
    //Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    void getPricesByTest1(){
        List<ProductPrices> productPricesList =new ArrayList<>();
        Long brand_id = 1L;
        Long product_id = 35455L;
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T10:00:00");
    }
}