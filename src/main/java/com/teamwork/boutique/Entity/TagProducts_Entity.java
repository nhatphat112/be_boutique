package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

@Entity(name = "tag_product")
public class TagProducts_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductsEntity productEntity;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagsEntity tagsEntity;

    public TagsEntity getTagsEntity() {
        return tagsEntity;
    }

    public void setTagsEntity(TagsEntity tagsEntity) {
        this.tagsEntity = tagsEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public ProductsEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductsEntity productEntity) {
        this.productEntity = productEntity;
    }
}
