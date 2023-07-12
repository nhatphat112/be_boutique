package com.teamwork.boutique.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamwork.boutique.entity.StockEntity;

public class CartResponse {
    private int id;
    @JsonIgnore
    private StockEntity stock;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StockEntity getStock() {
        return stock;
    }

    public void setStock(StockEntity stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
