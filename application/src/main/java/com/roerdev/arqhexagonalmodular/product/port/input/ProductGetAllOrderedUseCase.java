package com.roerdev.arqhexagonalmodular.product.port.input;

import com.roerdev.arqhexagonalmodular.product.model.entity.Product;
import com.roerdev.arqhexagonalmodular.product.model.dto.WeightScoreDto;

import java.util.List;

public interface ProductGetAllOrderedUseCase {

    List<Product> getAllProductOrderByWeight(WeightScoreDto... weightScoreDtos);
}
