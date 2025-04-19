package com.example.home_share.Data;

import java.util.List;

import com.example.home_share.Model.ReviewsModel;
import com.example.home_share.Model.RoomsModel;

public class RoomsDTO {
    private RoomsModel room;
    private List<ReviewsModel> reviews;

    public RoomsDTO(RoomsModel room, List<ReviewsModel> reviews) {
        this.room = room;
        this.reviews = reviews;
    }

    public RoomsModel getRoom() {
        return room;
    }

    public void setRoom(RoomsModel room) {
        this.room = room;
    }

    public List<ReviewsModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewsModel> reviews) {
        this.reviews = reviews;
    }
}
