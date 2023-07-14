package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductServiceImp {
    List<ProductResponse> getAllCategory();
    List<ProductResponse> getProductByCategory(int id);
}
