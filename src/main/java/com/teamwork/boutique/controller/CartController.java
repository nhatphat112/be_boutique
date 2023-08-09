package com.teamwork.boutique.controller;

import com.google.gson.Gson;
import com.teamwork.boutique.exception.CustomException;
import com.teamwork.boutique.payload.request.CartDeleteByIdsListRequest;
import com.teamwork.boutique.payload.request.CartDeleteByIdsRequest;
import com.teamwork.boutique.payload.request.CartUpdateRequest;
import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.CartServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {
    @Autowired
    private CartServiceImp cartServiceImp;
    private Logger logger = LoggerFactory.getLogger(CartController.class);
    private Gson gson = new Gson();

    @GetMapping("/addToCart/{productId}/{colorId}/{quantity}/{userId}")
    public ResponseEntity<?> addToCart(@PathVariable int productId,
                                       @PathVariable int colorId,
                                       @PathVariable int quantity,
                                       @PathVariable int userId) {
        logger.info("Request :");
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cartServiceImp.addToCart(productId, colorId, quantity, userId));
        logger.info("Response :"+gson.toJson(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> getAllCart(@RequestParam int userId) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cartServiceImp.getAllCart(userId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/count/{userId}")
    public ResponseEntity<?> cartCount(@PathVariable int userId) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cartServiceImp.countCartItems(userId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/delete/{cartId}")
    public ResponseEntity<?> delete(@PathVariable int cartId) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cartServiceImp.delete(cartId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/update/{id}/{quantity}")
    public ResponseEntity<?> updateCart(@PathVariable int id, @PathVariable int quantity) {
        System.out.println("dang update");
        boolean isSuccess = cartServiceImp.updateCart(id,quantity);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/delete/ids")
    public ResponseEntity<?> deleteByIds(@RequestBody CartDeleteByIdsListRequest cartDeleteByIdsListRequest) {
        logger.info("Request :"+gson.toJson(cartDeleteByIdsListRequest));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Deleted list cart.");
        response.setData(cartServiceImp.deleteByIds(cartDeleteByIdsListRequest.getIds()));
        logger.info("Response :"+gson.toJson(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}