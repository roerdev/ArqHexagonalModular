package com.roerdev.arqhexagonalmodular;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.roerdev.arqhexagonalmodular.product.model.dto.ProductDto;
import com.roerdev.arqhexagonalmodular.product.model.dto.WeightScoreDto;
import com.roerdev.arqhexagonalmodular.product.model.entity.Product;
import com.roerdev.arqhexagonalmodular.product.port.input.ProductGetAllOrderedUseCase;
import com.roerdev.arqhexagonalmodular.product.rest.controller.ProductController;
import com.roerdev.arqhexagonalmodular.product.rest.mapper.ProductDtoMapper;
import com.roerdev.arqhexagonalmodular.product.rest.mapper.ProductDtoMapperImpl;
import com.roerdev.arqhexagonalmodular.product.rest.mapper.WeightScoreDtoMapper;
import com.roerdev.arqhexagonalmodular.product.rest.mapper.WeightScoreDtoMapperImpl;
import com.roerdev.arqhexagonalmodular.stock.model.dto.StockDto;
import com.roerdev.arqhexagonalmodular.stock.model.entity.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Spy
    private WeightScoreDtoMapper weightScoreDtoMapper = new WeightScoreDtoMapperImpl();

    @Spy
    private ProductDtoMapper productDtoMapper = new ProductDtoMapperImpl();

    @Mock
    private ProductGetAllOrderedUseCase productGetAllOrderedUseCase;

    @InjectMocks
    private ProductController productController;

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void getPrices() throws Exception {
        Stock stockDomain = Stock.builder().id(1L).size("S").stock(1L).build();
        Product productDomain = Product.builder()
                .id(1L)
                .name("ABC")
                .salesUnit(10L)
                .stocks(List.of(stockDomain))
                .build();
        StockDto stockDto = StockDto.builder().id(1L).size("S").stock(1L).build();
        ProductDto productDto = ProductDto.builder()
                .id(1L)
                .name("ABC")
                .salesUnit(10L)
                .stocks(List.of(stockDto))
                .build();

        List<ProductDto> productDtoList = List.of(productDto);

        when(productGetAllOrderedUseCase
                .getAllProductOrderByWeight(WeightScoreDto.builder().filter("S").score(1.0).build()))
                .thenReturn(List.of(productDomain));

        ResultActions result = mockMvc.perform(get("/api/v1/products/")
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(this.objectMapper.writeValueAsString(list)));
    }
}