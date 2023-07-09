package com.teamwork.boutique.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="city_province")
public class CityProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")

    private String name;

    @OneToMany(mappedBy = "cityProvinceEntity")
    private Set<AddressEntity> address;

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

    public Set<AddressEntity> getAddress() {
        return address;
    }

    public void setAddress(Set<AddressEntity> address) {
        this.address = address;
    }
}
