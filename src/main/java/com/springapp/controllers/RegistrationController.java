package com.springapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
