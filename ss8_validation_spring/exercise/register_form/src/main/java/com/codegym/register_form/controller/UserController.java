package com.codegym.register_form.controller;

import com.codegym.register_form.model.User;
import com.codegym.register_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<User> list = iUserService.findAll(PageRequest.of(page, 1));
        model.addAttribute("userList", list);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/save")
    public String addNew(@Valid @ModelAttribute("user") User user,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userList", iUserService.findAll());
            return "create";
        }
        iUserService.save(user);
        model.addAttribute("msg", "Thêm mới thành công");
        return "result";
    }
}
