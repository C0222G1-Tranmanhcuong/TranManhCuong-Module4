package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceSandwichController {
    @GetMapping()
    public String home() {
        return "index";
    }

    @PostMapping("/sandwich")
    public String save(@RequestParam(value = "condiment", required = true, defaultValue = "Nothing") String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "index";
    }

}
