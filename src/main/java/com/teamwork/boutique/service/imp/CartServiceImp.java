package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.response.CartResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartServiceImp {
    boolean addToCart(int productId, int colorId, int quantity);

    List<CartResponse> getAllCart();
}
