package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.response.CityProviceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityProvinceServiceImp {
    List<CityProviceResponse> getAll();
}
