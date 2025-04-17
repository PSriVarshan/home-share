package com.example.home_share.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ReviewsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    @ManyToOne
    @JoinColumn(name = "roomId")
    private RoomsModel roomId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserModel reviewerId;
    private Integer stars;
    private String review;

    public ReviewsModel(RoomsModel roomId, UserModel reviewerId, Integer stars, String review) {
        this.roomId = roomId;
        this.reviewerId = reviewerId;
        this.stars = stars;
        this.review = review;
    }

}
