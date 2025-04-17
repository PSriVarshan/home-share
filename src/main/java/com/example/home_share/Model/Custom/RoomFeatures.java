package com.example.home_share.Model.Custom;

import com.example.home_share.Model.RoomsModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class RoomFeatures {
    @Id
    private Integer featureId;
    @OneToOne
    @JoinColumn(name = "roomId")
    private RoomsModel roomId;
    private Boolean acRoom;
    private Boolean mealsProvided;
    private Boolean attachedRestRooms;
    private Boolean coupleFriendly;
    private Boolean childrenAllowed;
    private Boolean nonVegAllowed;
    
    public RoomFeatures() {
    }
    public RoomFeatures(Integer featureId, RoomsModel roomId, Boolean acRoom, Boolean mealsProvided,
            Boolean attachedRestRooms, Boolean coupleFriendly, Boolean childrenAllowed, Boolean nonVegAllowed) {
        this.featureId = featureId;
        this.roomId = roomId;
        this.acRoom = acRoom;
        this.mealsProvided = mealsProvided;
        this.attachedRestRooms = attachedRestRooms;
        this.coupleFriendly = coupleFriendly;
        this.childrenAllowed = childrenAllowed;
        this.nonVegAllowed = nonVegAllowed;
    }
    public Integer getFeatureId() {
        return featureId;
    }
    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }
    public RoomsModel getRoomId() {
        return roomId;
    }
    public void setRoomId(RoomsModel roomId) {
        this.roomId = roomId;
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
    
}
