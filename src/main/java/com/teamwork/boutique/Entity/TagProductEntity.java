package com.teamwork.boutique.Entity;

import javax.persistence.*;

@Entity(name = "tag_product")
public class TagProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tagEntity;

    public TagEntity getTagEntity() {
        return tagEntity;
    }

    public void setTagEntity(TagEntity tagEntity) {
        this.tagEntity = tagEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
