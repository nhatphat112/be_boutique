package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity statusEntity;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "phone_id")
    private PhonesEntity phonesEntity;

    @OneToMany(mappedBy = "ordersEntity")
    private Set<Order_Details_Entity> order_Details_Entity;

    public Set<Order_Details_Entity> getOrder_Details_Entity() {
        return order_Details_Entity;
    }

    public void setOrder_Details_Entity(Set<Order_Details_Entity> order_Details_Entity) {
        this.order_Details_Entity = order_Details_Entity;
    }

    public PhonesEntity getPhonesEntity() {
        return phonesEntity;
    }

    public void setPhonesEntity(PhonesEntity phonesEntity) {
        this.phonesEntity = phonesEntity;
    }



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

    public StatusEntity getStatusEntity() {
        return statusEntity;
    }

    public void setStatusEntity(StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}
