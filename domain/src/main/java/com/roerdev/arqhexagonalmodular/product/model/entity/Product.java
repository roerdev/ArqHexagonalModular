package com.roerdev.arqhexagonalmodular.product.model.entity;

import com.roerdev.arqhexagonalmodular.stock.model.entity.Stock;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Product {

    private Long id;
    private String name;
    private Long salesUnit;
    private List<Stock> stocks;
}
