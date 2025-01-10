package com.example.MediCure.repository;

import com.example.MediCure.model.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<DoctorInfo,Integer>
{
    public DoctorInfo findByDoctorMailAndDoctorPass(String mail, String pass);
}
