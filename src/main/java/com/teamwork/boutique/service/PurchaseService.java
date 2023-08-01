package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.ReviewEntity;
import com.teamwork.boutique.entity.UserEntity;
import com.teamwork.boutique.exception.CustomException;
import com.teamwork.boutique.payload.request.ReviewRequest;
import com.teamwork.boutique.repository.ReviewRepository;
import com.teamwork.boutique.service.imp.PurchaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService implements PurchaseServiceImp {
    @Autowired
    ReviewRepository reviewRepository;
    public boolean addReview(ReviewRequest reviewRequest){
        boolean isSuccess = false;
        try {
            ReviewEntity review = new ReviewEntity();
            review.setAppriciation(reviewRequest.getStarNumber());
            review.setContent(reviewRequest.getContent());
            review.setUser(reviewRequest.getUserId());
            review.setProduct(reviewRequest.getProductId());
            reviewRepository.save(review);
            isSuccess = true;
        } catch (Exception e) {
            throw new CustomException("Lỗi add review " + e.getMessage());
        }
        return isSuccess;
    }
}
