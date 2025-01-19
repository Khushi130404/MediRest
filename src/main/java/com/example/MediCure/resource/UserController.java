package com.example.MediCure.resource;

import com.example.MediCure.model.DoctorInfo;
import com.example.MediCure.model.UserInfo;
import com.example.MediCure.repository.DoctorRepo;
import com.example.MediCure.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    DoctorRepo doctorRepo;

    @PostMapping("/register")
    public ResponseEntity<UserInfo> registerUser(@RequestBody UserInfo user)
    {
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login_user")
    public String loginUser(@RequestParam("mail")String mail,@RequestParam("pass")String pass)
    {
        DoctorInfo doctor = doctorRepo.findByDoctorMailAndDoctorPass(mail, pass);
        if(doctor==null)
        {
            UserInfo user = userRepo.findByUserMailAndUserPass(mail, pass);
            if(user!=null) return "home";
            else return "login_user";
        }
        return "home";
    }
}
