package com.codegym.smart_phone.controller;

import com.codegym.smart_phone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/phones")
public class SmartPhoneController {
    @Autowired
    private ISmartphoneService iSmartphoneService;

    @GetMapping("")
    public String showAll(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        model.addAttribute("phone", iSmartphoneService.findAll(PageRequest.of(page, 2)));
        return "/list";
    }
}
