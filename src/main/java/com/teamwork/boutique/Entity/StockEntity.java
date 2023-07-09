package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

@Entity(name = "stock")
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductsEntity productEntity;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorEntity colorEntity;
    public ColorEntity getColorEntity() {
        return colorEntity;
    }

    public void setColorEntity(ColorEntity colorEntity) {
        this.colorEntity = colorEntity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductsEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductsEntity productEntity) {
        this.productEntity = productEntity;
    }
}
