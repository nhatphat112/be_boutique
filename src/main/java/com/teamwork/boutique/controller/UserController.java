package com.teamwork.boutique.controller;

import com.teamwork.boutique.payload.request.ChangePasswordRequest;
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
    public ResponseEntity<?> updateUserRole(@RequestParam int userId, @RequestParam int roleId) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(userServiceImp.updateUserRole(userId, roleId));
        baseResponse.setMessage("Update user's role");
        baseResponse.setStatusCode(200);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/getid")
    public ResponseEntity<?> getUserIdByToken(@RequestParam String token) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(userServiceImp.getUserIdByToken(token));
        baseResponse.setMessage("Get user id by token");
        baseResponse.setStatusCode(200);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @RequestMapping(value = "/changepass",method = RequestMethod.POST)
    public ResponseEntity<?> changePassword(ChangePasswordRequest request){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(userServiceImp.changePassword(request));
        baseResponse.setMessage("change password");
        baseResponse.setStatusCode(200);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @PostMapping("/getUser")
    public ResponseEntity<?> getUserById(@RequestParam int userId) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(userServiceImp.getUserById(userId));
        baseResponse.setMessage("Get username by id");
        baseResponse.setStatusCode(200);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
