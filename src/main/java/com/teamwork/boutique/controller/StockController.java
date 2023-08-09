package com.teamwork.boutique.controller;

import com.google.gson.Gson;
import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.StockServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(StockController.class);
    @Autowired
    private StockServiceImp stockServiceImp;
    @CrossOrigin(value = "*")
    @GetMapping("/product")
    public ResponseEntity<?> getStockByProductId(@RequestParam int id){
        logger.info("reuquest:"+id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(stockServiceImp.getStockByProductId(id));
        baseResponse.setMessage("List Stock By ProDuct Id");
        baseResponse.setStatusCode(200);
        logger.info("response:"+gson.toJson(baseResponse));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<?> getAllCategory(){
        BaseResponse response=new BaseResponse();
        response.setStatusCode(200);
        response.setData(stockServiceImp.getAllStock());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addStock(int colorId, int quantity, int productId, double price, String imageUrl) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(stockServiceImp.addStock(colorId,quantity,productId,price,imageUrl));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/delete")
    public ResponseEntity<?> deletestock(int id) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(stockServiceImp.deletestock(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
