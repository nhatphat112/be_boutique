package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.StockEntity;
import com.teamwork.boutique.payload.response.StockResponse;
import com.teamwork.boutique.repository.StockRepository;
import com.teamwork.boutique.service.imp.StockServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService implements StockServiceImp {
    @Autowired
    private StockRepository stockRepository;
    @Override
    public List<StockResponse> getStockByProductId(int productId) {
        List<StockResponse> stockResponses = new ArrayList<>();
        for (StockEntity item : stockRepository.findByProductId(productId)){
            StockResponse response = new StockResponse();
            response.setId(item.getId());
            response.setColorName(item.getColor().getName());
            response.setQuantity(item.getQuantity());
            response.setPrice(item.getPrice());
            response.setImage(item.getImage());
            response.setColorId(item.getColor().getId());
            stockResponses.add(response);
        }
        return stockResponses;
    }
}
