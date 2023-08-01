package com.teamwork.boutique.controller;

import com.teamwork.boutique.exception.CustomException;
import com.teamwork.boutique.payload.request.FindUserIdRequest;
import com.teamwork.boutique.payload.request.SignupRequest;
import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.UserServiceImp;
import com.teamwork.boutique.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtHelper jwtHelper;
    @Autowired
    UserServiceImp userServiceImp;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> signin(@RequestParam String email, @RequestParam String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        authenticationManager.authenticate(token);
        String jwt = jwtHelper.generateToken(email);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(jwt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@Valid SignupRequest request, BindingResult result) {
        List<FieldError> list = result.getFieldErrors();
        for (FieldError data :
                list) {
            throw new CustomException(data.getDefaultMessage());
        }
        boolean isSuccess = userServiceImp.addUser(request);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/signin/findUserId", method = RequestMethod.POST)
    public ResponseEntity<?> findUserId(FindUserIdRequest request) {
        int id = userServiceImp.findUserId(request);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(id);
        System.out.println(id+" newuserId");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
