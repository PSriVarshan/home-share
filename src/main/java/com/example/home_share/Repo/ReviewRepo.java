package com.example.home_share.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.home_share.Model.ReviewsModel;
import com.example.home_share.Model.RoomsModel;

@Repository
public interface ReviewRepo extends JpaRepository<ReviewsModel, Integer> {
    public List<ReviewsModel> findAllByRoomId(RoomsModel Id);
}
