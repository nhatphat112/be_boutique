package com.teamwork.boutique.service.imp;



import com.teamwork.boutique.payload.request.CategorySaveRequest;
import com.teamwork.boutique.payload.response.CategoryRespone;

import java.util.List;

public interface CategoryServiceImp {
    List<CategoryRespone>getAllCategory();
    boolean createCate(CategorySaveRequest request);
    boolean deleteCate(CategorySaveRequest request);
    boolean updateCate(CategorySaveRequest request);
}