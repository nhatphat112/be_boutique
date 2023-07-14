package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.ProductEntity;
import com.teamwork.boutique.payload.response.ProductResponse;
import com.teamwork.boutique.repository.ProductRepository;
import com.teamwork.boutique.repository.StockRepository;
import com.teamwork.boutique.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StockRepository stockRepository;
    @Override
    public List<ProductResponse> getAllCategory() {
        List<ProductResponse> productResponses = new ArrayList<>();
//        System.out.println("Check price:"+price);
        for (ProductEntity item : productRepository.findAll()){
            ProductResponse response = new ProductResponse();
            response.setId(item.getId());
            response.setName(item.getName());
            response.setImage(item.getImage());
            response.setPrice(stockRepository.findMinPriceByProductId(item.getId()));
            response.setDesciption(item.getDesc());
            productResponses.add(response);
        }

        return productResponses;
    }

    @Override
    public List<ProductResponse> getProductByCategory(int id) {
        List<ProductEntity>list=productRepository.findByCategoryId(id);
        List<ProductResponse>responseList=new ArrayList<>();
        for (ProductEntity data:    list
        ) {ProductResponse productResponse = new ProductResponse();
            productResponse.setId(data.getId());
            productResponse.setName(data.getName());
            productResponse.setImage(data.getImage());
            productResponse.setPrice(stockRepository.findMinPriceByProductId(data.getId()));
            productResponse.setDesciption(data.getDesc());
            responseList.add(productResponse);

        }
        return responseList;
    }
}
