package com.roerdev.arqhexagonalmodular.product.rest.mapper;

import com.roerdev.arqhexagonalmodular.product.model.dto.ProductDto;
import com.roerdev.arqhexagonalmodular.stock.model.dto.StockDto;
import com.roerdev.arqhexagonalmodular.product.model.entity.Product;
import com.roerdev.arqhexagonalmodular.stock.model.entity.Stock;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "salesUnit", target = "salesUnit")
    ProductDto mapToProductDto(Product domain);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "size", target = "size")
    @Mapping(source = "stock", target = "stock")
    StockDto mapToStockDto(Stock domain);

    @InheritInverseConfiguration
    Product mapToProductDomain(ProductDto dto);

    @InheritInverseConfiguration
    Stock mapToStockDomain(StockDto dto);

}
