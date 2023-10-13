package com.roerdev.arqhexagonalmodular.product.model.dto;

import com.roerdev.arqhexagonalmodular.stock.model.dto.StockDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private Long salesUnit;
    private List<StockDto> stocks;
}
