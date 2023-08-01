package com.teamwork.boutique.controller;

import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.repository.ProductRepository;
import com.teamwork.boutique.service.imp.DetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detail")
@CrossOrigin("*")
public class DetailController {
    @Autowired
    DetailServiceImp detailServiceImp;
    @GetMapping("")
    public ResponseEntity<?> detailProduct(@RequestParam int id) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(detailServiceImp.getDetailProductByProductId(id));
        baseResponse.setMessage("Detail by product id");
        baseResponse.setStatusCode(200);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
