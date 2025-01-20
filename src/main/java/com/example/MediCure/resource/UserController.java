package com.example.MediCure.resource;

import com.example.MediCure.model.UserInfo;
import com.example.MediCure.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<UserInfo> registerUser(@RequestBody UserInfo user)
    {
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login_user/{mail}/{pass}")
    public ResponseEntity<UserInfo> loginUser(@PathVariable("mail")String mail,@PathVariable("pass")String pass)
    {
        UserInfo user = userRepo.findByUserMailAndUserPass(mail, pass);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
