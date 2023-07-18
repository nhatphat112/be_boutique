package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.response.OrderDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailServiceImp {
    public List<OrderDetailResponse> getByUserId(int userId);

}
