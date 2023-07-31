package com.teamwork.boutique.service.imp;


import com.teamwork.boutique.payload.request.SignupRequest;

public interface UserServiceImp {
    boolean addUser(SignupRequest request);
    boolean deleteUser(int userId);
}
