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

    @PostMapping("/update_user/{userId}/{name}/{mail}/{age}/{mobile}/{address}/{gender}")
    public ResponseEntity<UserInfo> updateUser(@PathVariable("userId")String userId,@PathVariable("name")String name,@PathVariable("mail")String mail,@PathVariable("age")String age,@PathVariable("mobile")String mobile,@PathVariable("address")String address,@PathVariable("gender")String gender)
    {
        UserInfo userInfo = userRepo.findByUserId(Integer.parseInt(userId));
        userRepo.updateUser(Integer.parseInt(userId),name,mail,Integer.parseInt(age),mobile,address,gender);
        return new ResponseEntity<>(userInfo,HttpStatus.OK);
    }
}
