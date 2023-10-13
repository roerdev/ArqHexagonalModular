package com.roerdev.arqhexagonalmodular.product.rest.config;

import com.roerdev.arqhexagonalmodular.product.port.output.dao.ProductDao;
import com.roerdev.arqhexagonalmodular.product.services.ProductGetAllOrderedService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBean {

    @Bean
    public ProductGetAllOrderedService productGetAllOrderedService(ProductDao productDao){
        return new ProductGetAllOrderedService(productDao);

    }
}
