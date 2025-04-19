package com.example.home_share.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.home_share.Model.BookingsModel;
import com.example.home_share.Model.RoomsModel;
import com.example.home_share.Model.UserModel;
import com.example.home_share.Repo.BookingsRepo;
import com.example.home_share.Repo.RoomsRepo;
import com.example.home_share.Repo.UserRepo;

@Service
public class AdminService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private BookingsRepo bookRepo;

    @Autowired
    private RoomsRepo roomrep;

    private List<UserModel> usersList() {
        return repo.findAll();
    }

    private List<RoomsModel> roomsList() {
        return roomrep.findAll();
    }

    public List<UserModel> adminCheckForUsers(String passCode) {
        String actPass = "123456789";
        if (!passCode.equals(actPass)) {
            System.out.println("You aint admin");
            return null;
        }
        return usersList();
    }

    public String deleteUser(Integer userId) {
        repo.deleteById(userId);
        return "User Deleted";
    }

    public String deleteRoom(Integer roomId) {
        roomrep.deleteById(roomId);
        return "Room deleted";
    }

    public List<RoomsModel> adminCheckForRooms(String passCode) {
        String actPass = "123456789";
        if (!passCode.equals(actPass)) {
            System.out.println("You aint admin");
            return null;
        }
        return roomsList();
    }

    public List<BookingsModel> listAllBookings() {
        return bookRepo.findAll();
    }
}
