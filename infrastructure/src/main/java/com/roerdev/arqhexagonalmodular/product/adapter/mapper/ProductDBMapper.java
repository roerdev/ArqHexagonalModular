package com.roerdev.arqhexagonalmodular.product.adapter.mapper;

import com.roerdev.arqhexagonalmodular.product.adapter.entity.ProductEntity;
import com.roerdev.arqhexagonalmodular.stock.adapter.entity.StockEntity;
import com.roerdev.arqhexagonalmodular.product.model.entity.Product;

import com.roerdev.arqhexagonalmodular.stock.model.entity.Stock;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDBMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "salesUnit", target = "salesUnit")
    ProductEntity mapToProductEntity(Product domain);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "size", target = "size")
    @Mapping(source = "stock", target = "stock")
    StockEntity mapToStockEntity(Stock domain);

    @InheritInverseConfiguration
    Product cloneToProductDomain(ProductEntity entity);

    default Stock toStockDomain(StockEntity stockEntity) {
        if (stockEntity == null) {
            return null;
        }
        Stock.StockBuilder stock = Stock.builder();

        stock.id( stockEntity.getId());
        stock.size( stockEntity.getSize());
        stock.stock( stockEntity.getStock());
        return stock.build();
    }
}
