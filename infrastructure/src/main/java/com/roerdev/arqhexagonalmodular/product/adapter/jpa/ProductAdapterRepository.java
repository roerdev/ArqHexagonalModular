package com.roerdev.arqhexagonalmodular.product.adapter.jpa;

import com.roerdev.arqhexagonalmodular.product.adapter.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAdapterRepository extends JpaRepository<ProductEntity, Long> {

}
