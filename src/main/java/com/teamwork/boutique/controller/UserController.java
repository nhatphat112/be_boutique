package com.teamwork.boutique.controller;

import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllUser() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(userServiceImp.getAllUser());
        baseResponse.setMessage("Get All User");
        baseResponse.setStatusCode(200);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/updaterole")
    public ResponseEntity<?> updateUserRole(int userId, int roleId) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(userServiceImp.updateUserRole(userId, roleId));
        baseResponse.setMessage("Update user's role");
        baseResponse.setStatusCode(200);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
