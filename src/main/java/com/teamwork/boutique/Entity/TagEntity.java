package com.teamwork.boutique.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "tag")
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "tagEntity")
    private Set<TagProductEntity> tagProductEntity;

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

    public Set<TagProductEntity> getTagProductEntity() {
        return tagProductEntity;
    }

    public void setTagProductEntity(Set<TagProductEntity> tagProductEntity) {
        this.tagProductEntity = tagProductEntity;
    }
}
