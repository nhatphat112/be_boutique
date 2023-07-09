package com.teamwork.boutique.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fee")
    private Double fee;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;

    @ManyToOne
    @JoinColumn(name = "city_province_id")
    private CityProvince_Entity cityProvinceEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @OneToMany(mappedBy = "addressEntity")
    private Set<OrdersEntity> orders;

    public Set<OrdersEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrdersEntity> orders) {
        this.orders = orders;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public CityProvince_Entity getCityProvinceEntity() {
        return cityProvinceEntity;
    }

    public void setCityProvinceEntity(CityProvince_Entity cityProvinceEntity) {
        this.cityProvinceEntity = cityProvinceEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }
}
