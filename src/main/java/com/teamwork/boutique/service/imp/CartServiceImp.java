package com.teamwork.boutique.service.imp;

import org.springframework.stereotype.Service;

@Service
public interface CartServiceImp {
    boolean addToCart(int productId, int colorId, int quantity);

}
