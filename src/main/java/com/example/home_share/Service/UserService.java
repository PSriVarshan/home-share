package com.example.home_share.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.home_share.Model.UserModel;
import com.example.home_share.Repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserModel createUser(UserModel user) {
        return userRepo.save(user);
    }

    public UserModel findUserbyId(Integer userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public boolean existingUser(Integer userId) {
        if (findUserbyId(userId) != null) {
            return true;
        }
        return false;
    }
}
