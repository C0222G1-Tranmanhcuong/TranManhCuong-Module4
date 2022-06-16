package com.codegym.controller;

import com.codegym.model.EmailBox;
import com.codegym.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailBoxController {
    @Autowired
    private IEmailBoxService iEmailBoxService;

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("emailBox", new EmailBox());
        model.addAttribute("listLanguages", iEmailBoxService.languages());
        model.addAttribute("listPageSize", iEmailBoxService.pageSize());
        return "index";
    }

    @PostMapping("/create")
    public String createEmail(@ModelAttribute("emailBox") EmailBox emailBox, Model model) {
        model.addAttribute("emailBox", emailBox);
        return "result";
    }

}
