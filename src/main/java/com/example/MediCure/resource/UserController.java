package com.example.MediCure.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/")
    public String getHomePage()
    {
        return "home";
    }

    @PostMapping("/logreg")
    public String getLogReg(@RequestParam("sub")String sub)
    {
        if(sub.equals("Registration"))
        {
            return "register_user";
        }
        else
        {
            return "login_user";
        }
    }
}
