package com.example.home_share.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.home_share.Model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {
    
}
