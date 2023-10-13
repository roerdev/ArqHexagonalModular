package com.roerdev.arqhexagonalmodular.product.adapter.jpa.dao;

import com.roerdev.arqhexagonalmodular.product.adapter.entity.ProductEntity;
import com.roerdev.arqhexagonalmodular.product.adapter.jpa.ProductAdapterRepository;
import com.roerdev.arqhexagonalmodular.product.adapter.mapper.ProductDBMapper;
import com.roerdev.arqhexagonalmodular.product.adapter.mapper.ProductDBMapperImpl;
import com.roerdev.arqhexagonalmodular.product.model.entity.Product;
import com.roerdev.arqhexagonalmodular.stock.adapter.entity.StockEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductH2DaoTest {

    @InjectMocks
    private ProductH2Dao productH2Dao;

    @Spy
    private ProductDBMapper productDBMapper = new ProductDBMapperImpl();

    @Mock
    private ProductAdapterRepository productAdapterRepository;

    @Test
    void getAllProducts() {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setId(1L);
        stockEntity.setSize("S");
        stockEntity.setStock(10L);
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setName("ABC");
        productEntity.setSalesUnit(100L);
        productEntity.setStocks(List.of(stockEntity));
        List<ProductEntity> productEntityList = List.of(productEntity);
        when(this.productAdapterRepository.findAll()).thenReturn(productEntityList);

        List<Product> allProducts = productH2Dao.getAllProducts();

        assertEquals(allProducts.get(0).getId(), productEntity.getId());

    }
}