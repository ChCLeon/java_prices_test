package com.example.demo.application;

import com.example.demo.domain.entity.ProductPrices;
import com.example.demo.infrastructure.repository.ProductPricesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductPricesServiceTest {

    @MockitoBean
    ProductPricesRepository productPricesRepository;

    @Autowired
    ProductPricesService productPricesService;

    @Test
    void getEmptyPrice() {
        List<ProductPrices> productPricesList = new ArrayList<>();
        Long brand_id = null;
        int product_id = 0;
        LocalDateTime applicationDate = null;
        when(productPricesRepository.findProductByPrice(brand_id, product_id, applicationDate)).thenReturn(productPricesList);
        assertEquals(productPricesList, List.of());
    }

    @Test
        //Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    void test1ShouldReturnPriceAt10AMDay14() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T10:00:00");
        ProductPrices expectedPrice = createProductPriceDTO(1L, 1, 35455, 35.50f, 1L);
        when(productPricesRepository.findProductByPrice(eq(1L), eq(35455), eq(applicationDate)))
                .thenReturn(List.of(expectedPrice));

        Optional<ProductPrices> result = productPricesService.getPrice(1L, 35455, applicationDate);

        assertEquals(35.50f, result.get().getPrice());
        assertEquals(1L, result.get().getPrice_list());

    }

    @Test
    //Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)

    void test2ShouldReturnPriceAt16PMDay14() {

        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T16:00:00");
        ProductPrices expectedPrice = createProductPriceDTO(1L, 2, 35455, 25.45f, 2L);
        when(productPricesRepository.findProductByPrice(eq(1L), eq(35455), eq(applicationDate)))
                .thenReturn(List.of(expectedPrice));
        Optional<ProductPrices> result = productPricesService.getPrice(1L, 35455, applicationDate);

        assertEquals(25.45f, result.get().getPrice());
        assertEquals(2L, result.get().getPrice_list());

    }




    private ProductPrices createProductPriceDTO(Long brandId, int priceList, int productId, float price, Long id) {
        ProductPrices productPrice = new ProductPrices();
        productPrice.setId(id);
        productPrice.setBrand_id(brandId);
        productPrice.setProduct_id(productId);
        productPrice.setPrice_list(priceList);
        productPrice.setPrice(price);
        productPrice.setStart_date(LocalDateTime.parse("2020-06-14T00:00:00"));
        productPrice.setEnd_date(LocalDateTime.parse("2020-12-31T23:59:59"));
        productPrice.setPriority(1);
        productPrice.setCurrency("EUR");
        return productPrice;

    }

}