package com.teamwork.boutique.payload.response;

public class ProductResponse {
    private int id;
    private String name;
    private String image_list;
    private String image;

    private String sold_quantity;
    private String description;

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

    public String getImage_list() {
        return image_list;
    }

    public void setImage_list(String image_list) {
        this.image_list = image_list;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(String sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
