package com.example.MediCure.repository;

import com.example.MediCure.model.DoctorInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepo extends JpaRepository<DoctorInfo,Integer>
{
    public DoctorInfo findByDoctorMailAndDoctorPass(String mail, String pass);

    @Transactional
    @Modifying
    @Query("update UserInfo ui set ui.userName = :name, ui.userMail = :mail, ui.userAge = :age, ui.userMobile = :mobile, ui.userAddress = :address, ui.userGender = :gender where ui.userId = :userId")
    public void updateUser(String mail,String pass,String name,int age,String mobile);

}
