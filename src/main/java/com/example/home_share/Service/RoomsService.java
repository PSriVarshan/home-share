package com.example.home_share.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.home_share.Data.RoomsDTO;
import com.example.home_share.Model.ReviewsModel;
import com.example.home_share.Model.RoomsModel;
import com.example.home_share.Repo.ReviewRepo;
import com.example.home_share.Repo.RoomsRepo;

@Service
public class RoomsService {
    @Autowired
    private RoomsRepo roomRepo;

    public RoomsModel addRoom(RoomsModel room) {
        return roomRepo.save(room);
    }

    public RoomsModel findRoomById(Integer id) {
        return roomRepo.findById(id).orElse(null);
    }

    public List<RoomsModel> theRoomsInTheCity(String city) {
        return roomRepo.listRooms(city);
    }

    public int updateRoomAvl(Integer roomId, Boolean avl) {
        return roomRepo.updateAvl(avl, roomId);
    }

    @Autowired
    private ReviewRepo reviewsRepo;

    public RoomsDTO getFullRoomDetails(Integer roomId) {
        RoomsModel room = roomRepo.findById(roomId).orElseThrow();
        List<ReviewsModel> reviews = reviewsRepo.findAllByRoomId(room); // create this too

        return new RoomsDTO(room, reviews);
    }

}
