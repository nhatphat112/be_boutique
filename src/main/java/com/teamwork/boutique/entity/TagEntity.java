package com.teamwork.boutique.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "tag")
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "tag")
    private Set<TagProductEntity> tagProducts;

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

    public Set<TagProductEntity> getTagProducts() {
        return tagProducts;
    }

    public void setTagProducts(Set<TagProductEntity> tagProducts) {
        this.tagProducts = tagProducts;
    }
}
