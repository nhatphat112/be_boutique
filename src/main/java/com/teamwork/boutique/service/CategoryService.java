package com.teamwork.boutique.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teamwork.boutique.entity.CategoryEntity;
import com.teamwork.boutique.payload.request.CategorySaveRequest;
import com.teamwork.boutique.payload.response.CategoryRespone;
import com.teamwork.boutique.repository.CategoryRepository;
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
    public List<CategoryRespone> getAllCategory() {
        List<CategoryRespone>responselist=new ArrayList<>();
        List<CategoryEntity> list =categoryRepository.findAll();


        for(CategoryEntity data: list) {
            CategoryRespone categoryRespone = new CategoryRespone();
            categoryRespone.setId(data.getId());
            categoryRespone.setName(data.getName());
            responselist.add(categoryRespone);
        }
        return responselist;
    }

    @Override
    public boolean createCate(CategorySaveRequest request) {
        boolean isSuccess=false;
        try {
            CategoryEntity category=new CategoryEntity();

            category.setName(request.getCategoryName());
            categoryRepository.save(category);
            isSuccess=true;
        }catch (Exception e) {

        }

        return isSuccess;
    }

    @Override
    public boolean deleteCate(CategorySaveRequest request) {
        boolean isSuccess=false;
        try {
            CategoryEntity category=new CategoryEntity();
            category.setId(request.getCategoryId());
            categoryRepository.delete(category);
            isSuccess=true;
        }catch (Exception e) {

        }

        return isSuccess;
    }

    @Override
    public boolean updateCate(CategorySaveRequest request) {
        boolean isSuccess=false;
        try {
            CategoryEntity category=new CategoryEntity();
            category.setId(request.getCategoryId());
            category.setName(request.getCategoryName());
            categoryRepository.save(category);
            isSuccess=true;
        }catch (Exception e) {

        }

        return isSuccess;    }
}