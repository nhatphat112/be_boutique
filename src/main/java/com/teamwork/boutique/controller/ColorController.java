package com.teamwork.boutique.controller;

import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.ColorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/color")
@CrossOrigin("*")
public class ColorController {
    @Autowired
    ColorServiceImp colorServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllColor() {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(colorServiceImp.getAllColor());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
