package com.teamwork.boutique.service.imp;

import com.teamwork.boutique.payload.response.CartResponse;

import java.util.List;

public interface CartServiceImp {
    boolean addToCart(int productId, int colorId, int quantity);
    List<CartResponse> getAllCart();
}
