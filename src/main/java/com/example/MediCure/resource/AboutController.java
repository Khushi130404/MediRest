package com.example.MediCure.resource;

import com.example.MediCure.model.AboutInfo;
import com.example.MediCure.model.DoctorInfo;
import com.example.MediCure.repository.AboutRepo;
import com.example.MediCure.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/about")
public class AboutController
{
    @Autowired
    AboutRepo aboutRepo;

    @Autowired
    DoctorRepo doctorRepo;

    @PostMapping(value = "/aboutDoc/{doctorId}")
    public ResponseEntity<AboutInfo> getAboutInfoByDoctorId(@PathVariable("doctorId")String doctorId)
    {
        AboutInfo aboutInfo = aboutRepo.findByDoctorInfo_DoctorId(Integer.parseInt(doctorId));
        if (aboutInfo != null) {
            return new ResponseEntity<>(aboutInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addAbout")
    public ResponseEntity<?> addAboutInfo(@RequestParam int doctorId, @RequestParam String about)
    {
        DoctorInfo doctor = doctorRepo.findById(doctorId).orElse(null);

        if (doctor == null)
        {
            return new ResponseEntity<>("Doctor not found with ID: " + doctorId, HttpStatus.NOT_FOUND);
        }
        AboutInfo aboutInfo = new AboutInfo();
        aboutInfo.setDoctorInfo(doctor);
        aboutInfo.setAbout(about);

        AboutInfo saved = aboutRepo.save(aboutInfo);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/updateAbout")
    public ResponseEntity<?> updateAboutInfo(@RequestParam int doctorId, @RequestParam String about)
    {
        DoctorInfo doctor = doctorRepo.findById(doctorId).orElse(null);
        if (doctor == null)
        {
            return new ResponseEntity<>("Doctor not found with ID: " + doctorId, HttpStatus.NOT_FOUND);
        }
        AboutInfo existingAbout = aboutRepo.findByDoctorInfo_DoctorId(doctorId);

        if (existingAbout != null)
        {
            existingAbout.setAbout(about);
            AboutInfo updated = aboutRepo.save(existingAbout);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        else
        {
            AboutInfo newAbout = new AboutInfo();
            newAbout.setDoctorInfo(doctor);
            newAbout.setAbout(about);
            AboutInfo saved = aboutRepo.save(newAbout);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }
    }
}
