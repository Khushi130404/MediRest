package com.example.MediCure.resource;

import com.example.MediCure.model.User_Info;
import com.example.MediCure.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserRepo userRepo;

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

    @PostMapping("/register_user")
    public String registerUser(@RequestParam("name")String name,@RequestParam("mail")String mail,@RequestParam("pass")String pass,@RequestParam("age")String age,@RequestParam("gender")String gender,@RequestParam("mobile")String mobile,@RequestParam("address")String address)
    {
        User_Info user = new User_Info(name,mail,pass,Integer.parseInt(age),gender,mobile,address);
        userRepo.save(user);
        return "login_user";
    }
}
