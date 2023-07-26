package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.response.AddressResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressServiceImp {
    List<AddressResponse> getByUserId(int userId);
}
