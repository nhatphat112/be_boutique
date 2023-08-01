package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.RoleEntity;
import com.teamwork.boutique.entity.UserEntity;
import com.teamwork.boutique.exception.CustomException;
import com.teamwork.boutique.payload.request.FindUserIdRequest;
import com.teamwork.boutique.payload.request.SignupRequest;
import com.teamwork.boutique.payload.response.LoginSigupResponse;
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
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginSigupResponse addUser(SignupRequest request) {
        LoginSigupResponse response = new LoginSigupResponse();
        boolean isSuccess = false;
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());
            user.setRole(new RoleEntity());
            user.getRole().setId(2);
            if(userRepository.findByEmail(request.getEmail())!=null){
                throw new CustomException("This email already exists.");
            }
            user = userRepository.saveAndFlush(user);
            response.setId(user.getId());
            response.setRoleId(user.getRole().getId());
            response.setUsername(user.getUsername());

        return response;
    }

    @Override
    public boolean deleteUser(int userId) {
        boolean isSuccess = false;
        try {
            userRepository.deleteById(userId);
            isSuccess = true;
        } catch (Exception e) {
            throw new CustomException("Lỗi delete user " + e.getMessage());
        }
        return isSuccess;
    }
    @Override
    public int findUserId(FindUserIdRequest request){
        try {
            UserEntity user = userRepository.findByEmail(request.getEmail());
            return user.getId();
        } catch (Exception e) {
            throw new CustomException("Lỗi add user " + e.getMessage());
        }
    }
}
