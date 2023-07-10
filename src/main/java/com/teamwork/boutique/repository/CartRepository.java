package com.teamwork.boutique.repository;

import com.teamwork.boutique.Entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {
    CartEntity findByStockIdAndUserId(int stockId, int userId);

}
