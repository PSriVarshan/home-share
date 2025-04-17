package com.example.home_share.Controller;

import com.example.home_share.Model.UserModel;
import com.example.home_share.Service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Integer id) {
        return userService.findUserbyId(id);
    }

    @GetMapping("/exists/{id}")
    public boolean checkIfUserExists(@PathVariable Integer id) {
        return userService.existingUser(id);
    }
}