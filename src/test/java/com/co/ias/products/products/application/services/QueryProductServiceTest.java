package com.co.ias.products.products.application.services;

import com.co.ias.products.products.application.domain.*;
import com.co.ias.products.products.application.models.ProductDTO;
import com.co.ias.products.products.application.ports.out.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class QueryProductServiceTest {

    @Autowired
    private QueryProductService service;

    @Mock
    private ProductRepository productRepository;

    @Test
    void excute() {

        //Preparing
        productRepository = mock(ProductRepository.class);
        service = new QueryProductService(productRepository);

        ProductId productId = new ProductId(1);
        ProductName productName = new ProductName("Screen");
        ProductPrice productPrice = new ProductPrice(10000);
        ProductDiscount productDiscount = new ProductDiscount(10);
        TypeOfProduct typeOfProduct = new TypeOfProduct(2);
        Product product = new Product(productId,productName,typeOfProduct,productPrice,productDiscount);

        when(productRepository.get(any(ProductId.class))).thenReturn(Optional.of(product));

        //Executing
        Optional<ProductDTO> result = service.excute(productId.getValue());


        //Validating
        assertEquals(1, result.get().getProductId());
    }
}