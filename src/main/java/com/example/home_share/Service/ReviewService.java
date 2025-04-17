package com.example.home_share.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.home_share.Model.BookingsModel;
import com.example.home_share.Model.ReviewsModel;
import com.example.home_share.Model.RoomsModel;
import com.example.home_share.Model.UserModel;
import com.example.home_share.Repo.BookingsRepo;
import com.example.home_share.Repo.ReviewRepo;

@Service
public class ReviewService {
    @Autowired
    private BookingsRepo repo;

    @Autowired
    private ReviewRepo reviewRepo;

    private boolean allowedToReview(Integer roomId, Integer userId) {
        List<BookingsModel> bookings = repo.myBookings(userId);
        for (BookingsModel books : bookings) {
            RoomsModel room = books.getRoomId();
            if (room.getRoomId() == roomId)
                return true;
        }
        return false;
    }

    public String addReview(ReviewsModel review) {
        UserModel user = review.getReviewerId();
        Integer userId = user.getUserId();

        RoomsModel room = review.getRoomId();

        Integer roomId = room.getRoomId();

        System.out.println("yuio");
        if (userId == null || roomId == null)
            return "Missing userId or roomId";
        if (allowedToReview(roomId, userId)) {
            reviewRepo.save(review);
            return "Review posted";
        }
        return "You don't deserve to be a reviewer";
    }
}
