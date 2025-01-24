package com.example.MediCure.repository;

import com.example.MediCure.model.DoctorInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepo extends JpaRepository<DoctorInfo,Integer>
{
    public DoctorInfo findByDoctorMailAndDoctorPass(String mail, String pass);

    public DoctorInfo findByDoctorId(int docId);
}
