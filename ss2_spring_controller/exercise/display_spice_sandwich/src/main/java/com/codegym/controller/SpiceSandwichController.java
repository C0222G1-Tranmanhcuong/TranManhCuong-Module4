package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceSandwichController {
        @qMapping()
    public String home() {
        return "index";
    }

    @PostMapping("/sandwich")
    public String save(@RequestParam(value = "condiment") String[] condiment, Model model) {
        int a =1/0;
        model.addAttribute("condiment", condiment);
        return "index";
    }

}
