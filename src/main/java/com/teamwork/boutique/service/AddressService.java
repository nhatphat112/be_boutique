package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.AddressEntity;
import com.teamwork.boutique.payload.response.AddressResponse;
import com.teamwork.boutique.repository.AddressRepository;
import com.teamwork.boutique.service.imp.AddressServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService implements AddressServiceImp {
    @Autowired
    private AddressRepository repository;
    @Override
    public List<AddressResponse> getByUserId(int userId) {
        List<AddressResponse> addressResponses = new ArrayList<>();
        for (AddressEntity item : repository.getByUserId(userId)){
            AddressResponse response = new AddressResponse();
            response.setId(item.getId());
            response.setCountryName(item.getCountry().getName());
            response.setDetail(item.getDetail());
            response.setFee(item.getFee());
            response.setCityOrProvinceName(item.getCityProvince().getName());
            addressResponses.add(response);

        }
        return addressResponses;
    }
}
