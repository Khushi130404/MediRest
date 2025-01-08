package com.example.MediCure.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/")
    public String getHomePage()
    {
        return "home";
    }

}
