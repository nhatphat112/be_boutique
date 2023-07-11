package com.teamwork.boutique.Entity;

import javax.persistence.*;
import java.util.Set;

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
    private ProductEntity productEntity;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorEntity colorEntity;

    public Set<CartEntity> getCarts() {
        return carts;
    }

    public void setCarts(Set<CartEntity> carts) {
        this.carts = carts;
    }

    @Column (name = "image")
    private String image;

    @OneToMany(mappedBy = "stockEntity")
    private Set<CartEntity> carts;
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

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
