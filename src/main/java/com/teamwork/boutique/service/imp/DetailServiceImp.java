package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.response.DetailResponse;
import com.teamwork.boutique.payload.response.ProductResponse;
import com.teamwork.boutique.payload.response.StockResponse;

import java.util.List;

public interface DetailServiceImp {
    public DetailResponse getDetailProductByProductId(int productId);
}
