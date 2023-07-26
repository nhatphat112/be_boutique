package com.teamwork.boutique.controller;

import com.google.gson.Gson;
import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.AddressServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressServiceImp addressServiceImp;
    private Logger logger = LoggerFactory.getLogger(AddressController.class);
    @GetMapping("/user")
    public ResponseEntity<?> getById(@RequestParam int id){
        logger.info("Request : userId :"+id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("List Address by User ID");
        response.setData(addressServiceImp.getByUserId(id));
        logger.info("Response :"+new Gson().toJson(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
