package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "products")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "image_list")
    private String image_list;
    @Column(name = "sold_quantity")
    private String sold_quantity;

    @OneToMany(mappedBy = "productEntity")
    private Set<Order_Details_Entity> order_Details_Entity;
    @OneToMany(mappedBy = "productEntity")
    private Set<CartsEntity> cartsEntity;

    @OneToMany(mappedBy = "productEntity")
    private Set<ReviewsEntity> reviewsEntity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity")
    private Set<TagProducts_Entity> tagProducts_Entity;
    @OneToMany(mappedBy = "productEntity")
    private Set<StockEntity> stockEntity;
    public Set<TagProducts_Entity> getTagProducts_Entity() {
        return tagProducts_Entity;
    }

    public void setTagProducts_Entity(Set<TagProducts_Entity> tagProducts_Entity) {
        this.tagProducts_Entity = tagProducts_Entity;
    }

    public Set<StockEntity> getStockEntity() {
        return stockEntity;
    }

    public void setStockEntity(Set<StockEntity> stockEntity) {
        this.stockEntity = stockEntity;
    }



    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_list() {
        return image_list;
    }

    public void setImage_list(String image_list) {
        this.image_list = image_list;
    }

    public String getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(String sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public Set<Order_Details_Entity> getOrder_Details_Entity() {
        return order_Details_Entity;
    }

    public void setOrder_Details_Entity(Set<Order_Details_Entity> order_Details_Entity) {
        this.order_Details_Entity = order_Details_Entity;
    }
}
