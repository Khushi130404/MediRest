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
@CrossOrigin(origins = "http://localhost:3000")
public class DiagnosisController {

    @Autowired
    private DiagnosisRepo diagnosisRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;

    @PostMapping("/addDiagnos/{appId}")
    public ResponseEntity<?> addDiagnosis(@PathVariable int appId, @RequestParam("image") MultipartFile file) {
        try {
            Appointment appointment = appointmentRepo.findById(appId).orElse(null);
            if (appointment == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found");
            }

            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
            }

            byte[] imageBytes = file.getBytes();
            Diagnosis diagnosis = new Diagnosis(appointment, imageBytes);
            diagnosisRepo.save(diagnosis);

            return ResponseEntity.ok().body("Diagnosis added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing file: " + e.getMessage());
        }
    }

    @GetMapping("/getDiagnosis/{appId}")
    public ResponseEntity<?> getDiagnosis(@PathVariable int appId) {
        Diagnosis diagnosis = diagnosisRepo.findByAppointment_AppId(appId);

        if (diagnosis == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No diagnosis found for this appointment");
        }

        String base64Image = Base64.getEncoder().encodeToString(diagnosis.getImage());
        return ResponseEntity.ok().body(base64Image);
    }
}