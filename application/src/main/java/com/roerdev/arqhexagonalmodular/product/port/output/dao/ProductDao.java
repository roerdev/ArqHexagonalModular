package com.roerdev.arqhexagonalmodular.product.port.output.dao;

import com.roerdev.arqhexagonalmodular.product.model.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();
}
