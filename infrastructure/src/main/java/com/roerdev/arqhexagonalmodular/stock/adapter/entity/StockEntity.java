package com.roerdev.arqhexagonalmodular.stock.adapter.entity;

import com.roerdev.arqhexagonalmodular.product.adapter.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "stock")
public class StockEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product")
    private ProductEntity product;
    @Column(name = "size")
    private String size;
    @Column(name = "stock")
    private Long stock;
}
