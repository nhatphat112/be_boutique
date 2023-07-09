package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "subscribe_promotion")
    private String subscribe_promotion;

    @OneToMany(mappedBy = "userEntity")
    private Set<AddressEntity> address;

    @OneToMany(mappedBy = "userEntity")
    private Set<OrdersEntity> orders;
    @OneToMany(mappedBy = "userEntity")
    private Set<PhonesEntity> phonesEntity;
    @OneToMany(mappedBy = "userEntity")
    private Set<CartsEntity> cartsEntity;
    @OneToMany(mappedBy = "userEntity")
    private Set<ReviewsEntity> reviewsEntity;

    public Set<ReviewsEntity> getReviewsEntity() {
        return reviewsEntity;
    }

    public void setReviewsEntity(Set<ReviewsEntity> reviewsEntity) {
        this.reviewsEntity = reviewsEntity;
    }

    public Set<CartsEntity> getCartsEntity() {
        return cartsEntity;
    }

    public void setCartsEntity(Set<CartsEntity> cartsEntity) {
        this.cartsEntity = cartsEntity;
    }

    public Set<PhonesEntity> getPhonesEntity() {
        return phonesEntity;
    }

    public void setPhonesEntity(Set<PhonesEntity> phonesEntity) {
        this.phonesEntity = phonesEntity;
    }

    public Set<OrdersEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrdersEntity> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubscribe_promotion() {
        return subscribe_promotion;
    }

    public void setSubscribe_promotion(String subscribe_promotion) {
        this.subscribe_promotion = subscribe_promotion;
    }

    public Set<AddressEntity> getAddress() {
        return address;
    }

    public void setAddress(Set<AddressEntity> address) {
        this.address = address;
    }
}
