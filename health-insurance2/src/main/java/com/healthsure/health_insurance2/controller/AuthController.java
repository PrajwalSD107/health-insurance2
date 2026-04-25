package com.healthsure.health_insurance2.controller;

import com.healthsure.health_insurance2.entity.User;
import com.healthsure.health_insurance2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

@Autowired
private UserService userService;

@GetMapping("/register")
public String registerPage() {
        return "register";
}

@PostMapping("/register")
public String registerUser(@ModelAttribute User user) {

    System.out.println("REGISTER HIT: " + user.getUsername()); // 👈 add this

    user.setRole("USER");
    userService.register(user);

    return "redirect:/login";
}
    

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
