package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleDictionaryController {
    @Autowired
    private IDictionaryService iDictionary;

    @GetMapping()
    public String home() {
        return "index";
    }

    @PostMapping("/dictonary")
    public String convert(@RequestParam String english, Model model) {
        model.addAttribute("result", iDictionary.dictionary(english));
        model.addAttribute("english", english);
        return "index";
    }
}
