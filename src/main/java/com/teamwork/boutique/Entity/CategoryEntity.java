package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "categoryEntity")
    private Set<ProductsEntity> productsEntity;

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

    public Set<ProductsEntity> getProductsEntity() {
        return productsEntity;
    }

    public void setProductsEntity(Set<ProductsEntity> productsEntity) {
        this.productsEntity = productsEntity;
    }
}
