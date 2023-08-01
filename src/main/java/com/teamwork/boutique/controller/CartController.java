package com.teamwork.boutique.controller;

import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")

@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartServiceImp cartServiceImp;
    @GetMapping("/addToCart/{productId}/{colorId}/{quantity}")
    public ResponseEntity<?> addToCart(@PathVariable int productId,
                                       @PathVariable int colorId,
                                       @PathVariable int quantity){

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cartServiceImp.addToCart(productId, colorId, quantity));

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @GetMapping("")
    public ResponseEntity<?> getAllCart() {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cartServiceImp.getAllCart());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
