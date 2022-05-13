package com.co.ias.products.products.application.services;

import com.co.ias.products.products.application.domain.*;
import com.co.ias.products.products.application.models.ProductDTO;
import com.co.ias.products.products.application.ports.out.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateProductServiceTest {

    @Autowired
    private CreateProductService service;

    @Mock
    private ProductRepository productRepository;



    @Test
    void excute() {

        //Preparing
        productRepository = mock(ProductRepository.class);
        service = new CreateProductService(productRepository);

        ProductId productId = new ProductId(1);
        ProductName productName = new ProductName("Screen");
        ProductPrice productPrice = new ProductPrice(10000);
        ProductDiscount productDiscount = new ProductDiscount(10);
        TypeOfProduct typeOfProduct = new TypeOfProduct(2);
        Product product = new Product(productId,productName,typeOfProduct,productPrice,productDiscount);
        ProductDTO productDTO = ProductDTO.fromDomain(product);

        doNothing().when(productRepository).store(any(Product.class));

        //Executing
        service.excute(productDTO);


        //Validating
        verify(productRepository, times(1));



    }
}