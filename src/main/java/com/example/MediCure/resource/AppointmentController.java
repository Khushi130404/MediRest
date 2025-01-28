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

    @PostMapping(value = "/delete/{appId}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable("appId")String appId)
    {
        Appointment appointment = appointmentRepo.findByAppId(Integer.parseInt(appId));
        appointmentRepo.deleteByAppId(Integer.parseInt(appId));
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }

    @PostMapping(value = "/docApp/{docId}")
    public ResponseEntity<List<Appointment>> getAppointmentOfDoctor(@PathVariable("docId")String docId)
    {
        List<Appointment> list = null;
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
