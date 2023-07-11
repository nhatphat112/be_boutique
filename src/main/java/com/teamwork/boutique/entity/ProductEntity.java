package com.teamwork.boutique.entity;

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

    @Column(name = "description")
    private String desc;

    @OneToMany(mappedBy = "product")
    private Set<ReviewEntity> reviews;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "product")
    private Set<TagProductEntity> tagProducts;
    @OneToMany(mappedBy = "product")
    private Set<StockEntity> stocks;
    public Set<TagProductEntity> getTagProducts() {
        return tagProducts;
    }

    public void setTagProducts(Set<TagProductEntity> tagProducts) {
        this.tagProducts = tagProducts;
    }

    public Set<StockEntity> getStocks() {
        return stocks;
    }

    public void setStocks(Set<StockEntity> stocks) {
        this.stocks = stocks;
    }



    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Set<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewEntity> reviews) {
        this.reviews = reviews;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
