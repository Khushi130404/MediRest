package com.example.MediCure.repository;

import com.example.MediCure.model.AboutInfo;
import com.example.MediCure.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepo extends JpaRepository<AboutInfo, Integer>
{
    AboutInfo findByDoctorInfo_DoctorId(int doctorId);
}
