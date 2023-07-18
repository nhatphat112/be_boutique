package com.teamwork.boutique.payload.response;

public class OrderDetailResponse {
    private int productId;
    private String productName;
    private String ProductImage;
    private double productPrices;
    private double prices;
    private int quantity;
   private String colorName;
   private int stockId;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public double getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(double productPrices) {
        this.productPrices = productPrices;
    }


    public OrderDetailResponse() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String productImage) {
        ProductImage = productImage;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
