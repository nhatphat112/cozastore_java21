package com.cybersoft.cozastore_java21.repository;

import com.cybersoft.cozastore_java21.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    List<ProductEntity> findByCategoryId(int id);
}
