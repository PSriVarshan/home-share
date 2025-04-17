package com.example.home_share.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class RoomsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    @OneToOne
    @JoinColumn(name = "userId")
    private UserModel hostId;
    private Integer numberOfGuests;
    private Boolean availabilty = true;
    private String descriptionOfRoom;
    private String title;
    private Double price;
    public RoomsModel() {
    }
    public RoomsModel(Integer roomId, UserModel hostId, Integer numberOfGuests, Boolean availabilty,
            String descriptionOfRoom, String title,Double pp) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.numberOfGuests = numberOfGuests;
        this.availabilty = availabilty;
        this.descriptionOfRoom = descriptionOfRoom;
        this.title = title;
        this.price = pp;
    }
    public Integer getRoomId() {
        return roomId;
    }
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
    public UserModel getHostId() {
        return hostId;
    }
    public void setHostId(UserModel hostId) {
        this.hostId = hostId;
    }
    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }
    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
    public Boolean getAvailabilty() {
        return availabilty;
    }
    public void setAvailabilty(Boolean availabilty) {
        this.availabilty = availabilty;
    }
    public String getDescriptionOfRoom() {
        return descriptionOfRoom;
    }
    public void setDescriptionOfRoom(String descriptionOfRoom) {
        this.descriptionOfRoom = descriptionOfRoom;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
