package com.teamwork.boutique.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teamwork.boutique.entity.ProductEntity;
import com.teamwork.boutique.entity.ReviewEntity;
import com.teamwork.boutique.entity.StockEntity;
import com.teamwork.boutique.entity.TagProductEntity;
import com.teamwork.boutique.entity.*;
import com.teamwork.boutique.exception.CustomException;
import com.teamwork.boutique.payload.request.ProductRequest;
import com.teamwork.boutique.payload.response.*;
import com.teamwork.boutique.repository.CategoryRepository;
import com.teamwork.boutique.repository.ProductRepository;
import com.teamwork.boutique.repository.StockRepository;
import com.teamwork.boutique.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponse> getAllProduct() {
        List<ProductResponse> productResponses = new ArrayList<>();
        if (redisTemplate.hasKey("listProduct")) {
            System.out.println("co gia tri tren redis");
            String data = redisTemplate.opsForValue().get("listProduct").toString();
            Type listType = new TypeToken<ArrayList<ProductResponse>>() {
            }.getType();
            productResponses = new Gson().fromJson(data, listType);
        } else {
            System.out.println("khong co gia tri tren redis");
            for (ProductEntity item : productRepository.findAll()) {
                ProductResponse response = new ProductResponse();
                response.setId(item.getId());
                response.setName(item.getName());
                response.setImage(item.getImage());
                double minPrice = 0;
                try {
                    minPrice = stockRepository.findMinPriceByProductId(item.getId());
                } catch (Exception e) {

                }
                response.setPrice(minPrice);
                response.setDescription(item.getDesc());

                response.setCategoryId(item.getCategory().getId());
                response.setSoldQuantity(item.getSoldQuantity());
                productResponses.add(response);
            }
            Gson gson = new Gson();
            String data = gson.toJson(productResponses);
            redisTemplate.opsForValue().set("listProduct", data);
//        System.out.println("Check price:"+price);

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
            productResponse.setDescription(data.getDesc());
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
    public boolean saveProduct(ProductRequest request) {
        boolean isSuccess = false;
        try {
            System.out.println("da thuc hien lenh");
            ProductEntity product = new ProductEntity();
            try {
                product.setId(request.getId());

            } catch (Exception e) {

            }
            product.setName(request.getName());
            product.setImage(request.getImage());
            product.setDesc(request.getDesc());
            CategoryEntity category = categoryRepository.findById(request.getCategoryId());
            product.setCategory(category);
            productRepository.save(product);

            isSuccess = true;
            if (isSuccess) {
                System.out.println("da thanh cong");
            } else {
                System.out.println("da that bai");
            }
            List<ProductResponse> list = getAllProduct();
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
        return isSuccess;

    }

    @Override
    public boolean deleteProduct(int id) {
        boolean isSuccess = false;
        try {
            ProductEntity product = productRepository.findById(id);
            productRepository.delete(product);
            isSuccess = true;
        } catch (Exception e) {
            throw new CustomException("Lỗi delete product " + e.getMessage());
        }
        return isSuccess;
    }

}
