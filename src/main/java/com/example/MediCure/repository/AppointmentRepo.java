package com.example.MediCure.repository;

import com.example.MediCure.model.Appointment;
import com.example.MediCure.model.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo  extends JpaRepository<Appointment,Integer> {

}
