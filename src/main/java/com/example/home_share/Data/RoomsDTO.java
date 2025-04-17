package com.example.home_share.Data;

import java.util.List;

import com.example.home_share.Model.ReviewsModel;
import com.example.home_share.Model.RoomsModel;
import com.example.home_share.Model.Custom.RoomFeatures;

public class RoomsDTO {
    private RoomsModel room;
    private RoomFeatures features;
    private List<ReviewsModel> reviews;

    public RoomsDTO(RoomsModel room, RoomFeatures features, List<ReviewsModel> reviews) {
        this.room = room;
        this.features = features;
        this.reviews = reviews;
    }

    public RoomsModel getRoom() {
        return room;
    }

    public void setRoom(RoomsModel room) {
        this.room = room;
    }

    public RoomFeatures getFeatures() {
        return features;
    }

    public void setFeatures(RoomFeatures features) {
        this.features = features;
    }

    public List<ReviewsModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewsModel> reviews) {
        this.reviews = reviews;
    }

}
