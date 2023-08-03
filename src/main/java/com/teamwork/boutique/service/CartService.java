package com.teamwork.boutique.service;

import com.google.gson.Gson;
import com.teamwork.boutique.entity.CartEntity;
import com.teamwork.boutique.entity.ProductEntity;
import com.teamwork.boutique.entity.StockEntity;
import com.teamwork.boutique.entity.UserEntity;
import com.teamwork.boutique.payload.request.CartUpdateRequest;
import com.teamwork.boutique.payload.response.CartResponse;
import com.teamwork.boutique.repository.CartRepository;
import com.teamwork.boutique.repository.ProductRepository;
import com.teamwork.boutique.repository.StockRepository;
import com.teamwork.boutique.repository.UserRepository;
import com.teamwork.boutique.service.imp.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements CartServiceImp {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean addToCart(int productId, int colorId, int quantity, int userId) {
        boolean isSuccess = false;
        StockEntity stock = stockRepository.findByProductIdAndColorId(productId, colorId);
        UserEntity user = userRepository.findById(userId);
        try {
            if (stock != null && user != null) {
                System.out.println(stock.getQuantity() + " product Quantity");
                CartEntity cart = cartRepository.findByStockIdAndUserId(stock.getId(), user.getId());
                if (cart == null) {//nếu stock chưa tồn tại
                    cart = new CartEntity();
                    System.out.println(cart + " cart is null?");
                    cart.setStock(stock);
                    cart.setUser(user);
                    cart.setQuantity(quantity);
                } else {
                    cart.setQuantity(cart.getQuantity() + quantity);
                }
                cartRepository.save(cart);
                return isSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi addToCart " + e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public List<CartResponse> getAllCart(int userId) {
        System.out.println("Kiem tra category");
        List<CartResponse> listResponse = new ArrayList<>();
        UserEntity user = userRepository.findById(userId);
        List<CartEntity> list = cartRepository.findByUserId(user.getId());
        for (CartEntity data : list) {
            CartResponse response = new CartResponse();
            response.setId(data.getId());
            StockEntity stock = data.getStock();
            ProductEntity product = productRepository.findById(stock.getProduct().getId());
            response.setStockId(stock.getId());
            response.setProductName(product.getName());
            response.setStockPrice(stock.getPrice());
            response.setStockImage(stock.getImage());
            response.setQuantity(data.getQuantity());
            listResponse.add(response);
        }
        Gson gson = new Gson();
        String data = gson.toJson(listResponse);
        return listResponse;
    }
/*
    @Override
    public int countCartItems(String email) {
        UserEntity user = userRepository.findByEmail(email);
        List<CartEntity> allCartList = cartRepository.findByUserId(user.getId());
        int totalQuantity =0;
        for(CartEntity cart:allCartList){
            totalQuantity+=cart.getQuantity();
        }
        return allCartList.size();
    }*/

    @Override
    public boolean delete(int cartId) {
        boolean isSuccess = false;
        try {
            CartEntity cart = cartRepository.deleteById(cartId);
            isSuccess = true;
        } catch (Exception e) {
            System.out.println("Lỗi cart delete " + e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public boolean updateCart(int id, int quantity) {
        boolean isSuccess = false;
        try {
            System.out.println(id);
            CartEntity cartEntity = cartRepository.findById(id);
            cartEntity.setQuantity(quantity);
            cartRepository.save(cartEntity);
            isSuccess = true;
        } catch (Exception e) {
            System.out.println("Lỗi addToCart " + e.getMessage());
        }
        return isSuccess;
    }
}