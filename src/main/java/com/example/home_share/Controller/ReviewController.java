package com.example.home_share.Controller;

import com.example.home_share.Model.ReviewsModel;
import com.example.home_share.Service.ReviewService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add")
    public String addReview(@RequestBody ReviewsModel rev) {
        return reviewService.addReview(rev);
    }
}