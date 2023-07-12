package com.teamwork.boutique.controller;


import com.google.gson.Gson;
import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.ProductServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;

    private Logger logger= LoggerFactory.getLogger(ProductController.class);

    private Gson gson=new Gson();
    @GetMapping("/category/{id}")
    public ResponseEntity<?>getProductByCategory(@PathVariable int id){
        logger.info("tham so"+id);
        BaseResponse response=new BaseResponse();
        response.setStatusCode(200);
        response.setData(productServiceImp.getProductByCategoryID(id));

        logger.info(gson.toJson(response));

    return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
