package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.response.DetailResponse;
import com.teamwork.boutique.payload.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServiceImp {
    List<ProductResponse> getAllCategory();

    Object getProductByCategory(int id);

    DetailResponse getDetailProductByProductId(int productId);

}
