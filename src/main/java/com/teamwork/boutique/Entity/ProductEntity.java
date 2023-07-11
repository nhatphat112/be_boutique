package com.teamwork.boutique.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "image_list")
    private String imageList;
    @Column(name = "sold_quantity")
    private String soldQuantity;

    @OneToMany(mappedBy = "productEntity")
    private Set<OrderDetailEntity> orderDetailEntity;

    @OneToMany(mappedBy = "productEntity")
    private Set<ReviewEntity> reviewEntity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity")
    private Set<TagProductEntity> tagProductEntity;
    @OneToMany(mappedBy = "productEntity")
    private Set<StockEntity> stockEntity;
    public Set<TagProductEntity> getTagProductEntity() {
        return tagProductEntity;
    }

    public void setTagProductEntity(Set<TagProductEntity> tagProductEntity) {
        this.tagProductEntity = tagProductEntity;
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

    public Set<ReviewEntity> getReviewEntity() {
        return reviewEntity;
    }

    public void setReviewEntity(Set<ReviewEntity> reviewEntity) {
        this.reviewEntity = reviewEntity;
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

    public String getImageList() {
        return imageList;
    }

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }

    public String getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(String soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Set<OrderDetailEntity> getOrderDetailEntity() {
        return orderDetailEntity;
    }

    public void setOrderDetailEntity(Set<OrderDetailEntity> orderDetailEntity) {
        this.orderDetailEntity = orderDetailEntity;
    }
}
