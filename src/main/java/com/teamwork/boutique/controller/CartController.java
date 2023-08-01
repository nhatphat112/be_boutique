package com.teamwork.boutique.controller;

import com.teamwork.boutique.exception.CustomException;
import com.teamwork.boutique.payload.request.CartUpdateRequest;
import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {
    @Autowired
    private CartServiceImp cartServiceImp;

    @GetMapping("/addToCart/{productId}/{colorId}/{quantity}/{userId}")
    public ResponseEntity<?> addToCart(@PathVariable int productId,
                                       @PathVariable int colorId,
                                       @PathVariable int quantity,
                                       @PathVariable int userId) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cartServiceImp.addToCart(productId, colorId, quantity, userId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> getAllCart(@RequestParam int userId) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cartServiceImp.getAllCart(userId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    /*
    @GetMapping("/count/{email}")
    public ResponseEntity<?> cartCount(@PathVariable String email) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cartServiceImp.countCartItems(email));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
     */

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
}