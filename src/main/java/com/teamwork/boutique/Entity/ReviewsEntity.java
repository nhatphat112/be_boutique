package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

@Entity(name = "reviews")
public class ReviewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content")
    private String content;
    @Column(name = "appriciation")
    private int appriciation;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public ProductsEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductsEntity productEntity) {
        this.productEntity = productEntity;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductsEntity productEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAppriciation() {
        return appriciation;
    }

    public void setAppriciation(int appriciation) {
        this.appriciation = appriciation;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
