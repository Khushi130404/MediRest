package com.example.MediCure.resource;

import com.example.MediCure.model.DoctorInfo;
import com.example.MediCure.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/get_doctor/{docId}")
    public ResponseEntity<DoctorInfo> getDoctorById (@PathVariable("docId")String docId)
    {
        DoctorInfo doctorInfo = doctorRepo.findByDoctorId(Integer.parseInt(docId));
        return new ResponseEntity<>(doctorInfo,HttpStatus.OK);
    }

    @GetMapping("/show_doctor")
    public ResponseEntity<List<DoctorInfo>> showDoctor()
    {
        List<DoctorInfo> list = doctorRepo.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/update_doctor")
    public ResponseEntity<?> updateDoctor(@RequestBody DoctorInfo updatedDoc) {
        if (updatedDoc == null) {
            return new ResponseEntity<>("Invalid user data", HttpStatus.BAD_REQUEST);
        }

        DoctorInfo existingDoc = doctorRepo.findByDoctorId(updatedDoc.getDoctorId());
        if (existingDoc == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        doctorRepo.updateDoctor(
                updatedDoc.getDoctorId(),
                updatedDoc.getDoctorName(),
                updatedDoc.getDoctorMail(),
                updatedDoc.getDoctorAge(),
                updatedDoc.getDoctorMobile(),
                updatedDoc.getDoctorAddress(),
                updatedDoc.getDoctorGender(),
                updatedDoc.getSpecialist()
        );
        DoctorInfo latestUser = doctorRepo.findByDoctorId(updatedDoc.getDoctorId());
        return new ResponseEntity<>(latestUser, HttpStatus.OK);
    }
}
