package com.example.home_share.Model;


import java.sql.Time;

import org.hibernate.annotations.CreationTimestamp;

import com.example.home_share.Model.Custom.Location;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String email;
    private String password;
    @Column(unique = true)
    private String phNo;
    @CreationTimestamp
    private Time createdTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location address;
    
    public UserModel() {
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhNo() {
        return phNo;
    }
    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }
    public Time getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Time createdTime) {
        this.createdTime = createdTime;
    }
    public Location getAddress() {
        return address;
    }
    public void setAddress(Location address) {
        this.address = address;
    }
    
}
