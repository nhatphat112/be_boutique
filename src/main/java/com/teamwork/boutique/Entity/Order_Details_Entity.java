package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

@Entity(name = "order_details")
public class Order_Details_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrdersEntity ordersEntity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductsEntity productEntity;

    public ProductsEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductsEntity productEntity) {
        this.productEntity = productEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrdersEntity getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }
}
