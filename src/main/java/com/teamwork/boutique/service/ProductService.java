package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.ProductEntity;
import com.teamwork.boutique.entity.ReviewEntity;
import com.teamwork.boutique.entity.StockEntity;
import com.teamwork.boutique.entity.TagProductEntity;
import com.teamwork.boutique.exception.CustomException;
import com.teamwork.boutique.payload.request.ProductRequest;
import com.teamwork.boutique.payload.request.SignupRequest;
import com.teamwork.boutique.payload.response.*;
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
        for (ProductEntity item : productRepository.findAll()) {
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
        List<ProductEntity> list = productRepository.findByCategoryId(id);
        List<ProductResponse> responseList = new ArrayList<>();
        for (ProductEntity data : list
        ) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(data.getId());
            productResponse.setName(data.getName());
            productResponse.setImage(data.getImage());
            productResponse.setPrice(stockRepository.findMinPriceByProductId(data.getId()));
            productResponse.setDesciption(data.getDesc());
            responseList.add(productResponse);
        }
        return responseList;
    }

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
@Override
    public boolean addProduct(ProductRequest request) {
        boolean isSuccess = false;
        try{
            ProductEntity product = new ProductEntity();
            product.setId(request.getId());
            product.setName(request.getName());
            product.setImage(request.getImage());
            product.setDesc(request.getDesc());
            productRepository.save(product);
            return isSuccess = true;
        }catch (Exception e) {
            throw new CustomException(e.getMessage());
        }

    }
}
