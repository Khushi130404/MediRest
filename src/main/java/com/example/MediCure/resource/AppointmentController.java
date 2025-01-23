package com.example.MediCure.resource;

import com.example.MediCure.model.Appointment;
import com.example.MediCure.model.UserInfo;
import com.example.MediCure.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/add")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment)
    {
        appointmentRepo.save(appointment);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable("appId") int appId)
    {
        Appointment appointment = appointmentRepo.findByAppId(appId);
        appointmentRepo.deleteByAppId(appId);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }
}
