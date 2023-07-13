package com.teamwork.boutique.repository;


import com.teamwork.boutique.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    List<ProductEntity> findByCategoryId(int categoryId);
    ProductEntity findById (int id);



}
