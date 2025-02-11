package com.example.MediCure.resource;

import org.springframework.web.multipart.MultipartFile;
import com.example.MediCure.model.Diagnosis;
import com.example.MediCure.model.Appointment;
import com.example.MediCure.repository.DiagnosisRepo;
import com.example.MediCure.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Base64;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

    @Autowired
    private DiagnosisRepo diagnosisRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;

    @PostMapping("/addDiagnos/{appId}")
    public ResponseEntity<?> addDiagnosis(@PathVariable int appId, @RequestParam("image") MultipartFile file)
    {
        Appointment appointment = appointmentRepo.findById(appId).orElse(null);
        if (appointment == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found");
        }
        try {
            byte[] imageBytes = file.getBytes();
            Diagnosis diagnosis = new Diagnosis(appointment, imageBytes);
            diagnosisRepo.save(diagnosis);
            return ResponseEntity.ok(diagnosis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing file");
        }
    }
//    @PostMapping("/addDiagnos/{appId}/{image}")
//    public ResponseEntity<Diagnosis> addDiagnosis(@RequestParam int appId, @RequestParam String imgStr)
//    {
//        Appointment appointment = appointmentRepo.findById(appId).orElse(null);
//        if (appointment == null)
//        {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        try
//        {
//            byte[] image = Base64.getDecoder().decode(imgStr);
//            Diagnosis diagnosis = new Diagnosis(appointment, image);
//            diagnosisRepo.save(diagnosis);
//            return new ResponseEntity<>(diagnosis, HttpStatus.OK);
//        }
//        catch (IllegalArgumentException e)
//        {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//    }
}
