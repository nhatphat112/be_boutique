package com.teamwork.boutique.controller;

import com.google.gson.Gson;
import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.ProductServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    @GetMapping("")
    public ResponseEntity<?> getAllProduct(){
        logger.info("request :none");
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(productServiceImp.getAllCategory());
        baseResponse.setStatusCode(200);
        baseResponse.setMessage("List Product");
        logger.info("response"+gson.toJson(baseResponse));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @GetMapping("/detail")
    public ResponseEntity<?> detailProduct(@RequestParam int id) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(productServiceImp.getDetailProductByProductId(id));
        baseResponse.setMessage("Detail by product id");
        baseResponse.setStatusCode(200);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
