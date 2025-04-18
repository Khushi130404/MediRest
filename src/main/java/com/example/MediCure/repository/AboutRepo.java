package com.example.MediCure.repository;

import com.example.MediCure.model.AboutInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AboutRepo extends JpaRepository<AboutInfo, Integer>
{
    AboutInfo findByDoctorInfo_DoctorId(int doctorId);

    @Modifying
    @Transactional
    @Query("UPDATE AboutInfo a SET a.about = :aboutText WHERE a.doctorInfo.doctorId = :doctorId")
    int updateAboutByDoctorId(int doctorId, String aboutText);
}
