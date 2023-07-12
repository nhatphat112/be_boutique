package com.teamwork.boutique.service.imp;


import com.teamwork.boutique.payload.response.ProductResponse;

import java.util.List;

public interface ProductServiceImp {
    List<ProductResponse> getProductByCategoryID(int id);
}
