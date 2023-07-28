package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.CityProvinceEntity;
import com.teamwork.boutique.payload.response.CityProviceResponse;
import com.teamwork.boutique.repository.CityProvinceRepository;
import com.teamwork.boutique.service.imp.CityProvinceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CityProvinceService implements CityProvinceServiceImp {
    @Autowired
    private CityProvinceRepository repository;
    @Override
    public List<CityProviceResponse> getAll() {
       List<CityProviceResponse> cityProviceResponses = new ArrayList<>();
        for (CityProvinceEntity item : repository.findAll()){
            CityProviceResponse response = new CityProviceResponse();
            response.setName(item.getName());
            response.setId(item.getId());
            cityProviceResponses.add(response);
        }
       return cityProviceResponses;
    }
}
