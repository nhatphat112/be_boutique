package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.AddressEntity;
import com.teamwork.boutique.entity.CityProvinceEntity;
import com.teamwork.boutique.entity.CountryEntity;
import com.teamwork.boutique.entity.UserEntity;
import com.teamwork.boutique.payload.request.AddressSaveRequest;
import com.teamwork.boutique.payload.response.AddressResponse;
import com.teamwork.boutique.repository.AddressRepository;
import com.teamwork.boutique.service.imp.AddressServiceImp;
import org.apache.catalina.User;
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

    @Override
    public AddressResponse save(AddressSaveRequest request) {
        AddressResponse response = new AddressResponse();
        AddressEntity addressEntity = new AddressEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(request.getUserId());
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(request.getCountryId());
        CityProvinceEntity cityProvinceEntity = new CityProvinceEntity();
        cityProvinceEntity.setId(request.getCityProvinceId());
        addressEntity.setUser(userEntity);
        addressEntity.setFee(feeComputing(request.getCountryId(), request.getCityProvinceId()));
        addressEntity.setDetail(request.getDetail());
        addressEntity.setCountry(countryEntity);
        addressEntity.setCityProvince(cityProvinceEntity);
        repository.save(addressEntity);
        for (AddressEntity item :repository.getByUserIdAndCountryIdAndCityProvinceIdAndDetail(request.getUserId(), request.getCountryId(), request.getCityProvinceId(), request.getDetail())){
            response.setId(item.getId());
            break;
        }

        return response;
    }
    private double feeComputing(int countryId,int cityProvinceId){
        if(countryId==191){
            if(cityProvinceId==58){
                return 0;
            }else {
                return 30;
            }
        }
        return 50;
    }


}
