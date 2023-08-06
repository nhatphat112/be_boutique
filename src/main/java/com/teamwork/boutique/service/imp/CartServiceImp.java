package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.request.CartUpdateRequest;
import com.teamwork.boutique.payload.response.CartResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartServiceImp {
    boolean addToCart(int productId, int colorId, int quantity, int userId);

    List<CartResponse> getAllCart(int userId);

    boolean delete(int cartId);

    int countCartItems(int userId);
    boolean updateCart(int id, int quantity);
}