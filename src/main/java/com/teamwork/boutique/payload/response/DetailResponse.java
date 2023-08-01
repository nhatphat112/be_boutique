package com.teamwork.boutique.payload.response;

import java.util.List;

public class DetailResponse {
    private int productId;
    private String description;
    private String category;

    private List<String> tagList;

    private List<ReviewResponse> reviewList;

    private List<StockResponse> stockResponseList;

    public List<StockResponse> getStockResponseList() {
        return stockResponseList;
    }

    public void setStockResponseList(List<StockResponse> stockResponseList) {
        this.stockResponseList = stockResponseList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public List<ReviewResponse> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<ReviewResponse> reviewList) {
        this.reviewList = reviewList;
    }
}
