package com.teamwork.boutique.repository;

import com.teamwork.boutique.Entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity,Integer>{
    StockEntity findByProductIdAndColorId(int productId, int colorId);
}