package com.roerdev.arqhexagonalmodular.product.adapter.jpa.dao;

import com.roerdev.arqhexagonalmodular.product.adapter.entity.ProductEntity;
import com.roerdev.arqhexagonalmodular.product.port.output.dao.ProductDao;
import com.roerdev.arqhexagonalmodular.product.adapter.jpa.ProductAdapterRepository;
import com.roerdev.arqhexagonalmodular.product.adapter.mapper.ProductDBMapper;
import com.roerdev.arqhexagonalmodular.product.model.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductH2Dao implements ProductDao {

    private final ProductAdapterRepository productAdapterRepository;
    private final ProductDBMapper productDBMapper;

    public ProductH2Dao(ProductAdapterRepository productAdapterRepository, ProductDBMapper productDBMapper) {
        this.productAdapterRepository = productAdapterRepository;
        this.productDBMapper = productDBMapper;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productAdapterRepository
                .findAll().stream()
                .map(this.productDBMapper::cloneToProductDomain)
                .collect(Collectors.toList());
    }
}
