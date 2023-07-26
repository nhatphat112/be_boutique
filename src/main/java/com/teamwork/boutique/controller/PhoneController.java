package com.teamwork.boutique.controller;

import com.google.gson.Gson;
import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.PhoneServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private PhoneServiceImp phoneServiceImp;
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(PhoneController.class);
    @GetMapping("/user")
    public ResponseEntity<?> getById(@RequestParam int id){
        logger.info("Request : userId :"+id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("List Phone number by User ID");
        baseResponse.setData(phoneServiceImp.getByUserId(id));
        baseResponse.setStatusCode(200);
        logger.info("Response :"+gson.toJson(baseResponse));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
