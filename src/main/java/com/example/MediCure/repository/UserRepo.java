package com.example.MediCure.repository;

import com.example.MediCure.model.UserInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserInfo,Integer>
{
    public UserInfo findByUserId(int userId);

    public UserInfo findByUserMailAndUserPass(String mail,String pass);

    public UserInfo findByUserMail(String mail);

    @Transactional
    @Modifying
    @Query("update UserInfo ui set ui.userName = :name, ui.userMail = :mail, ui.userAge = :age, ui.userMobile = :mobile, ui.userAddress = :address, ui.userGender = :gender where ui.userId = :userId")
    public void updateUser(int userId, String name,String mail,int age,String mobile, String address, String gender);
}
