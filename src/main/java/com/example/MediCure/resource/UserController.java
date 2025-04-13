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

    @PostMapping("/update_user")
    public ResponseEntity<?> updateUser(@RequestBody UserInfo updatedUser) {
        if (updatedUser == null) {
            return new ResponseEntity<>("Invalid user data", HttpStatus.BAD_REQUEST);
        }

        UserInfo existingUser = userRepo.findByUserId(updatedUser.getUserId());
        if (existingUser == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        userRepo.updateUser(
                updatedUser.getUserId(),
                updatedUser.getUserName(),
                updatedUser.getUserMail(),
                updatedUser.getUserAge(),
                updatedUser.getUserMobile(),
                updatedUser.getUserAddress(),
                updatedUser.getUserGender()
        );

        UserInfo latestUser = userRepo.findByUserId(updatedUser.getUserId());
        return new ResponseEntity<>(latestUser, HttpStatus.OK);
    }

    @PostMapping(value = "/userInfo/{userId}")
    public ResponseEntity<UserInfo> getUserFromUserId(@PathVariable("userId")String userId)
    {
        UserInfo userInfo = userRepo.findByUserId(Integer.parseInt(userId));
        return new ResponseEntity<>(userInfo,HttpStatus.OK);
    }
}
