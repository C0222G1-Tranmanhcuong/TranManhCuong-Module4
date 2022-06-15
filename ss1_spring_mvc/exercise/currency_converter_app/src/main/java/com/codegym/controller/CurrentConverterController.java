package com.codegym.controller;

import com.codegym.service.ICurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrentConverterController {
    @Autowired
    private ICurrentService iCurrentService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/current")
    public String convert(@RequestParam Double usd, Model model) {
        model.addAttribute("result", iCurrentService.convertUsdToVnd(usd));
        model.addAttribute("usd", usd);
        return "index";
    }
}
