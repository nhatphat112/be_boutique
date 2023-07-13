package com.teamwork.boutique.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<AddressEntity> addresses;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<OrderEntity> orders;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<PhoneEntity> phones;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<CartEntity> carts;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<ReviewEntity> reviews;

    public Set<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public Set<CartEntity> getCarts() {
        return carts;
    }

    public void setCarts(Set<CartEntity> carts) {
        this.carts = carts;
    }

    public Set<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneEntity> phones) {
        this.phones = phones;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
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

    public String getSubscribePromotion() {
        return subscribePromotion;
    }

    public void setSubscribePromotion(String subscribePromotion) {
        this.subscribePromotion = subscribePromotion;
    }

    public Set<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressEntity> addresses) {
        this.addresses = addresses;
    }

}
