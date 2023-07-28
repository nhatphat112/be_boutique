package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.*;
import com.teamwork.boutique.payload.request.OrderSaveRequest;
import com.teamwork.boutique.payload.response.OrderSaveResponse;
import com.teamwork.boutique.repository.OrderRepository;
import com.teamwork.boutique.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    private OrderRepository repository;
    @Override
    public OrderSaveResponse save(OrderSaveRequest request) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAddress(new AddressEntity());
        orderEntity.getAddress().setId(request.getAddressId());
        orderEntity.setUser(new UserEntity());
        orderEntity.getUser().setId(request.getUserId());
        orderEntity.setPhone(new PhoneEntity());
        orderEntity.getPhone().setId(request.getPhoneId());
        orderEntity.setStatus(new StatusEntity());
        orderEntity.getStatus().setId(request.getStatusId());
        orderEntity.setTotal(request.getTotal());
        orderEntity = repository.saveAndFlush(orderEntity);
        OrderSaveResponse response = new OrderSaveResponse();
        response.setId(orderEntity.getId());
        response.setUserId(orderEntity.getUser().getId());
        return response;
    }
}
