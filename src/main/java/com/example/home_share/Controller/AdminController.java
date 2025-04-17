package com.example.home_share.Controller;

import com.example.home_share.Model.RoomsModel;
import com.example.home_share.Model.UserModel;
import com.example.home_share.Service.AdminService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/listUsers")
    public List<UserModel> getUsersList(@RequestParam String pass) {
        List<UserModel> users = adminService.adminCheckForUsers(pass);
        if (users == null) {
            throw new SecurityException("Unauthorized access. Invalid admin password.");
        }
        return users;
    }

    @GetMapping("/listRooms")
    public List<RoomsModel> getRoomsList(@RequestParam String pass) {
        List<RoomsModel> rooms = adminService.adminCheckForRooms(pass);
        if (rooms == null) {
            throw new SecurityException("Unauthorized access. Invalid admin password.");
        }
        return rooms;
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        return adminService.deleteUser(userId);
    }

    @DeleteMapping("/deleteRoom/{roomId}")
    public String deleteRoom(@PathVariable Integer roomId) {
        return adminService.deleteRoom(roomId);
    }
}
