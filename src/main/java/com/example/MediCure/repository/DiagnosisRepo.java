package com.example.MediCure.repository;

import com.example.MediCure.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepo extends JpaRepository<Diagnosis, Integer> {
    Diagnosis findByAppointment_AppId(int appId);
}