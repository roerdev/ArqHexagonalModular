package com.roerdev.arqhexagonalmodular.product.rest.mapper;

import com.roerdev.arqhexagonalmodular.product.model.dto.ProductDto;
import com.roerdev.arqhexagonalmodular.product.model.entity.Product;
import com.roerdev.arqhexagonalmodular.stock.model.dto.StockDto;
import com.roerdev.arqhexagonalmodular.stock.model.entity.Stock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class ProductDtoMapperTest {

    @Spy
    private ProductDtoMapper productDtoMapper = new ProductDtoMapperImpl();

    private Stock stockDomain = null;
    private Product productDomain = null;
    private StockDto stockDto = null;
    private ProductDto productDto = null;

    @BeforeEach
    void beforeAll() {
        stockDomain = Stock.builder().id(1L).size("S").stock(1L).build();
        productDomain = Product.builder()
                .id(1L)
                .name("ABC")
                .salesUnit(10L)
                .stocks(List.of(stockDomain))
                .build();
        stockDto = StockDto.builder().id(1L).size("S").stock(1L).build();
        productDto = ProductDto.builder()
                .id(1L)
                .name("ABC")
                .salesUnit(10L)
                .stocks(List.of(stockDto))
                .build();
    }

    @Test
    void mapToProductDto() {
        ProductDto mapper = productDtoMapper.mapToProductDto(productDomain);
        assertEquals(mapper.getId(), productDomain.getId());
    }

    @Test
    void mapToStockDto() {
        StockDto mapper = productDtoMapper.mapToStockDto(stockDomain);
        assertEquals(mapper.getId(), stockDomain.getId());
    }

    @Test
    void mapToProductDomain() {
        Product mapper = productDtoMapper.mapToProductDomain(productDto);
        assertEquals(mapper.getId(), productDto.getId());
    }

    @Test
    void mapToStockDomain() {
        Stock mapper = productDtoMapper.mapToStockDomain(stockDto);
        assertEquals(mapper.getId(), stockDto.getId());
    }
}