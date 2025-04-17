package com.example.home_share.Model.Custom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hNo;
    private String add1;
    private String add2;
    private String city;
    private String state;
    private Integer zipCode;
    
    public Location() {
    }
    public Location(String hNo, String add1, String add2, String city, String state, Integer zipCode) {
        this.hNo = hNo;
        this.add1 = add1;
        this.add2 = add2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Location(String hNo, String add1, String city, String state, Integer zipCode) {
        this.hNo = hNo;
        this.add1 = add1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    public String gethNo() {
        return hNo;
    }
    public void sethNo(String hNo) {
        this.hNo = hNo;
    }
    public String getAdd1() {
        return add1;
    }
    public void setAdd1(String add1) {
        this.add1 = add1;
    }
    public String getAdd2() {
        return add2;
    }
    public void setAdd2(String add2) {
        this.add2 = add2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Integer getZipCode() {
        return zipCode;
    }
    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
}
