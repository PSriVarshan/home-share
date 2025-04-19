package com.example.home_share.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RoomsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserModel hostId;
    private Integer numberOfGuests;
    private Boolean availabilty = true;
    private String descriptionOfRoom;
    private String title;
    private Double price;
    private Boolean acRoom;
    private Boolean mealsProvided;
    private Boolean attachedRestRooms;
    private Boolean coupleFriendly;
    private Boolean childrenAllowed;
    private Boolean nonVegAllowed;

    public RoomsModel() {
    }

    public RoomsModel(Integer roomId, UserModel hostId, Integer numberOfGuests, Boolean availabilty,
            String descriptionOfRoom, String title, Double price, Boolean acRoom, Boolean mealsProvided,
            Boolean attachedRestRooms, Boolean coupleFriendly, Boolean childrenAllowed, Boolean nonVegAllowed) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.numberOfGuests = numberOfGuests;
        this.availabilty = availabilty;
        this.descriptionOfRoom = descriptionOfRoom;
        this.title = title;
        this.price = price;
        this.acRoom = acRoom;
        this.mealsProvided = mealsProvided;
        this.attachedRestRooms = attachedRestRooms;
        this.coupleFriendly = coupleFriendly;
        this.childrenAllowed = childrenAllowed;
        this.nonVegAllowed = nonVegAllowed;
    }

    public Boolean getAcRoom() {
        return acRoom;
    }

    public void setAcRoom(Boolean acRoom) {
        this.acRoom = acRoom;
    }

    public Boolean getMealsProvided() {
        return mealsProvided;
    }

    public void setMealsProvided(Boolean mealsProvided) {
        this.mealsProvided = mealsProvided;
    }

    public Boolean getAttachedRestRooms() {
        return attachedRestRooms;
    }

    public void setAttachedRestRooms(Boolean attachedRestRooms) {
        this.attachedRestRooms = attachedRestRooms;
    }

    public Boolean getCoupleFriendly() {
        return coupleFriendly;
    }

    public void setCoupleFriendly(Boolean coupleFriendly) {
        this.coupleFriendly = coupleFriendly;
    }

    public Boolean getChildrenAllowed() {
        return childrenAllowed;
    }

    public void setChildrenAllowed(Boolean childrenAllowed) {
        this.childrenAllowed = childrenAllowed;
    }

    public Boolean getNonVegAllowed() {
        return nonVegAllowed;
    }

    public void setNonVegAllowed(Boolean nonVegAllowed) {
        this.nonVegAllowed = nonVegAllowed;
    }

    public RoomsModel(Integer roomId, UserModel hostId, Integer numberOfGuests, Boolean availabilty,
            String descriptionOfRoom, String title, Double pp) {
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
