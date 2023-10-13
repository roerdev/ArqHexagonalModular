package com.roerdev.arqhexagonalmodular.stock.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.roerdev.arqhexagonalmodular.product.model.dto.ProductDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class StockDto {

    private Long id;
    @JsonIgnore
    private ProductDto product;
    private String size;
    private Long stock;
}
