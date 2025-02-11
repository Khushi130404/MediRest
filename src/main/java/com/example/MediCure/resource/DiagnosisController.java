package com.example.MediCure.resource;

import com.example.MediCure.model.Diagnosis;
import com.example.MediCure.model.Appointment;
import com.example.MediCure.repository.DiagnosisRepo;
import com.example.MediCure.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

    @Autowired
    private DiagnosisRepo diagnosisRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;

    @PostMapping("/insertDiagnosis")
    public ResponseEntity<Diagnosis> addDiagnosis(@RequestParam int appId, @RequestParam byte[] image) {
        Appointment appointment = appointmentRepo.findById(appId).orElse(null);

        Diagnosis diagnosis = new Diagnosis(appointment, image);
        diagnosisRepo.save(diagnosis);

        return new ResponseEntity<>(diagnosis,HttpStatus.OK);
    }
}
