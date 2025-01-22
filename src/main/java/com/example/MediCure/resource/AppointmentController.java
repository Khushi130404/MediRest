package com.example.MediCure.resource;

import com.example.MediCure.model.Appointment;
import com.example.MediCure.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController
{
    @Autowired
    AppointmentRepo appointmentRepo;

    @GetMapping(value = "/show")
    public ResponseEntity<List<Appointment>> showAppointment(){
        List<Appointment> list= appointmentRepo.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
