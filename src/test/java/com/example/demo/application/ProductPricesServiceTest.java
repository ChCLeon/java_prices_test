package com.example.demo.application;

import com.example.demo.infrastructure.repository.ProductPricesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductPricesServiceTest {

    @MockitoBean
    ProductPricesRepository productPricesRepository;

    @Autowired
    ProductPricesService productPricesService;

    @Test
    void getEmptyPrice(){

    }
}