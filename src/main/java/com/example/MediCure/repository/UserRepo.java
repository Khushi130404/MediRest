package com.example.MediCure.repository;

import com.example.MediCure.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserInfo,Integer>
{
    public UserInfo findByUserMailAndUserPass(String mail,String pass);
}
