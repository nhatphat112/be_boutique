package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.RoleEntity;
import com.teamwork.boutique.entity.UserEntity;
import com.teamwork.boutique.exception.CustomException;
import com.teamwork.boutique.payload.request.FindUserIdRequest;
import com.teamwork.boutique.payload.request.SignupRequest;
import com.teamwork.boutique.payload.response.LoginSigupResponse;
import com.teamwork.boutique.payload.response.UserResponse;
import com.teamwork.boutique.repository.UserRepository;
import com.teamwork.boutique.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginSigupResponse addUser(SignupRequest request) {
        LoginSigupResponse response = new LoginSigupResponse();
       try {

           boolean isSuccess = false;
           UserEntity user = new UserEntity();
           user.setUsername(request.getUsername());
           user.setPassword(passwordEncoder.encode(request.getPassword()));
           user.setEmail(request.getEmail());
           user.setRole(new RoleEntity());
           user.getRole().setId(2);
           if (userRepository.findByEmail(request.getEmail()) != null) {
               throw new CustomException("This email already exists.",400);
           }
           user = userRepository.saveAndFlush(user);
           response.setId(user.getId());
           response.setRoleId(user.getRole().getId());
           response.setUsername(user.getUsername());

       }catch (Exception e){
           throw new CustomException(e.getMessage(),400);
       }
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
    public int findUserId(FindUserIdRequest request) {
        try {
            UserEntity user = userRepository.findByEmail(request.getEmail());
            return user.getId();
        } catch (Exception e) {
            throw new CustomException("Lỗi add user " + e.getMessage());
        }
    }

    @Override
    public List<UserResponse> getAllUser() {
        try {
            List<UserResponse> listUser = new ArrayList<>();
            List<UserEntity> userEntityList = userRepository.findAll();
            for (UserEntity item :
                    userEntityList) {
                UserResponse user = new UserResponse();
                user.setId(item.getId());
                user.setName(item.getUsername());
                user.setRoleId(item.getRole().getId());
                listUser.add(user);
            }
            return listUser;
        } catch (Exception e) {
            throw new CustomException("Lỗi add user " + e.getMessage());
        }
    }
}
