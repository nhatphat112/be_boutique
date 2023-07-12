package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.response.StockResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockServiceImp {
    List<StockResponse> getStockByProductId(int productId);
}
