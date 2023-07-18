package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.ProductEntity;
import com.teamwork.boutique.entity.ReviewEntity;
import com.teamwork.boutique.entity.StockEntity;
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
    private ProductRepository productRepository;

    @Override
    public DetailResponse getDetailProductByProductId(int productId) {
        ProductEntity item = productRepository.findById(productId);
        DetailResponse detailResponse = new DetailResponse();
        detailResponse.setProductId(item.getId());
        detailResponse.setCategory(item.getCategory().getName());
        detailResponse.setDescription(item.getDesc());
        List<ReviewResponse> responseList = new ArrayList<>();
        for (ReviewEntity review : item.getReviews()) {
            ReviewResponse reviewResponse = new ReviewResponse(item.getId(), review.getUser().getUsername(), review.getContent(), review.getAppriciation());
            responseList.add(reviewResponse);
        }
        detailResponse.setReviewList(responseList);
        return detailResponse;
    }
}
