package com.example.MediCure.resource;

import com.example.MediCure.model.AdminInfo;
import com.example.MediCure.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/admin")
public class AdminController
{
    @Autowired
    private AdminRepo adminRepo;

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestParam String adminName, @RequestParam String adminPass)
    {
        AdminInfo admin = adminRepo.findByAdminNameAndAdminPass(adminName, adminPass);
        if (admin != null)
        {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
