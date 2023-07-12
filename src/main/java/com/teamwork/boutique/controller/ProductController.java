package com.teamwork.boutique.controller;

import com.google.gson.Gson;
import com.teamwork.boutique.payload.respone.BaseResponse;
import com.teamwork.boutique.service.imp.ProductServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    @CrossOrigin(value = "*")
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
}
