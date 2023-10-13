package com.roerdev.arqhexagonalmodular.product.port.output.repository;

import com.roerdev.arqhexagonalmodular.product.model.entity.Product;

public interface ProductRepository {

    Product createProduct(Product product);
}
