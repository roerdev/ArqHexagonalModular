package com.roerdev.arqhexagonalmodular.product.services;

import com.roerdev.arqhexagonalmodular.product.port.output.dao.ProductDao;
import com.roerdev.arqhexagonalmodular.product.model.dto.WeightScoreDto;
import com.roerdev.arqhexagonalmodular.product.model.entity.Product;
import com.roerdev.arqhexagonalmodular.product.port.input.ProductGetAllOrderedUseCase;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductGetAllOrderedService implements ProductGetAllOrderedUseCase {

    private static final String SALES = "SALES";
    private final ProductDao productDao;

    public ProductGetAllOrderedService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProductOrderByWeight(WeightScoreDto... weightScoreDto) {

        List<Product> products = this.productDao.getAllProducts();

        products.sort((p1, p2) -> {
            double score1 = calculateWeightScore(p1, weightScoreDto);
            double score2 = calculateWeightScore(p2, weightScoreDto);
            return Double.compare(score2, score1);
        });

        return products;
    }

    private double calculateWeightScore(Product product, WeightScoreDto... weightScoreDto) {
        Map<String, Double> weightScoreMap = Arrays.stream(weightScoreDto)
                .collect(Collectors.toMap(WeightScoreDto::getFilter, WeightScoreDto::getScore));
        Double salesScore = Optional.of(weightScoreMap.get(SALES)).orElse(0.0);
        Double stockScore = product.getStocks().stream()
                .mapToDouble(stock -> {
                    return stock.getStock() *
                            Optional.of(weightScoreMap.get(stock.getSize().trim())).orElse(0.0);
                })
                .sum();
        return (product.getSalesUnit() * salesScore) + stockScore;
    }
}
