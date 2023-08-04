package com.teamwork.boutique.repository;

import com.teamwork.boutique.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    List<RoleEntity> findById(int id);
}
