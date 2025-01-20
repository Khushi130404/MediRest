package com.example.MediCure.resource;

import com.example.MediCure.model.DoctorInfo;
import com.example.MediCure.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/doctor")
public class DoctorController
{
    @Autowired
    DoctorRepo doctorRepo;

    @PostMapping("/login_doctor/{mail}/{pass}")
    public ResponseEntity<DoctorInfo> loginDoctor(@PathVariable("mail")String mail, @PathVariable("pass")String pass)
    {
        DoctorInfo doctor = doctorRepo.findByDoctorMailAndDoctorPass(mail, pass);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }
}
