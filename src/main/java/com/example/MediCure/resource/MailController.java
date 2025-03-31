package com.example.MediCure.resource;

import com.example.MediCure.model.MailDto;
import com.example.MediCure.repository.MailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mail")
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
