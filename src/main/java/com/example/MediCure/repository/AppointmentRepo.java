package com.example.MediCure.repository;

import com.example.MediCure.model.Appointment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AppointmentRepo  extends JpaRepository<Appointment,Integer> {

    public Appointment findByAppId(int appId);

    @Transactional
    @Modifying
    @Query("delete from Appointment ap where ap.appId =:appId")
    public void deleteByAppId(int appId);

    public List<Appointment> findByDocId(int docId);
}
