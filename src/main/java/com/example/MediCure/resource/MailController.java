package com.example.MediCure.resource;

import com.example.MediCure.model.MailDto;
import com.example.MediCure.repository.MailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/mail")
@CrossOrigin(origins = "http://localhost:3000")
public class MailController
{
    @Autowired
    MailRepo mr;

    @PostMapping("/sendMail")
    public void sendEmail(@RequestBody MailDto emailDto)
    {
        mr.sendSimpleMessage(emailDto.getTo(),emailDto.getSubject(),emailDto.getText());
        //emailService.sendSimpleMessage(emailDto.getTo(),emailDto.getSubject(),emailDto.getText());
    }
}
