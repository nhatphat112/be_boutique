package com.teamwork.boutique.service.imp;


import com.teamwork.boutique.payload.request.SignupRequest;
import com.teamwork.boutique.payload.response.LoginSigupResponse;

public interface UserServiceImp {
    LoginSigupResponse addUser(SignupRequest request);
    boolean deleteUser(int userId);
}
