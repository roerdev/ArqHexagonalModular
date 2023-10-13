package com.roerdev.arqhexagonalmodular.stock.model.entity;

import com.roerdev.arqhexagonalmodular.product.model.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class Stock {

    private Long id;
    private Product product;
    private String size;
    private Long stock;
}
