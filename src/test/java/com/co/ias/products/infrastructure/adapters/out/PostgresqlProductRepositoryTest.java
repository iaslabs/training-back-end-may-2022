package com.co.ias.products.infrastructure.adapters.out;

import com.co.ias.products.products.application.domain.*;
import com.co.ias.products.products.application.ports.out.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostgresqlProductRepositoryTest {

    ProductRepository productRepository;

    @Test
    void store() {
        ProductId productId = new ProductId(1);
        ProductName productName = new ProductName("Screen");
        ProductPrice productPrice = new ProductPrice(10000);
        ProductDiscount productDiscount = new ProductDiscount(10);
        TypeOfProduct typeOfProduct = new TypeOfProduct(2);
        Product product = new Product(productId,productName,typeOfProduct,productPrice,productDiscount);

        productRepository.store(product);




    }
}