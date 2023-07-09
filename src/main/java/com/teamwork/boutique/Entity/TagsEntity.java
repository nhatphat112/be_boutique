package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "tags")
public class TagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "tagsEntity")
    private Set<TagProducts_Entity> tagProducts_Entity;

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

    public Set<TagProducts_Entity> getTagProducts_Entity() {
        return tagProducts_Entity;
    }

    public void setTagProducts_Entity(Set<TagProducts_Entity> tagProducts_Entity) {
        this.tagProducts_Entity = tagProducts_Entity;
    }
}
