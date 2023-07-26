package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.PhoneEntity;
import com.teamwork.boutique.payload.response.PhoneResponse;
import com.teamwork.boutique.repository.PhoneRepository;
import com.teamwork.boutique.service.imp.PhoneServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService implements PhoneServiceImp {
    @Autowired
    private PhoneRepository repository;
    @Override
    public List<PhoneResponse> getByUserId(int userId) {
        List<PhoneResponse> phoneResponses = new ArrayList<>();
        for(PhoneEntity item : repository.getByUserId(userId)){
            PhoneResponse response = new PhoneResponse();
            response.setId(item.getId());
            response.setPhoneNumber(item.getPhoneNumber());
            response.setUserId(item.getUser().getId());
            phoneResponses.add(response);
        }
        return phoneResponses;
    }
}
