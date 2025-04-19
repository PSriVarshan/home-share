package com.example.home_share.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.home_share.Model.BookingsModel;
import com.example.home_share.Model.ComplaintsModel;
import com.example.home_share.Model.RoomsModel;
import com.example.home_share.Repo.BookingsRepo;
import com.example.home_share.Repo.ComplaintsRepo;

@Service
public class ComplaintsService {
    @Autowired
    private BookingsRepo repo;

    @Autowired
    private ComplaintsRepo compRepo;

    private boolean allowedToComplain(Integer roomId, Integer userId) {
        List<BookingsModel> bookings = repo.myBookings(userId);
        for (BookingsModel books : bookings) {
            RoomsModel room = books.getRoomId();
            if (room.getRoomId() == roomId)
                return true;
        }
        return false;
    }

    public String addComplaint(Integer userId, Integer roomId, ComplaintsModel complain) {
        if (allowedToComplain(roomId, userId)) {
            compRepo.save(complain);
            return "Complaint mentioned ! We will contact you soon";
        }
        return "";
    }
}
