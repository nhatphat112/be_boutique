package com.teamwork.boutique.service;

import com.teamwork.boutique.entity.CartEntity;
import com.teamwork.boutique.entity.StockEntity;
import com.teamwork.boutique.entity.UserEntity;
import com.teamwork.boutique.repository.CartRepository;
import com.teamwork.boutique.repository.StockRepository;
import com.teamwork.boutique.repository.UserRepository;
import com.teamwork.boutique.service.imp.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements CartServiceImp {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean addToCart(int productId, int colorId, int quantity) {
        boolean isSuccess = false;
        StockEntity stock = stockRepository.findByProductAndColor(productId,colorId);
        String username = "nguyenvana";//JwtRequestFilter.CURRENT_USER;
        UserEntity user = null;
        if(username!=null){
            user = userRepository.findByUsername(username);
        }
        try {
            if(stock!=null&&user!=null){
                System.out.println(stock.getQuantity()+ " product Quantity");
                CartEntity cart = cartRepository.findByStockAndUser(stock.getId(), user.getId());
                if(cart==null){//nếu product chưa tồn tại
                    cart.setStock(stock);
                    cart.setQuantity(quantity);
                }
                else{
                    cart.setQuantity(cart.getQuantity()+quantity);
                }

                cartRepository.save(cart);
                return isSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi addToCart " + e.getMessage());
        }
        return isSuccess;
    }
}
