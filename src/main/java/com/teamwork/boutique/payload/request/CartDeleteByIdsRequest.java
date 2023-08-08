package com.teamwork.boutique.payload.request;

import java.util.HashSet;
import java.util.Set;

public class CartDeleteByIdsRequest {
    private int cartId;

    public CartDeleteByIdsRequest() {
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
