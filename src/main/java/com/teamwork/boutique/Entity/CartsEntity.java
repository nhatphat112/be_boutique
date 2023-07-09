package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

@Entity(name = "carts")
public class CartsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductsEntity productEntity;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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

    public ProductsEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductsEntity productEntity) {
        this.productEntity = productEntity;
    }
}
