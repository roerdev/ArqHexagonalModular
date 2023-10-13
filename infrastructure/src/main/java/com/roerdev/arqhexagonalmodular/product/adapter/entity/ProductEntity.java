package com.roerdev.arqhexagonalmodular.product.adapter.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.roerdev.arqhexagonalmodular.stock.adapter.entity.StockEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "salesunit")
    private Long salesUnit;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = StockEntity.class)
    private List<StockEntity> stocks;
}
