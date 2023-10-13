package com.roerdev.arqhexagonalmodular.product.rest.controller;

import com.roerdev.arqhexagonalmodular.product.model.dto.ProductDto;
import com.roerdev.arqhexagonalmodular.product.port.input.ProductGetAllOrderedUseCase;
import com.roerdev.arqhexagonalmodular.product.rest.mapper.ProductDtoMapper;
import com.roerdev.arqhexagonalmodular.product.rest.mapper.WeightScoreDtoMapper;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin()
@RequestMapping("/api/v1/products")
@Tag(name = "Product", description = "Product operations")
@Slf4j
public class ProductController {

    private static final List<String> FILTERS = Arrays.asList("SALES", "S", "M", "L");
    private final ProductGetAllOrderedUseCase productGetAllOrderedUseCase;
    private final ProductDtoMapper productDtoMapper;
    private final WeightScoreDtoMapper weightScoreDtoMapper;


    public ProductController(ProductGetAllOrderedUseCase productGetAllOrderedUseCase,
                             ProductDtoMapper productDtoMapper, WeightScoreDtoMapper weightScoreDtoMapper) {
        this.productGetAllOrderedUseCase = productGetAllOrderedUseCase;
        this.productDtoMapper = productDtoMapper;
        this.weightScoreDtoMapper = weightScoreDtoMapper;
    }

    @GetMapping("/")
    @ApiResponse(responseCode = "200", description = "Products found for current input data", content = @Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = ProductDto.class)))
    @ApiResponse(responseCode = "204", description = "No products found for the current input parameters", content = @Content(mediaType = "application/json"))
    public ResponseEntity<List<ProductDto>> getPrices(
            @RequestParam(name = "SALES", defaultValue = "0.0") Double sales,
            @RequestParam(name = "S", defaultValue = "0.0") Double sizeS,
            @RequestParam(name = "M", defaultValue = "0.0") Double sizeM,
            @RequestParam(name = "L", defaultValue = "0.0") Double sizeL) {

        log.debug("score weight(SALES={},S={},M={},L={})", sales, sizeS, sizeM, sizeL);

        List<Double> scores = Arrays.asList(sales, sizeS, sizeM, sizeL);

        List<ProductDto> products = this.productGetAllOrderedUseCase
                .getAllProductOrderByWeight(this.weightScoreDtoMapper.mapToWeightScoreDtoArray(FILTERS, scores))
                .stream().map(productDtoMapper::mapToProductDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(products);
    }
}
