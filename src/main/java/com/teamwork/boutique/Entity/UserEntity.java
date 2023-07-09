package com.teamwork.boutique.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
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
    private String subscribePromotion;

    @OneToMany(mappedBy = "userEntity")
    private Set<AddressEntity> address;

    @OneToMany(mappedBy = "userEntity")
    private Set<OrderEntity> order;
    @OneToMany(mappedBy = "userEntity")
    private Set<PhoneEntity> phoneEntity;
    @OneToMany(mappedBy = "userEntity")
    private Set<CartEntity> cartEntity;
    @OneToMany(mappedBy = "userEntity")
    private Set<ReviewEntity> reviewEntity;

    public Set<ReviewEntity> getReviewEntity() {
        return reviewEntity;
    }

    public void setReviewEntity(Set<ReviewEntity> reviewEntity) {
        this.reviewEntity = reviewEntity;
    }

    public Set<CartEntity> getCartEntity() {
        return cartEntity;
    }

    public void setCartEntity(Set<CartEntity> cartEntity) {
        this.cartEntity = cartEntity;
    }

    public Set<PhoneEntity> getPhoneEntity() {
        return phoneEntity;
    }

    public void setPhoneEntity(Set<PhoneEntity> phoneEntity) {
        this.phoneEntity = phoneEntity;
    }

    public Set<OrderEntity> getOrder() {
        return order;
    }

    public void setOrder(Set<OrderEntity> order) {
        this.order = order;
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

    public String getSubscribePromotion() {
        return subscribePromotion;
    }

    public void setSubscribePromotion(String subscribePromotion) {
        this.subscribePromotion = subscribePromotion;
    }

    public Set<AddressEntity> getAddress() {
        return address;
    }

    public void setAddress(Set<AddressEntity> address) {
        this.address = address;
    }
}
