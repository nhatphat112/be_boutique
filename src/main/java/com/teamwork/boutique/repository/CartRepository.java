package com.teamwork.boutique.repository;

import com.teamwork.boutique.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {
    CartEntity findByStockAndUser(int stockId, int userId);
    CartEntity findByStockId(int stockId);
}
