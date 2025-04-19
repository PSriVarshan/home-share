package com.example.home_share.Controller;

import com.example.home_share.Model.RoomsModel;
import com.example.home_share.Model.UserModel;
import com.example.home_share.Service.AdminService;
import com.example.home_share.Service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /* Admin can check whether te user is there are not */
    @GetMapping("/exists/{id}")
    public boolean checkIfUserExists(@PathVariable Integer id) {
        return userService.existingUser(id);
    }

    /* Admin can lst all the users */

    @GetMapping("/listUsers")
    public List<UserModel> getUsersList(@RequestParam String pass) {
        List<UserModel> users = adminService.adminCheckForUsers(pass);
        if (users == null) {
            throw new SecurityException("Unauthorized access. Invalid admin password.");
        }
        return users;
    }

    /* Caan also list all the rooms in the application */

    @GetMapping("/listRooms")
    public List<RoomsModel> getRoomsList(@RequestParam String pass) {
        List<RoomsModel> rooms = adminService.adminCheckForRooms(pass);
        if (rooms == null) {
            throw new SecurityException("Unauthorized access. Invalid admin password.");
        }
        return rooms;
    }

    /* Admin can delete an user and a room */

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        return adminService.deleteUser(userId);
    }

    @DeleteMapping("/deleteRoom/{roomId}")
    public String deleteRoom(@PathVariable Integer roomId) {
        return adminService.deleteRoom(roomId);
    }

    @GetMapping("/showAllBookings")
    public String listAllBookings(@RequestParam String param) {
        return new String();
    }

    @PutMapping("path/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        // TODO: process PUT request

        return entity;
    }

}
