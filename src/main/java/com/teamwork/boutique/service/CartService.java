package com.teamwork.boutique.service;

import com.google.gson.Gson;
import com.teamwork.boutique.entity.CartEntity;
import com.teamwork.boutique.entity.ProductEntity;
import com.teamwork.boutique.entity.StockEntity;
import com.teamwork.boutique.payload.response.CartResponse;
import com.teamwork.boutique.repository.CartRepository;
import com.teamwork.boutique.repository.ProductRepository;
import com.teamwork.boutique.repository.StockRepository;
import com.teamwork.boutique.repository.UserRepository;
import com.teamwork.boutique.service.imp.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements CartServiceImp {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;;

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addToCart(int productId, int colorId, int quantity) {
        boolean isSuccess = false;
        StockEntity stock = stockRepository.findByProductIdAndColorId(productId, colorId);
//        UserResponse user = null;
//        user.setUsername(SecurityUtils.getPrincipal().getUsername());
//        System.out.println(user.getUsername());
//        System.out.println(stock + " stock is null?" + stock.getId());
        try {
            if (stock != null) {
                System.out.println(stock.getQuantity() + " product Quantity");
                CartEntity cart = cartRepository.findByStockId(stock.getId());
                if (cart == null) {//nếu product chưa tồn tại
                    cart = new CartEntity();
                    System.out.println(cart + " cart is null?");
                    cart.setStock(stock);
                    cart.setQuantity(quantity);
                } else {
                    // cart = new CartEntity();
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
    @Cacheable("listCategory")
    public List<CartResponse> getAllCart() {
        System.out.println("Kiem tra category");
        List<CartResponse> listResponse = new ArrayList<>();
        List<CartEntity> list = cartRepository.findAll();
        for (CartEntity data : list) {
            CartResponse response = new CartResponse();

            response.setId(data.getId());
            StockEntity stock = stockRepository.findById(data.getStock().getId());
            ProductEntity product = productRepository.findById(stock.getProduct().getId());
            response.setStockName(product.getName());
            response.setStockPrice(stock.getPrice());
            response.setQuantity(data.getQuantity());
            listResponse.add(response);
        }
        Gson gson = new Gson();
        String data = gson.toJson(listResponse);
        return listResponse;
    }
}
