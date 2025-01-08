package com.example.MediCure.repository;

import com.example.MediCure.model.User_Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User_Info,Integer> {
}
