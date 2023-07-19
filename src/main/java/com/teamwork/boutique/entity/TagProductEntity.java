package com.teamwork.boutique.entity;

import com.teamwork.boutique.entity.ids.TagProductEntityIds;

import javax.persistence.*;

@Entity(name = "tag_product")
public class TagProductEntity {
    @EmbeddedId
    private TagProductEntityIds ids;
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "tag_id", insertable = false, updatable = false)
    private TagEntity tag;

    public TagEntity getTag() {
        return tag;
    }

    public void setTag(TagEntity tag) {
        this.tag = tag;
    }

    public TagProductEntityIds getIds() {
        return ids;
    }

    public void setIds(TagProductEntityIds ids) {
        this.ids = ids;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
