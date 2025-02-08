package com.example.MediCure.resource;

import com.example.MediCure.model.Appointment;
import com.example.MediCure.model.UserInfo;
import com.example.MediCure.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        List<Appointment> list = appointmentRepo.findByDocId(Integer.parseInt(docId));
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping(value = "/futureDocApp/{docId}")
    public ResponseEntity<List<Appointment>> getFutureAppointmentByDocId(@PathVariable("docId")String docId)
    {
        LocalDate curDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDate = curDate.format(formatter);
        System.out.println(curDate);
        List<Appointment> list = appointmentRepo.getFutureAppointmentByDocId(Integer.parseInt(docId),currentDate);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping(value = "/pastDocApp/{docId}")
    public ResponseEntity<List<Appointment>> getPastAppointmentByDocId(@PathVariable("docId")String docId)
    {
        LocalDate curDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDate = curDate.format(formatter);
        System.out.println(curDate);
        List<Appointment> list = appointmentRepo.getPastAppointmentByDocId(Integer.parseInt(docId),currentDate);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping(value = "/allPastDocApp/{docId}")
    public ResponseEntity<List<Appointment>> getAllPastAppointmentByDocId(@PathVariable("docId")String docId)
    {
        LocalDate curDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDate = curDate.format(formatter);
        System.out.println(curDate);
        List<Appointment> list = appointmentRepo.getAllPastAppointmentByDocId(Integer.parseInt(docId),currentDate);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
