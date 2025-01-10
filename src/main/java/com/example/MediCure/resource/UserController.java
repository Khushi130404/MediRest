package com.example.MediCure.resource;

import com.example.MediCure.model.DoctorInfo;
import com.example.MediCure.model.UserInfo;
import com.example.MediCure.repository.DoctorRepo;
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
    @Autowired
    DoctorRepo doctorRepo;

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
        UserInfo user = new UserInfo(name,mail,pass,Integer.parseInt(age),gender,mobile,address);
        userRepo.save(user);
        return "login_user";
    }

    @PostMapping("/login_user")
    public String loginUser(@RequestParam("mail")String mail,@RequestParam("pass")String pass)
    {
        DoctorInfo doctor = doctorRepo.findByDoctor_mailAndDoctor_pass(mail, pass);
        if(doctor==null)
        {
            UserInfo user = userRepo.findByUserMailAndUserPass(mail, pass);
            if(user!=null) return "home";
            else return "login_user";
        }
        return "home";
    }
}
