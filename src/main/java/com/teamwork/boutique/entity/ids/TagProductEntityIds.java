package com.teamwork.boutique.entity.ids;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TagProductEntityIds implements Serializable {

    @Column(name = "product_id")
    private int productId;

    @Column(name = "tag_id")
    private int tagId;

    public TagProductEntityIds() {
    }

    public TagProductEntityIds(int productId, int tagId) {
        this.productId = productId;
        this.tagId = tagId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
