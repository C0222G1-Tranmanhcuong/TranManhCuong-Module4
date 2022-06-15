package com.codegym.controller;

import com.codegym.Service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam("email") String email, Model model){
        boolean isValid = this.emailService.validate(email);
        if (!isValid) {
            model.addAttribute("message", "Email is invalid");
            return "index";
        }

        model.addAttribute("email", email);
        return "success";
    }
}
