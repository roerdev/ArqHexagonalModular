package com.roerdev.arqhexagonalmodular.product.adapter.mapper;

import com.roerdev.arqhexagonalmodular.product.adapter.entity.ProductEntity;
import com.roerdev.arqhexagonalmodular.product.model.entity.Product;
import com.roerdev.arqhexagonalmodular.stock.adapter.entity.StockEntity;
import com.roerdev.arqhexagonalmodular.stock.model.entity.Stock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductDBMapperTest {

    @Spy
    private ProductDBMapper productDBMapper = new ProductDBMapperImpl();

    StockEntity stockEntity = null;
    ProductEntity productEntity = null;
    Stock stockDomain = null;
    Product productDomain = null;

    @BeforeEach
    void setUp() {
        stockEntity = new StockEntity();
        stockEntity.setId(1L);
        stockEntity.setSize("S");
        stockEntity.setStock(10L);
        productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setName("ABC");
        productEntity.setSalesUnit(100L);
        productEntity.setStocks(List.of(stockEntity));
        stockDomain = Stock.builder().id(1L).size("S").stock(1L).build();
        productDomain = Product.builder()
                .id(1L)
                .name("ABC")
                .salesUnit(10L)
                .stocks(List.of(stockDomain))
                .build();
    }

    @Test
    void mapToProductEntity() {
        ProductEntity mapper = productDBMapper.mapToProductEntity(productDomain);
        assertEquals(mapper.getId(), productDomain.getId());
    }

    @Test
    void mapToStockEntity() {
        StockEntity mapper = productDBMapper.mapToStockEntity(stockDomain);
        assertEquals(mapper.getId(), stockDomain.getId());
    }

    @Test
    void cloneToProductDomain() {
        Product mapper = productDBMapper.cloneToProductDomain(productEntity);
        assertEquals(mapper.getId(), productEntity.getId());
    }

    @Test
    void toStockDomain() {
        Stock mapper = productDBMapper.toStockDomain(stockEntity);
        assertEquals(mapper.getId(), stockEntity.getId());
    }
}