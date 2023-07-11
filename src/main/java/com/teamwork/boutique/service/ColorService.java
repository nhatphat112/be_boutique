package com.teamwork.boutique.service;

import com.google.gson.Gson;
import com.teamwork.boutique.entity.ColorEntity;
import com.teamwork.boutique.payload.response.ColorResponse;
import com.teamwork.boutique.repository.ColorRepository;
import com.teamwork.boutique.service.imp.ColorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService implements ColorServiceImp {
    @Autowired
    ColorRepository colorRepository;

    @Override
    public List<ColorResponse> getAllColor() {
        System.out.println("Kiem tra color");
        List<ColorResponse> listResponse = new ArrayList<>();

        List<ColorEntity> list = colorRepository.findAll();
        for (ColorEntity data : list) {
            ColorResponse response = new ColorResponse();
            response.setId(data.getId());
            response.setName(data.getName());
            listResponse.add(response);
        }
        Gson gson = new Gson();
        String data = gson.toJson(listResponse);

        return listResponse;
    }
}
