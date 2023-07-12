package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.UserEntity;
import com.teamwork.boutique.exception.CustomException;
import com.teamwork.boutique.payload.request.SignupRequest;
import com.teamwork.boutique.repository.UserRepository;
import com.teamwork.boutique.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(SignupRequest request) {
        boolean isSuccess = false;
        try {
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());
            userRepository.save(user);
            isSuccess = true;
        } catch (Exception e) {
            throw new CustomException("Lỗi add user " + e.getMessage());
        }
        return isSuccess;
    }
}
