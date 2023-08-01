package com.teamwork.boutique.repository;

import com.teamwork.boutique.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Integer> {
    List<AddressEntity> findByUserId(int userId);
    List<AddressEntity> getByUserIdAndCountryIdAndCityProvinceIdAndDetail(int userId,int countryId,int cityProvinceId,String detail);
}
