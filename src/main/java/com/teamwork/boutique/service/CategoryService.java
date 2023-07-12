package com.teamwork.boutique.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teamwork.boutique.entity.CategoryEntity;
import com.teamwork.boutique.entity.ProductEntity;
import com.teamwork.boutique.payload.response.CategoryResponse;
import com.teamwork.boutique.repository.CartRepository;
import com.teamwork.boutique.repository.CategoryRepository;
import com.teamwork.boutique.repository.ProductRepository;
import com.teamwork.boutique.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategory() {
        System.out.println("Kiem tra category");
        List<CategoryResponse> listResponse = new ArrayList<>();
        List<CategoryEntity> list = categoryRepository.findAll();
        for (CategoryEntity data : list) {
            CategoryResponse response = new CategoryResponse();
            response.setId(data.getId());
            response.setName(data.getName());
            listResponse.add(response);
        }
        Gson gson = new Gson();
        String data = gson.toJson(listResponse);
        return listResponse;
    }
}
