package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.*;
import com.teamwork.boutique.payload.response.DetailResponse;
import com.teamwork.boutique.payload.response.ProductResponse;
import com.teamwork.boutique.payload.response.ReviewResponse;
import com.teamwork.boutique.payload.response.StockResponse;
import com.teamwork.boutique.repository.ProductRepository;
import com.teamwork.boutique.repository.StockRepository;
import com.teamwork.boutique.service.imp.DetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailService implements DetailServiceImp {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public DetailResponse getDetailProductByProductId(int productId) {
        ProductEntity item = productRepository.findById(productId);
        DetailResponse detailResponse = new DetailResponse();
        detailResponse.setName(item.getName());
        detailResponse.setProductId(item.getId());
        detailResponse.setCategory(item.getCategory().getName());
        detailResponse.setDescription(item.getDesc());
//        set reviewList for detail
        List<ReviewResponse> reviewList = new ArrayList<>();
        for (ReviewEntity review : item.getReviews()) {
            ReviewResponse reviewResponse = new ReviewResponse(item.getId(), review.getUser().getUsername(), review.getContent(), review.getAppriciation());
            reviewList.add(reviewResponse);
        }
        detailResponse.setReviewList(reviewList);
//        Set tagList for detail
        List<String> tagNameList = new ArrayList<>();
        for (TagProductEntity tagProduct : item.getTagProducts()) {
            tagNameList.add(tagProduct.getTag().getName());
        }
        detailResponse.setTagList(tagNameList);
//        Set stockList for detail
        List<StockResponse> stockResponseList = new ArrayList<>();
        for (StockEntity stock : item.getStocks()) {
            StockResponse stockResponse = new StockResponse();
            stockResponse.setId(stock.getId());
            stockResponse.setQuantity(stock.getQuantity());
            stockResponse.setImage(stock.getImage());
            stockResponse.setPrice(stock.getPrice());
            stockResponse.setColorId(stock.getColor().getId());
            stockResponse.setColorName(stock.getColor().getName());
            stockResponseList.add(stockResponse);
        }
        detailResponse.setStockResponseList(stockResponseList);
        return detailResponse;
    }
}
