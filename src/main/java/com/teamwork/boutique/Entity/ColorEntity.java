package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "colors")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "colorEntity")
    private Set<StockEntity> stockEntity;

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

    public Set<StockEntity> getStockEntity() {
        return stockEntity;
    }

    public void setStockEntity(Set<StockEntity> stockEntity) {
        this.stockEntity = stockEntity;
    }
}
