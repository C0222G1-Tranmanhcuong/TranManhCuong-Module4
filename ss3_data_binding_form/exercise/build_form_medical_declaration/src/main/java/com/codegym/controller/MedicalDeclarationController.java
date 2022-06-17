package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationService iMedicalDeclarationService;

    @GetMapping()
    public String hom(Model model) {
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        model.addAttribute("listDayOfBirth", iMedicalDeclarationService.dayOfBirth());
        model.addAttribute("listGender", iMedicalDeclarationService.gender());
        model.addAttribute("listNationality", iMedicalDeclarationService.nationality());
        model.addAttribute("startDay", iMedicalDeclarationService.startDay());
        model.addAttribute("startMonth", iMedicalDeclarationService.startMonth());
        model.addAttribute("startYear", iMedicalDeclarationService.startYear());
        model.addAttribute("endDay", iMedicalDeclarationService.endDay());
        model.addAttribute("endMonth", iMedicalDeclarationService.endMonth());
        model.addAttribute("endYear", iMedicalDeclarationService.endYear());
        return "index";
    }

    @PostMapping("/medical")
    public String createEmail(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration, Model model) {
        model.addAttribute("medicalDeclaration", medicalDeclaration);
        return "result";
    }

}
