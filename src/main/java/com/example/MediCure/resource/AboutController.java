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


}
