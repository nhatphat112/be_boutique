package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.CountryEntity;
import com.teamwork.boutique.payload.response.CountryResponse;
import com.teamwork.boutique.repository.CountryRepository;
import com.teamwork.boutique.service.imp.CountryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService implements CountryServiceImp {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<CountryResponse> getAll() {
        List<CountryResponse> countryResponses = new ArrayList<>();
        for (CountryEntity item : countryRepository.findAll()){
            CountryResponse response = new CountryResponse();
            response.setName(item.getName());
            response.setId(item.getId());
            countryResponses.add(response);
        }
        return countryResponses;
    }
}
