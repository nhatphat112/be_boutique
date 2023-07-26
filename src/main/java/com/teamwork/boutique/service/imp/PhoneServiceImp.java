package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.response.PhoneResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhoneServiceImp {
    List<PhoneResponse> getByUserId(int userId);

}
